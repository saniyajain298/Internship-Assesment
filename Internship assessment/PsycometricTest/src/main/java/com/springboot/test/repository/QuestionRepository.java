package com.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.test.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer>{

}
