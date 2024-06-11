package com.gd.article.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.article.dto.BoardFile;

@Mapper
public interface BoardFileMapper {
	// 파일  번호 가져오기  파일 하나를 수정하기 위한 목적
	String selectFileNameByKey(int fileNo);

	// 첨부파일 수정하기 
	int updateBoardFile(BoardFile f);
	
	// 파일 이름 가져오기 
	String selectFileName(int articleNo);
	
	// 파일삭제 
	int deleteBoardFile(int articleNo);
	
	// 파일 업로드 
	int insertBoardFile(BoardFile file);
}
