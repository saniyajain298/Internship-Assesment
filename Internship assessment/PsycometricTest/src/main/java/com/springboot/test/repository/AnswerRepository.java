package com.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
