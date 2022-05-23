package com.demoThread.Thread.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.demoThread.Thread.Entity.Base64Entity;

public interface Base64Service {

	List<Base64Entity> findAll(int i);

	Base64Entity insert(MultipartFile multipartFile,int i);
}
