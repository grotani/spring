package com.gd.article.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.article.dto.BoardArticle;
import com.gd.article.dto.BoardFileRequest;
import com.gd.article.dto.BoardRequest;
import com.gd.article.service.BoardArticleService;
import com.gd.article.service.BoardFileService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class BoardController {
	@Autowired BoardArticleService boardArticleService;
	@Autowired BoardFileService boardFileService;

	// 파일업로드 
	@GetMapping("addBoard")
		public String addboard() {
		return "addBoard";
	}
	// 파일업로드 액션 
	@PostMapping("/addBoard")
	public String addBoard(BoardRequest boardRequest) {
		log.debug("BoardTitle+:" + boardRequest.getBoardTitle());
		log.debug("BoardContent+:" + boardRequest.getBoardContent());
		log.debug("BoardFile.orginalName:"+ boardRequest.getBoardFile().getOriginalFilename());
	
		boardArticleService.addBoard(boardRequest);
		return "redirect:/boardList";
	}
	
	// bordList 페이지 
	@GetMapping("/boardList")
	public String boardList(Model model,
			@RequestParam(name = "currentPage", defaultValue ="1") int currentPage,
			@RequestParam(name="rowPerPage", defaultValue = "5") int rowPerPage,
			@RequestParam(name = "searchWord", defaultValue = "") String searchWord
			) {
		List<HashMap<String,Object>> list = boardArticleService.selectBoardList(currentPage, rowPerPage, searchWord);
		log.debug(toString());
		int lastPage = boardArticleService.selectBoardCount(rowPerPage);
		model.addAttribute("list", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", "searchWord");
		return "boardList";
		
	}	
	
	// boardOne 상세보기
	@GetMapping("/boardOne")
	public String boardOne (Model model,
						@RequestParam(name = "articleNo") int articleNo) {
		Map<String, Object> board = boardArticleService.selectBoardOne(articleNo);
        model.addAttribute("board", board);
        return "boardOne";
	}
	

	// removeBoard 게시글 삭제	   
	@GetMapping("/removeBoard")
	public String removeBoard(@RequestParam(name="articleNo") int articleNo) {
	log.debug("articleNo :"+ articleNo);
	int row = boardArticleService.removeBoard(articleNo);
	log.debug("row:" + row);
	return "redirect:/boardList";
   }
   
	// 파일 수정하기 
    @GetMapping("/modifyFile")
    public String modifyFile(Model model,
	                            @RequestParam(name = "fileNo") int fileNo) {
    	log.debug("fileNo: " + fileNo);	       
	       // 파일 번호를 사용하여 파일 정보를 가져옴
	       String fileName = boardFileService.selectFileNameByKey(fileNo);
	       // 파일 정보를 모델에 추가
	       model.addAttribute("fileName", fileName);
	       model.addAttribute("fileNo", fileNo);
	       
	       return "modifyFile"; // 파일 수정 폼 페이지 이름 반환
	   }

    // 파일 수정액션 처리
    @PostMapping("/modifyBoard")
    public String modifyBoard(@RequestParam(name = "fileNo") int fileNo, BoardFileRequest boardFileRequest) {
    // 파일 수정 서비스 호출
    boardFileService.modifyboardFile(fileNo, boardFileRequest);
   
    return "redirect:/boardList";
   }
    // 게시글 수정 폼
    @GetMapping("/modifyBoardArticle")
    public String modifyBoardArticle(@RequestParam(name = "articleNo") int articleNo, Model model) {
        BoardArticle boardArticle = boardArticleService.getBoardArticleByNo(articleNo);
        log.debug("boardArticle: "+boardArticle);
        model.addAttribute("boardArticle", boardArticle); // 모델에 boardArticle 객체 추가
        return "modifyBoardArticle"; // 수정 폼 페이지로 이동
    }

    // 게시글 수정 액션
    @PostMapping("/modifyBoardArticle")
    public String modifyBoardArticlePost(@RequestParam(name = "articleNo") int articleNo, BoardArticle boardarticle) {
        boardArticleService.modifyBoardArticle(boardarticle);
        log.debug("boardarticle"+boardarticle.toString());
        return "redirect:/boardOne?articleNo=" + articleNo; // 수정 후 해당 게시글 페이지로 이동
    }
    

}

	

