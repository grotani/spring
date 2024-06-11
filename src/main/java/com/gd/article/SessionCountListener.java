package com.gd.article;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionCountListener implements HttpSessionListener {
  
	
    public void sessionCreated(HttpSessionEvent se)  { 
    	// application.getAttribute("currentCnt") 1 증가
    	ServletContext application = se.getSession().getServletContext();
    	Integer i = (Integer)(application.getAttribute("currentCnt"));
    	application.setAttribute("currentCnt", i+1);
    	

    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
    	// application.getAttribute("currentCnt") 1 감소
    	ServletContext application = se.getSession().getServletContext();
    	Integer i = (Integer)(application.getAttribute("currentCnt"));
    	application.setAttribute("currentCnt", i-1);
    }
	
}
