package com.blog.blog_app_apis.services;

import java.util.List;

import com.blog.blog_app_apis.payloads.CatagoryDto;

public interface CatagoryService {

  public CatagoryDto createCatagory(CatagoryDto catagoryDto);
  
  public CatagoryDto updateCatagory(CatagoryDto catagoryDto, Integer catagoryId);
  
  public void deleteCatagory(Integer catagoryId);
  
  public CatagoryDto getCatagory(Integer catagoryId);
  
  public List<CatagoryDto> getCatagories();
  

}
