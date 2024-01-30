package com.example.productVue.controller;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.productVue.service.FileService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class FileController {
	private final FileService fileService;
	
	@PostMapping("/api/file/download")
	public ResponseEntity<Resource> download(HttpServletRequest request, @RequestParam(name="filename") String filename) {
		//TODO: process POST request
		Resource resource = fileService.loadFileAsResource(filename);
		
		String contentType = null;
		
		try {
			filename = URLEncoder.encode(filename, "UTF-8").replace("+", "%20");
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
		}
 
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + filename).body(resource);
	}
	
}
