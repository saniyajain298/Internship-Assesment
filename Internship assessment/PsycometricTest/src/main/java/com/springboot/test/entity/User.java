package com.springboot.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long userid;
	private String name = null;
	@Column(unique=true)
	private String email = null;
	private String text = null;

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}
	
	
	
}
