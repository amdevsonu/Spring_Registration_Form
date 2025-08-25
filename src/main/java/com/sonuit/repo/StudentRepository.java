package com.sonuit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonuit.entity.StudentEntity;

public interface StudentRepository extends JpaRepository <StudentEntity, Integer>{

}
