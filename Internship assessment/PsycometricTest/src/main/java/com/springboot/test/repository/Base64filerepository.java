package com.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.entity.Base64file;

public interface Base64filerepository extends JpaRepository<Base64file, Long>{

}
