<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
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
// String id = 세션값 가져오기
String id=(String)session.getAttribute("id");
// MemberDAO 객체생성
MemberDAO memberDAO=new MemberDAO();
// public 리턴할형 MemberDTO 함수이름 getMember(String id)  메서드 정의
// MemberDTO memberDTO =  getMember(id) 메서드 호출
MemberDTO memberDTO=memberDAO.getMember(id);
%>


<% 




%>



</body>
</html>