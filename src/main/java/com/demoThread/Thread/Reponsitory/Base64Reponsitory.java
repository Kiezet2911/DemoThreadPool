package com.demoThread.Thread.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoThread.Thread.Entity.Base64Entity;

@Repository
public interface Base64Reponsitory extends JpaRepository<Base64Entity, Long> {

}
