package com.demoThread.Thread.Service.Impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.demoThread.Thread.Entity.Base64Entity;
import com.demoThread.Thread.Reponsitory.Base64Reponsitory;
import com.demoThread.Thread.Service.Base64Service;

@Service
public class Base64Impl implements Base64Service {

	@Autowired
	private Base64Reponsitory reponsitory;

	@Override
	public List<Base64Entity> findAll(int i) {
		System.out.println(Thread.currentThread().getName() + " Starting Findall process " + i);
		
		List<Base64Entity> result = reponsitory.findAll();
		
		System.out.println(Thread.currentThread().getName() + " Finished Findall process " + i);
		return result;
	}

	@Override
	public Base64Entity insert(MultipartFile multipartFile, int i) {
		try {
			System.out.println(Thread.currentThread().getName() + " Starting insert process " + i);

			Base64Entity entity = new Base64Entity();
			entity.setbase64(changeimgtobase64(multipartFile));
			Base64Entity result = reponsitory.save(entity);

			System.out.println(Thread.currentThread().getName() + " Finished insert process " + i);
			return result;
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
