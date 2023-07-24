package com.springboot.test.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.json.simple.JSONObject;
import com.springboot.test.repository.AnswerRepository;
import com.springboot.test.repository.QuestionRepository;
import com.springboot.test.repository.UserRepository;
import com.springboot.test.service.StorageService;
import com.springboot.test.entity.Questions;
import com.springboot.test.entity.User;

@RestController
public class HomeController {
	
	@Autowired
	public UserRepository userrepo;
	
	@Autowired
	public AnswerRepository answerRepo; 
	
	@Autowired
	public QuestionRepository questionRepo;

	@Autowired
	public StorageService service;
	
	@GetMapping("/")
	public  String index() {
		return "Welcome to wspring boot test";
	}
	
	@PostMapping(value = "/saveuserdetails", consumes = { MediaType.APPLICATION_JSON_VALUE,
														 MediaType.MULTIPART_FORM_DATA_VALUE})
	public <T> Object saveuserdetails(@RequestParam(defaultValue  = "0", required=false) Long userid,@RequestParam int questionNo,@RequestParam T answer)   throws IOException {
		User user = new User();
		user.setUserid(userid);
		
		if(user.getUserid() == 0) {
			user.setUserid(0L);
	    }
		
		ResponseEntity<JSONObject> response = service.getRequest(user, questionNo, answer);
		return response;
	}
	
	@GetMapping("/getquestion")
	public Optional<Questions> getquestion(Integer questionNo){
		Optional<Questions> qlist= questionRepo.findById(questionNo);
		return qlist;
	}
	
	
	
}
