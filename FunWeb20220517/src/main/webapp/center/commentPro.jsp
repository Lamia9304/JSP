<%@page import="comment.CommentDTO"%>
<%@page import="comment.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
request.setCharacterEncoding("utf-8");

String comment_no=request.getParameter("no");
String comment_name=request.getParameter("c_name");
String comment_content=request.getParameter("c_content");
String comment_pwd=request.getParameter("c_pwd");






//request 한글처리







//패키지 board 파일 commentDTO
//멤버변수 정의 , set get메서드 정의
//commentDTO 객체생성



CommentDTO commentDTO=new CommentDTO();
//set메서드 호출 파라미터값 저장 <= pass name subject content readcount
commentDTO.setComment_name(comment_name);
commentDTO.setComment_cont(comment_content);
commentDTO.setComment_name(comment_name);
commentDTO.setComment_board_no(Integer.parseInt(comment_no));




//패키지 board 파일 BoardDAO
//BoardDAO 객체생성
CommentDAO commentDAO=new CommentDAO();
//리턴할형 없음 insertBoard(commentDTO commentDTO) 메서드 정의
//insertBoard(commentDTO 주소값) 호출
commentDAO.insertComment(commentDTO);


//notice.jsp 이동

response.sendRedirect("content.jsp?num="+comment_no);




%>
</body>
</html>