package com.blog.blog_app_apis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog_app_apis.entities.Catagory;
import com.blog.blog_app_apis.exeption.ResourceNotFoundException;
import com.blog.blog_app_apis.payloads.CatagoryDto;
import com.blog.blog_app_apis.repository.CatagoryRepo;
import com.blog.blog_app_apis.services.CatagoryService;

@Service
public class CatagoryServiceImpl implements CatagoryService {

	@Autowired
	private CatagoryRepo catagoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CatagoryDto createCatagory(CatagoryDto catagoryDto) {

	    Catagory cat = this.modelMapper.map(catagoryDto, Catagory.class);
		Catagory addCatagory = this.catagoryRepo.save(cat);
		return this.modelMapper.map(addCatagory, CatagoryDto.class);
		
	}

	@Override
	public CatagoryDto updateCatagory(CatagoryDto catagoryDto, Integer catagoryId) {
		Catagory cat = this.catagoryRepo.findById(catagoryId).orElseThrow(()-> new ResourceNotFoundException("Catagory", "Catagory id", catagoryId));
		cat.setCatagoryTitle(catagoryDto.getCatagoryTitle());
		cat.setCatagoryDescription(catagoryDto.getCatagoryDescription());
		
		Catagory updatedcat =this.catagoryRepo.save(cat);
		
		return this.modelMapper.map(updatedcat, CatagoryDto.class);
	}

	@Override
	public void deleteCatagory(Integer catagoryId) {
		
		Catagory cat = this.catagoryRepo.findById(catagoryId).orElseThrow(() -> new ResourceNotFoundException("Catagory", "catagoryId", catagoryId));
		this.catagoryRepo.delete(cat);

	}

	@Override
	public CatagoryDto getCatagory(Integer catagoryId) {
		Catagory cat = this.catagoryRepo.findById(catagoryId).orElseThrow(() -> new ResourceNotFoundException("Catagory", "catagoryId", catagoryId));
		
		return this.modelMapper.map(cat, CatagoryDto.class);
	}

	@Override
	public List<CatagoryDto> getCatagories() {
		
		List<Catagory> catagories = this.catagoryRepo.findAll();
		List<CatagoryDto> catDto = catagories.stream().map((cat)-> this.modelMapper.map(cat, CatagoryDto.class)).collect(Collectors.toList());
		return catDto;
	}

}
