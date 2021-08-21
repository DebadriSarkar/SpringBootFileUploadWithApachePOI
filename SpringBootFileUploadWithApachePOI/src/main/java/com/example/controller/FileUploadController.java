package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.response.FileUploadResponse;
import com.example.service.FileUploadService;

@RestController
@RequestMapping(value = "rest")
public class FileUploadController {
	
	@Autowired
	FileUploadService service;

	@RequestMapping(value = "file-country", method = RequestMethod.POST)
	public FileUploadResponse countryupload(@RequestParam MultipartFile multipartFile) {
		FileUploadResponse response = null;
		try {
			response = service.countryupload(multipartFile);
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Exception!");
			response.setStatus("0");
		}
		return response;
	}
	
	@RequestMapping(value = "file-state", method = RequestMethod.POST)
	public FileUploadResponse stateupload(@RequestParam MultipartFile multipartFile) {
		FileUploadResponse response = null;
		try {
			response = service.stateupload(multipartFile);
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Exception!");
			response.setStatus("0");
		}
		return response;
	}
	
	@RequestMapping(value = "file-city", method = RequestMethod.POST)
	public FileUploadResponse cityupload(@RequestParam MultipartFile multipartFile) {
		FileUploadResponse response = null;
		try {
			response = service.cityupload(multipartFile);
		}catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Exception!");
			response.setStatus("0");
		}
		return response;
	}
}
