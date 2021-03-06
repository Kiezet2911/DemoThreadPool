package com.demoThread.Thread.Service.Impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.demoThread.Thread.Entity.StudentEntity;
import com.demoThread.Thread.Reponsitory.StudentReponsitory;
import com.demoThread.Thread.Service.StudentService;

@Service
public class StudentImpl implements StudentService {

	@Autowired
	private StudentReponsitory reponsitory;

	@Async
	public CompletableFuture<List<StudentEntity>> findAll() {
		System.out.println(Thread.currentThread().getName() + " Starting Findall process ");

		List<StudentEntity> result = reponsitory.findAll();

		System.out.println(Thread.currentThread().getName() + " Finished Findall process ");
		return CompletableFuture.completedFuture(result);
	}

	@Async
	public CompletableFuture<StudentEntity> insert(StudentEntity entity, int i) {
		try {

			System.out.println(Thread.currentThread().getName() + " Starting insert process " + i);
			//new 1 StudentEntity de khong bi truong hop update
			StudentEntity sv = new StudentEntity();
			sv.setName(entity.getName());
			sv.setAge(entity.getAge());
			sv.setAddress(entity.getAddress());
			
			StudentEntity result = reponsitory.save(sv);

			System.out.println(Thread.currentThread().getName() + " Finished insert process " + i);
			return CompletableFuture.completedFuture(result);
		} catch (Exception e) {
			return null;
		}
	}
}
