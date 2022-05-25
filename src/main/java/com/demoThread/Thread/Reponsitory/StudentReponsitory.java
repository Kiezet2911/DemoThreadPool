package com.demoThread.Thread.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoThread.Thread.Entity.StudentEntity;

@Repository
public interface StudentReponsitory extends JpaRepository<StudentEntity, Long> {

}
