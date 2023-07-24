package com.springboot.test.service;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.test.entity.Questions;
import com.springboot.test.entity.User;


@Service
public class StorageService {
	
	
	@Autowired 
	private SaveToDatabase savedb;
	
	@SuppressWarnings("unchecked")
	public <T> ResponseEntity<JSONObject> getRequest(User user, int questionNo,T ans) throws IOException{
		
		JSONObject json = new JSONObject();

		if(user.getUserid() == 0 && questionNo!=1) {
			json.put("Status", "error");
			json.put("Response", "Enter valid user id or select corrct question");
		}
		if(ans.getClass().getName().equals("java.lang.String")) {
			String answer = ans.toString();
			if(questionNo ==1 && user.getUserid() ==0) {
				json = savedb.saveUserName(answer);
			}
			
			else if(questionNo ==2 && user.getUserid()!=0) {
				json = savedb.saveEmail(answer, user.getUserid());
				System.out.println(json);
			}
			
			else if(questionNo == 4 && user.getUserid()!=0) {
				json = savedb.saveText(answer, user.getUserid());
			}
			
			else if((questionNo>4 && questionNo<104 ) && user.getUserid()!=0) {
				Questions question = new Questions();
				question.setQuestionId(questionNo);
				json = savedb.saveAnswer(answer, user, question);
			}
			else {
				json.put("Status", "error");
				json.put("Response", "Invalid inputs");
			}
		}
		else if(questionNo==3 &&ans.getClass().getName().equals("org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile")) {
			System.out.println("File name");
			MultipartFile answer = (MultipartFile) ans;
			json = savedb.saveFile(answer, user);
			
		}
		else {
			json.put("Status", "error");
			json.put("Response", "Invalid answer with question");
		}
		return new ResponseEntity<JSONObject>(json, HttpStatus.CREATED);
		
	}
	
}




