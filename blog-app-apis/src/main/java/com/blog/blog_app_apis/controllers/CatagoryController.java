package com.blog.blog_app_apis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog_app_apis.payloads.ApiResponse;
import com.blog.blog_app_apis.payloads.CatagoryDto;
import com.blog.blog_app_apis.services.CatagoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/catagories")
public class CatagoryController {
	
	@Autowired
	private CatagoryService catagoryService;
	
	@PostMapping("/")
	public ResponseEntity<CatagoryDto> createCatagory(@Valid @RequestBody CatagoryDto catagoryDto)
	{
		CatagoryDto createCatagory = this.catagoryService.createCatagory(catagoryDto);
		
		return new ResponseEntity<CatagoryDto>(createCatagory, HttpStatus.CREATED);
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<CatagoryDto> updateCatagory(@Valid @RequestBody CatagoryDto catagoryDto, @PathVariable Integer catId)
	{
		CatagoryDto updateCatagory = this.catagoryService.updateCatagory(catagoryDto, catId);
		
		return new ResponseEntity<CatagoryDto>(updateCatagory, HttpStatus.OK);
	}
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCatagory(@PathVariable Integer catId)
	{
		 this.catagoryService.deleteCatagory(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Catagory is deleted succesfully !!", true), HttpStatus.OK);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CatagoryDto> getCatagory(@PathVariable Integer catId)
	{
		CatagoryDto catagoryDto =  this.catagoryService.getCatagory(catId);
		
		return new ResponseEntity<CatagoryDto>(catagoryDto, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CatagoryDto>> getCatagoryDto()
	{
		List<CatagoryDto> catagories = this.catagoryService.getCatagories();
		return ResponseEntity.ok(catagories);
	}

}
