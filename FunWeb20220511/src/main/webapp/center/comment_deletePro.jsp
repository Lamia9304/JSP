<%@page import="comment.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center/delete.jsp</title>
</head>
<body>
<%
//  delete.jsp?num=1
// request num  파라미터 값 가져오기
int comment_num=Integer.parseInt(request.getParameter("comment_num"));
// BoardDAO 객체생성
CommentDAO commentDAO=new CommentDAO();
// 리턴할형없음 deleteBoard(int num) 메서드 정의 , 조건 num=?
// deleteBoard(num)  메서드 호출
commentDAO.deleteComment(comment_num);
// notice.jsp  이동
response.sendRedirect("notice.jsp");
%>
</body>
</html>