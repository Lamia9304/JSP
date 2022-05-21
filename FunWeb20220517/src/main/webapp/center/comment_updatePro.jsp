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


String comment_num=(request.getParameter("num"));







String referer = request.getHeader("REFERER");
String content=request.getParameter("c_content");



CommentDTO commentDTO=new CommentDTO();

commentDTO.setComment_cont(content);
commentDTO.setComment_num(Integer.parseInt(comment_num));

// BoardDAO 객체생성
CommentDAO commentDAO=new CommentDAO();
// 리턴할형없음 deleteBoard(int num) 메서드 정의 , 조건 num=?
// deleteBoard(num)  메서드 호출
commentDAO.updateComment(commentDTO);
// notice.jsp  이동

response.sendRedirect(referer);


%>


</body>
</html>