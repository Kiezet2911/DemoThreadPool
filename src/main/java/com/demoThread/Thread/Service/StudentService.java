package com.demoThread.Thread.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.demoThread.Thread.Entity.StudentEntity;

public interface StudentService {

	@Async
	CompletableFuture<List<StudentEntity>> findAll();

	@Async
	CompletableFuture<StudentEntity> insert(StudentEntity entity, int i);
}
