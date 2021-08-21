package com.example.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.crud.entity.CityEntity;
import com.example.crud.entity.CountryEntity;
import com.example.crud.entity.StateEntity;
import com.example.crud.repository.CityRepository;
import com.example.crud.repository.CountryRepository;
import com.example.crud.repository.StateRepository;
import com.example.model.response.FileUploadResponse;
import com.example.utility.StringConstants;

@Service
public class FileUploadService {
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;

	public FileUploadResponse countryupload(MultipartFile file) throws Exception{
		boolean flag = false;
		FileUploadResponse response = new FileUploadResponse();
		DataFormatter df = new DataFormatter();
		String tmpStr = "";
		if(file.isEmpty()) {
			response.setMessage("Please select a file and try again");
			response.setStatus("0");
		}
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MMM_dd_hh_mm_ss");
		String time = dateFormat.format(now);
		File dir = new File(StringConstants.UPLOAD_FOLDER + time);
		dir.mkdir();
		String filepath = dir + "/" + file.getOriginalFilename();
		File outputfile = new File(filepath);
		try(FileOutputStream fop = new FileOutputStream(outputfile)) {
			if (!outputfile.exists()) {
				outputfile.createNewFile();
			}
			byte[] contentInBytes = file.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
		}catch (Exception e) {
			e.printStackTrace();
			filepath = "";
		}
		FileInputStream fis=new FileInputStream(new File(filepath));  
		XSSFWorkbook wb=new XSSFWorkbook(fis);   
		XSSFSheet sheet=wb.getSheetAt(0);  
		XSSFRow row;
		int rows = sheet.getPhysicalNumberOfRows();
		List<CountryEntity> list = new ArrayList<>();
		for(int r=1;r<=rows;r++) {
			row = sheet.getRow(r);
			if(row!=null) {
				CountryEntity countryEntity = new CountryEntity();
				for(int j = 0; j <= row.getLastCellNum(); j++) {
					if(null != row.getCell(j)) {
						CellAddress ca = row.getCell(j).getAddress();
						tmpStr = df.formatCellValue(row.getCell(j));
						if(tmpStr != null && ca.getColumn() == 0) {
							countryEntity.setCountryId(Integer.parseInt(tmpStr));
						}else if(tmpStr != null && ca.getColumn() == 1) {
							countryEntity.setSortname(tmpStr);
						}else if(tmpStr != null && ca.getColumn() == 2) {
							countryEntity.setName(tmpStr);
						}else if(tmpStr != null && ca.getColumn() == 3) {
							countryEntity.setPhonecode(Integer.parseInt(tmpStr));
						}
					}
				}
				list.add(countryEntity);
			}
		}
		if(list.size()!=0) {
			countryRepository.saveAll(list);
			flag = true;
			response.setMessage("Uploaded Successfull");
			response.setStatus("1");
			response.setFilepath(filepath);
		}else {
			response.setMessage("Not Uploaded");
			response.setStatus("0");
			response.setFilepath(filepath);
		}
		return response;
		
	}
	
