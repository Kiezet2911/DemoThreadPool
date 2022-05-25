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
@RequestMapping("/sv")
public class Base64Controller {
	@Autowired
	private Base64Service service;

	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String insert(@RequestParam(value = "photo") MultipartFile[] photo)
			throws InterruptedException, ExecutionException {
		for (MultipartFile file : photo) {

			service.insert(file);
		}

		return "Done";
	}

//	@PostMapping("/{count}")
//	public List<Base64Entity> insert2(@PathVariable("count") int count, @RequestParam(value = "photo") MultipartFile photo)
//			throws InterruptedException, ExecutionException {
//		ExecutorService executor = Executors.newFixedThreadPool(5);
//
//		Future<List<Base64Entity>> future = null;
//		List<Base64Entity> list = new ArrayList<Base64Entity>();
//
//		for (int i = 0; i < count; i++) {
//			int id = i;
//			future = executor.submit(new Callable<List<Base64Entity>>() {
//
//				@Override
//				public List<Base64Entity> call() throws Exception {
//
//					list.add(service.insert(photo, id));
//
//					return list;
//				}
//
//			});
//		}
//		executor.shutdown();
//
//		return future.get();
//	}

	@GetMapping
	public CompletableFuture<List<Base64Entity>> findAll() throws InterruptedException, ExecutionException {
		return service.findAll();
	}

}
