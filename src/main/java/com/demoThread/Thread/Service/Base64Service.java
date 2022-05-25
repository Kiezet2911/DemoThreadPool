package com.demoThread.Thread.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import com.demoThread.Thread.Entity.Base64Entity;

public interface Base64Service {

	@Async
	CompletableFuture<List<Base64Entity>> findAll();

	@Async
	CompletableFuture<Base64Entity> insert(MultipartFile multipartFile);
}
