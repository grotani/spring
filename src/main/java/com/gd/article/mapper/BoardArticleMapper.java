package com.gd.article.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.article.dto.BoardArticle;
import com.gd.article.dto.BoardRequest;

@Mapper
public interface BoardArticleMapper {
	// 게시글 수정하기
	int updateBoardArticle(BoardArticle boardarticle);
	
	// 게시글 가져오기
    BoardArticle selectBoardArticleByNo(int articleNo);
    
	// boardAtricle 삭제 -> boardFile도 같이 삭제
	int deleteBoardArticle(int articleNo);
	
	// boardAtricle One LEFT JOIN boardFile 상세보기 
	Map<String, Object> selectBoardOne(int articleNo);
	
	 int insertBoardArticle(BoardArticle article);
	 List<HashMap<String, Object>> selectBoardList(HashMap<String, Object> map);
	 //List<Map<String, Object>> selectBoardList(Map<String, Object> map);
	 int selectBoardCount();
}
