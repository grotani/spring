package com.gd.article.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.article.dto.BoardArticle;
import com.gd.article.dto.BoardFile;
import com.gd.article.dto.BoardRequest;
import com.gd.article.mapper.BoardArticleMapper;
import com.gd.article.mapper.BoardFileMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardArticleService {
	@Autowired BoardArticleMapper boardArticleMapper;
	@Autowired BoardFileMapper boardFileMapper;
	// 게시글 수정 
	public BoardArticle getBoardArticleByNo(int articleNo) {
        return boardArticleMapper.selectBoardArticleByNo(articleNo);
    }

	public int modifyBoardArticle (BoardArticle boardarticle) {
		int row = boardArticleMapper.updateBoardArticle(boardarticle);
		
	    return row;
	}
	
	public int removeBoard(int articleNo) {
	    // 연결된 파일 이름 가져오기
	    String fileName = boardFileMapper.selectFileName(articleNo);

	    // board_file 테이블에서 연결된 레코드 삭제
	    boardFileMapper.deleteBoardFile(articleNo);
	    
	    // 물리적 파일 삭제
	    if(fileName != null) {
	        File f = new File("c:/upload/"+fileName);
	        if(f.exists()) {
	            f.delete();
	        }
	    }
	    
	    // board_article 테이블에서 게시글 삭제
	    int row1 = boardArticleMapper.deleteBoardArticle(articleNo);
	    
	    return row1;
	}
	
	public void addBoard(BoardRequest boardRequest) {
		BoardArticle article = new BoardArticle();
		article.setArticleTitle(boardRequest.getBoardTitle());
		article.setArticleContent(boardRequest.getBoardContent());
		
		int row1 = boardArticleMapper.insertBoardArticle(article);
		if (row1 != 1) {
			throw new RuntimeException(); // 강제 예외처리를 발생하는 
		}
		log.debug("articleNo :" + article.getArticleNo());		
		
		// article.getArticleNo() 랑 boardRequest.getBoardFile() --> boardFile 테이블에 insert
		MultipartFile mf = boardRequest.getBoardFile();
		
		BoardFile file = new BoardFile();
		file.setArticleNo(article.getArticleNo());
		file.setOriginalName(mf.getOriginalFilename());
		file.setFileType(mf.getContentType());
		file.setFileSize(mf.getSize());
		
		
		// 저장될 파일 이름은 UUID 사용
		String prefix = UUID.randomUUID().toString().replace("-", "");
		
		int p = mf.getOriginalFilename().lastIndexOf(".");
		String suffix = mf.getOriginalFilename().substring(p);
		
		file.setFileName(prefix+suffix);	
		int row2 = boardFileMapper.insertBoardFile(file);
		if (row2 != 1) {
			throw new RuntimeException(); // 강제 예외처리를 발생하는 
		}
		 	
		
		// 파일 저장  MultiFile mf 
		// MutipartFile파일(스트림) 을 빈 emptyFile로 복사 
		File emptyFile = new File("c:/upload/"+prefix+suffix);
		try {
			mf.transferTo(emptyFile);
		} catch (Exception e) {
			e.printStackTrace();	
			throw new RuntimeException(); // 강제 예외처리를 발생시키지 않는 코드 
		}
	}
		// boardList
		public List<HashMap<String, Object>> selectBoardList(int currentPage, int rowPerPage, String searchWord){
			int beginRow = 0;
			beginRow = (currentPage -1) * rowPerPage;
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("beginRow", beginRow);
			map.put("rowPerPage", rowPerPage);
			map.put("searchWord", searchWord);
			return boardArticleMapper.selectBoardList(map);
		}
		
		public int selectBoardCount(int rowPerPage) {
			int cnt = boardArticleMapper.selectBoardCount();
			int lastPage = 0;
			if(cnt % rowPerPage == 0) {
				lastPage = cnt / rowPerPage;
			} else {
				lastPage =(cnt / rowPerPage) +1;
				
			} 
			return lastPage;	
	}
		// boardOne 상세보기 
		public Map<String, Object> selectBoardOne(int articleNo) {
	        return boardArticleMapper.selectBoardOne(articleNo);
		}
	
}
