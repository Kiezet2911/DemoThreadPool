package com.demoThread.Thread.Service.Impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.demoThread.Thread.Entity.Base64Entity;
import com.demoThread.Thread.Reponsitory.Base64Reponsitory;
import com.demoThread.Thread.Service.Base64Service;

@Service
public class Base64Impl implements Base64Service {

	@Autowired
	private Base64Reponsitory reponsitory;

	@Async
	public CompletableFuture<List<Base64Entity>> findAll() {
		System.out.println(Thread.currentThread().getName() + " Starting Findall process ");

		List<Base64Entity> result = reponsitory.findAll();

		System.out.println(Thread.currentThread().getName() + " Finished Findall process ");
		return CompletableFuture.completedFuture(result);
	}

	@Async
	public CompletableFuture<Base64Entity> insert(MultipartFile multipartFile) {
		try {
			System.out.println(Thread.currentThread().getName() + " Starting insert process " );

			Base64Entity entity = new Base64Entity();
			entity.setbase64(changeimgtobase64(multipartFile));
			Base64Entity result = reponsitory.save(entity);

			System.out.println(Thread.currentThread().getName() + " Finished insert process ");
			return CompletableFuture.completedFuture(result);
		} catch (Exception e) {
			return null;
		}
	}

	public byte[] changeimgtobase64(MultipartFile photo) throws IOException {
		byte[] encodedBytes = Base64.getEncoder().encode(photo.getBytes());
		// System.out.println(encodedBytes);

		return encodedBytes;
	}
}
