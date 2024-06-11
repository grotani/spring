package com.gd.article.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@Controller
public class UploadTest {
   
   //파일 가져오기
   @GetMapping("/fileUpload")
   public String fileUpload() {
      return "fileUpload";
   }
   
   
   // 파일을 저장하는 액션
   @PostMapping("/fileUpload")
   public String fileUpload(
         @RequestParam(name="title") String title,
         MultipartFile item) {
      // RequestParam name = title  < 이건 fileUpload.jsp 에서 input의 name이랑 바인딩 됨
      // MultipartFile file  < 이건 fileUpload.jsp 에서 input의 name이 item이랑 바인딩 됨
      
      log.debug("controller title : " + title);
      log.debug("controller item : " + item.toString());     

      log.debug(item.getOriginalFilename());
      log.debug(item.getContentType());
      log.debug(""+item.getSize());
      
      
      return "";
   }
   
}
