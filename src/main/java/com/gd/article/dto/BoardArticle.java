package com.gd.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter , setter 만들기
@NoArgsConstructor // 
@AllArgsConstructor // 매개변수 다 있는 생성자 
public class BoardArticle {
	private int articleNo;
	private String articleTitle;
	private String articleContent;
	private String updateDate;
	private String createDate;
	
}