	public FileUploadResponse stateupload(MultipartFile file) throws Exception{
		boolean flag = false;
		FileUploadResponse response = new FileUploadResponse();
		DataFormatter df = new DataFormatter();
		String tmpStr = "";
		if(file.isEmpty()) {
			response.setMessage("Please select a file and try again");
			response.setStatus("0");
		}
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MMM_dd_hh_mm_ss");
		String time = dateFormat.format(now);
		File dir = new File(StringConstants.UPLOAD_FOLDER + time);
		dir.mkdir();
		String filepath = dir + "/" + file.getOriginalFilename();
		File outputfile = new File(filepath);
		try(FileOutputStream fop = new FileOutputStream(outputfile)) {
			if (!outputfile.exists()) {
				outputfile.createNewFile();
			}
			byte[] contentInBytes = file.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
		}catch (Exception e) {
			e.printStackTrace();
			filepath = "";
		}
		FileInputStream fis=new FileInputStream(new File(filepath));  
		XSSFWorkbook wb=new XSSFWorkbook(fis);   
		XSSFSheet sheet=wb.getSheetAt(0);  
		XSSFRow row;
		int rows = sheet.getPhysicalNumberOfRows();
		List<StateEntity> list = new ArrayList<>();
		for(int r=1;r<=rows;r++) {
			row = sheet.getRow(r);
			if(row!=null) {
				StateEntity stateEntity = new StateEntity();
				for(int j = 0; j <= row.getLastCellNum(); j++) {
					if(null != row.getCell(j)) {
						CellAddress ca = row.getCell(j).getAddress();
						tmpStr = df.formatCellValue(row.getCell(j));
						if(tmpStr != null && ca.getColumn() == 0) {
							stateEntity.setStateId(Integer.parseInt(tmpStr));
						}else if(tmpStr != null && ca.getColumn() == 1) {
							stateEntity.setName(tmpStr);
						}else if(tmpStr != null && ca.getColumn() == 2) {
							stateEntity.setCountryId(Integer.parseInt(tmpStr));
						}
					}
				}
				list.add(stateEntity);
			}
		}
		if(list.size()!=0) {
			stateRepository.saveAll(list);
			flag = true;
			response.setMessage("Uploaded Successfull");
			response.setStatus("1");
			response.setFilepath(filepath);
		}else {
			response.setMessage("Not Uploaded");
			response.setStatus("0");
			response.setFilepath(filepath);
		}
		return response;
		
	}
	
	public FileUploadResponse cityupload(MultipartFile file) throws Exception{
		boolean flag = false;
		FileUploadResponse response = new FileUploadResponse();
		DataFormatter df = new DataFormatter();
		String tmpStr = "";
		if(file.isEmpty()) {
			response.setMessage("Please select a file and try again");
			response.setStatus("0");
		}
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MMM_dd_hh_mm_ss");
		String time = dateFormat.format(now);
		File dir = new File(StringConstants.UPLOAD_FOLDER + time);
		dir.mkdir();
		String filepath = dir + "/" + file.getOriginalFilename();
		File outputfile = new File(filepath);
		try(FileOutputStream fop = new FileOutputStream(outputfile)) {
			if (!outputfile.exists()) {
				outputfile.createNewFile();
			}
			byte[] contentInBytes = file.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
		}catch (Exception e) {
			e.printStackTrace();
			filepath = "";
		}
		FileInputStream fis=new FileInputStream(new File(filepath));  
		XSSFWorkbook wb=new XSSFWorkbook(fis);   
		XSSFSheet sheet=wb.getSheetAt(0);  
		XSSFRow row;
		int rows = sheet.getPhysicalNumberOfRows();
		List<CityEntity> list = new ArrayList<>();
		for(int r=1;r<=rows;r++) {
			row = sheet.getRow(r);
			if(row!=null) {
				CityEntity cityEntity = new CityEntity();
				for(int j = 0; j <= row.getLastCellNum(); j++) {
					if(null != row.getCell(j)) {
						CellAddress ca = row.getCell(j).getAddress();
						tmpStr = df.formatCellValue(row.getCell(j));
						if(tmpStr != null && ca.getColumn() == 0) {
							cityEntity.setCityId(Integer.parseInt(tmpStr));
						}else if(tmpStr != null && ca.getColumn() == 1) {
							cityEntity.setName(tmpStr);
						}else if(tmpStr != null && ca.getColumn() == 2) {
							cityEntity.setStateId(Integer.parseInt(tmpStr));
						}
					}
				}
				list.add(cityEntity);
			}
		}
		if(list.size()!=0) {
			cityRepository.saveAll(list);
			flag = true;
			response.setMessage("Uploaded Successfull");
			response.setStatus("1");
			response.setFilepath(filepath);
		}else {
			response.setMessage("Not Uploaded");
			response.setStatus("0");
			response.setFilepath(filepath);
		}
		return response;
		
	}
	
	
	
}
