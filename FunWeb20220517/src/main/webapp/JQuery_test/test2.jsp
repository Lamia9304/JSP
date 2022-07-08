<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//jQuery/test8_json.jsp
BoardDAO boardDAO=new BoardDAO();
// 리턴할형 List<MemberDTO>  getMemberList() 정의
// List<MemberDTO> memberList= getMemberList() 호출
List<BoardDTO> boardList=boardDAO.getBoardList();
// memberList 데이터 json데이터 변경
// WEB-INF - lib - json-simple-1.1.1.jar

SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
// 배열 List =>JSONArray 
JSONArray jsonArray=new JSONArray();
for(int i=0;i<boardList.size();i++){
	BoardDTO dto=boardList.get(i);
	// MemberDTO => JSONObject
	JSONObject jsonObject=new JSONObject();
	jsonObject.put("num", dto.getNum());
	jsonObject.put("subject",dto.getSubject());
	jsonObject.put("name", dto.getName());
	jsonObject.put("date", dateFormat.format(dto.getDate()));
	jsonObject.put("readcount", dto.getReadcount());
	// JSONArray 한칸에 JSONObject 저장
	jsonArray.add(jsonObject);
}
%>
<%=jsonArray%>