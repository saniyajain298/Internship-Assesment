package com.springboot.test.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Base64file {

		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		private Long fileid;
		private String filename;
		private String filetype;
		
		@Lob
		@Column(length = 1000)
		private byte[] imageData;
		
		@OneToOne
		@JoinColumn(name="userid", referencedColumnName="userid")
		private User userid;
		
		@Override
		public String toString() {
			return "Base64file [fileid=" + fileid + ", filename=" + filename + ", filetype=" + filetype + ", imageData="
					+ Arrays.toString(imageData) + ", userid=" + userid + "]";
		}
}
