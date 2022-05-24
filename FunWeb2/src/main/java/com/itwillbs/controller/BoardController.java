package com.itwillbs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet{

	// 서블릿 상속 =>  서블릿 파일이 됨
	// 서블릿 doGet()  doPost() ... 메서드 서블릿 호출
	// doGet() doPost() 메서드 재정의 (메서드 오버라이딩)
	
	
protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardController doPro()");
		
		// 가상주소 => 실페이지 연결 주소매핑
		
		
		// 가상주소 뽑아오기 
		// URL http://localhost:8080/FunWeb2/join.me
		// URI  /FunWeb2/write.bo =>8부터 끝까지 뽑아오기 
		// 프로젝트경로 /FunWeb2 => 8
		// 찾는 주소   /join.me
		
		String uri=request.getRequestURI();
		System.out.println(uri);
		String projectPath=request.getContextPath();
		System.out.println(projectPath);
		String path= uri.substring(projectPath.length());
		
		System.out.println(path);
		if(path.equals("/write.bo")) {
//			/write.bo => center/write.jsp 매핑
			RequestDispatcher dispatcher=request.getRequestDispatcher("center/write.jsp");
			dispatcher.forward(request, response);
		}else if(path.equals("/writePro.bo")) {
			System.out.println("/writePro.bo 매핑");
			//디비파일
			//notice.me 주소가 바뀌면서 이동 
			response.sendRedirect("notice.bo");
			
		}else if(path.equals("/notice.bo")){
			//center/notice.jsp 이동
			RequestDispatcher dispatcher=request.getRequestDispatcher("/center/notice.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardController doGet() ");
		doPro(requset,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardController doPost() ");
		doPro(request,response);
		
	}
	
	
	
	
	
	
}
