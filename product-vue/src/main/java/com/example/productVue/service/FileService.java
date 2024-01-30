package com.example.productVue.service;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.example.productVue.exception.MyFileNotFoundException;

@Service
public class FileService {
	public Resource loadFileAsResource(String fileName) {
		System.out.println(fileName);
		try {
			Path targetLocation = Paths.get("C\\Users\\jykim\\Desktop".toString()).resolve(fileName);
			Resource resource = new UrlResource(targetLocation.toUri());
			
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (Exception ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}
}
