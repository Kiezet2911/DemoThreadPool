package com.demoThread.Thread.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demoThread.Thread.Entity.Base64Entity;
import com.demoThread.Thread.Service.Base64Service;

@RestController
@RequestMapping("/base64")
public class Base64Controller {
	@Autowired
	private Base64Service service;

	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String insert(@RequestParam(value = "photo") MultipartFile[] photo)
			throws InterruptedException, ExecutionException {
		//for theo so luong file truyen vao
		for (MultipartFile file : photo) {
			service.insert(file);
		}

		return "Done";
	}

	@GetMapping
	public CompletableFuture<List<Base64Entity>> findAll() throws InterruptedException, ExecutionException {
		return service.findAll();
	}

}
