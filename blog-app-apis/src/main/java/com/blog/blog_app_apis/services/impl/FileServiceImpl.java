package com.blog.blog_app_apis.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.blog_app_apis.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		String name = file.getOriginalFilename();
		
		//random name generate file
		String randomID = UUID.randomUUID().toString();
	    String fileName1 = randomID.concat(name).substring(name.lastIndexOf("."));
	    
	    //FullPath 
	    String filePath = path + File.separator + fileName1;
	    
	    //created folder if not created
	    File f = new File(path);
	    if(!f.exists())
	    {
	    	f.mkdir();
	    }
	    
	    //file copy
	    Files.copy(file.getInputStream(), Paths.get(filePath));
	    
	    return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path+File.separator+fileName;
		InputStream is = new FileInputStream(fullPath);
		return is;

}
	
}
