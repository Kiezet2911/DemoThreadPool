package com.demoThread.Thread.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
	public List<Base64Entity> findAll(@RequestParam(value = "photo") MultipartFile[] photo)
			throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		// Có 100 request tới cùng lúc
		Future<List<Base64Entity>> future = null;
		List<Base64Entity> list = new ArrayList<Base64Entity>();
		int i = 0;
		for (MultipartFile file : photo) {
			int id = i;
			future = executor.submit(new Callable<List<Base64Entity>>() {

				@Override
				public List<Base64Entity> call() throws Exception {

					list.add(service.insert(file, id));

					return list;
				}

			});
		}
		executor.shutdown(); // Không cho threadpool nhận thêm nhiệm vụ nào nữa

		while (!executor.isTerminated()) {

			// Chờ xử lý hết các request còn chờ trong Queue ...
		}
		return future.get();
	}

	@GetMapping
	public List<Base64Entity> findAll() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		Future<List<Base64Entity>> future = null;
		for (int i = 0; i < 2; i++) {
			int id = i;
			future = executor.submit(new Callable<List<Base64Entity>>() {

				@Override
				public List<Base64Entity> call() throws Exception {
					return service.findAll(id);
				}

			});

		}
		executor.shutdown();
		return future.get();
	}

}
