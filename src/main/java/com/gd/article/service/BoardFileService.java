package com.gd.article.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.article.dto.BoardFile;
import com.gd.article.dto.BoardFileRequest;
import com.gd.article.mapper.BoardFileMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardFileService {
	@Autowired BoardFileMapper boardFileMapper;
	
    public String selectFileNameByKey(int fileNo) {
        return boardFileMapper.selectFileNameByKey(fileNo);
    }
    
	public  void modifyboardFile (int fileNo, BoardFileRequest boardFileRequest) { 
		// boardFileRequest ==> fileNo(수정할 키) + multipartFile(새로 수정된 파일)
		
		// boardFileRequest ==> boardFile 
		BoardFile file = new BoardFile();
		MultipartFile mf = boardFileRequest.getFile();
		
		  // 새로운 파일이 업로드되었는지 확인

	    	log.debug("ggg");
	        file.setOriginalName(mf.getOriginalFilename());
	        file.setFileType(mf.getContentType());
	        file.setFileSize(mf.getSize());
	        String prefix = UUID.randomUUID().toString().replace("-", "");
	        int p = mf.getOriginalFilename().lastIndexOf(".");
	        String suffix = mf.getOriginalFilename().substring(p);
	        file.setFileName(prefix + suffix);   
	        
	        file.setFileNo(fileNo);
	    
	        // row 수정 
	        int row = boardFileMapper.updateBoardFile(file);
	        
	        // 파일교체 = 이전파일 삭제하고 새로운 파일 입력 
	        // 수정전 파일 삭제 
	        if(row == 1) {
	            String preFileName = boardFileMapper.selectFileNameByKey(boardFileRequest.getFileNo());
	            if(preFileName != null) {
	                File f = new File("c:/upload/"+preFileName);
	                if(f.exists()) {
	                    f.delete();
	                }
	            }
	            
	            File emptyFile = new File("c:/upload/"+ file.getFileName());
	            try {
	                mf.transferTo(emptyFile);
	            } catch (Exception e) {
	                e.printStackTrace();    
	                throw new RuntimeException();
	            }
	        }
	    
	}
}
