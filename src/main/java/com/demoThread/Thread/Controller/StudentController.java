package com.demoThread.Thread.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demoThread.Thread.Entity.StudentEntity;
import com.demoThread.Thread.Service.StudentService;

@RestController
@RequestMapping("/sv")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping
	public String insert(@RequestBody StudentEntity entity) {

		service.insert(entity, 0);

		return "Done";
	}

	@PostMapping("/{count}")
	public String insert2(@PathVariable("count") int count, @RequestBody StudentEntity entity) {
		try {

			for (int i = 0; i < count; i++) {
				service.insert(entity, 1);
			}
			return "Done";
		} catch (Exception e) {

			return e.toString();
		}
	}

	@GetMapping
	public CompletableFuture<List<StudentEntity>> findAll() {
		return service.findAll();
	}

}
