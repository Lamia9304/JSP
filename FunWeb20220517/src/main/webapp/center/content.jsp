<%@page import="comment.CommentDAO"%>
<%@page import="comment.CommentDTO"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../script/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	if(${id== null}) {
        alert("게시판을 이용하시려면 로그인하셔야 합니다.");
        location.href="../member/login.jsp";
    }
	
	  $(document).on("click","#d", function(){
		  $("#table").hide();
		   $("#content").show();
		   $("#d").hide();
		  
		
		  
		  }); 
	 
	  $(document).on("click","#btn", function(){
		   $("#content").hide();
		   $("#table").show();
		   $("#d").show();
		   
		  
		  }); 
	
	  
});




	


</script>



<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
 
 <style>
 
 #content{
 display: none;
 
 }
 	
 
 </style>
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 메인이미지 -->
<div id="sub_img_center"></div>
<!-- 메인이미지 -->

<!-- 왼쪽메뉴 -->
<jsp:include page="../inc/sub_menu.jsp"></jsp:include>
<!-- 왼쪽메뉴 -->
<!-- 게시판 -->







<%

String id=(String)session.getAttribute("id");


//세션값이 없으면 (id null 이면 ) login.jsp 이동

if(id==null){
	%>
	<script type="text/javascript">
	alert("로그인 하세요");
	location.href="../member/login.jsp";
</script>
<% 
}



// content.jsp?num=1
// request 에서 num 가져오기 
int num=Integer.parseInt(request.getParameter("num"));
// BoardDAO 객체생성
BoardDAO boardDAO=new BoardDAO();
CommentDAO commentDAO=new CommentDAO();

// 게시판 글 조회수 1 증가
// 리턴할형 없음 updateReadcount(int num)메서드 정의 
// update board set readcount = readcount +1 where num=? 
// updateReadcount(num)메서드 호출
boardDAO.updateReadcount(num);


// 리턴할형 BoardDTO  getBoard(int num)메서드 정의 
// BoardDTO boardDTO = getBoard(num) 메서드 호출
BoardDTO boardDTO=boardDAO.getBoard(num);

List<CommentDTO> commentList=commentDAO.getCommentList(num);


%>
<article>
<h1>게시판</h1>
<table id="notice">
<tr><td>글번호</td><td><%=boardDTO.getNum() %></td>
    <td>등록일</td><td><%=boardDTO.getDate() %></td></tr>
<tr><td>글쓴이</td><td><%=boardDTO.getName() %></td>
    <td>조회수</td><td><%=boardDTO.getReadcount() %></td></tr>
<tr><td>글제목</td><td colspan="3"><%=boardDTO.getSubject() %></td></tr>
<tr><td>글내용</td><td colspan="3"><%=boardDTO.getContent() %></td></tr>
</table>


<form method="post" name="comment" action="commentPro.jsp">
		<input type="hidden" name="no" value="<%=boardDTO.getNum()%>">
		<table>
		
			<tr>
				<td colspan="2" align="left">
					<b>댓글</b>
				</td>
			</tr>
			
			<tr>
			
				<td><input type="text" name="c_name" placeholder="닉네임" size="8" value="<%=id %>" readonly ></td>
				<td><input type="text" name="c_content" placeholder="댓글 내용" size="30" style="height:50px;"></td>
				<td><input type="submit" value="등록" class="submit"></td>
			</tr>
			
			
			<%-- <tr>
				<td>댓글 번호</td><td><%=commentDTO.getComment_num() %></td>
				<td>댓글 게시물 번호</td>
				<td></td>
			</tr> --%>
			
		</table>
</form>

<%
    // 배열크기 : boardList.size()
    for(int i=0;i<commentList.size();i++){
    	//배열 한칸 데이터 가져올때 boardList.get()
    	// 모든형 => 자식형 형변화(다운캐스팅)
//     	BoardDTO boardDTO=(BoardDTO)boardList.get(i);
    	// List<BoardDTO> 데이터 타입으로 가져오면 형변환없이 사용가능
    	CommentDTO commentDTO=commentList.get(i);
    	
    	%>
    	
    	<table id="table">
<tr><td>작성자</td><td><%=commentDTO.getComment_name()%></td></tr>
<tr>
<td>내용</td><td><%=commentDTO.getComment_cont() %></td>
<td>작성일자</td><td><%=commentDTO.getComment_date() %></td>
<td>댓글번호</td><td><%=commentDTO.getComment_num() %></td>
<td></td>
</tr>

</table>

<a href="#" id="d">수정</a>
<a href="comment_deletePro.jsp?num=<%=commentDTO.getComment_num()%>" onclick='return confirm("삭제하시겠습니까?");'>삭제</a>
<% 
if(id!=null){
	// 로그인 글쓴이 비교
	if(id.equals(commentDTO.getComment_name())){
		%>

<form method="post" name="content"  action="comment_updatePro.jsp?num=<%=commentDTO.getComment_num()%>" id="content">
<table>	
<tr>
<td><input type="submit"  id="btn" class="btn"  value="수정하기" ><button id="d">취소</button></td>
</tr>
<tr><td><input type="text" name="c_content" size="30" style="height:50px;" value=<%=commentDTO.getComment_cont() %>></td></tr>
</table>
</form>

		<%
	}
}


    }
%>


	









<div id="table_search">
<%
// 로그인id , 글쓴이boardDTO.getName()  일치하면 => 글수정, 글삭제 버튼 보이기
// String id = 세션값 가져오기

// 세션값 null 이 아니면 
if(id!=null){
	// 로그인 글쓴이 비교
	if(id.equals(boardDTO.getName())){
		%>
<input type="button" value="글수정" class="btn" onclick="location.href='update.jsp?num=<%=boardDTO.getNum()%>'"/>
<input type="button" value="글삭제" class="btn" onclick="location.href='delete.jsp?num=<%=boardDTO.getNum()%>'"/>		
		<%
	}
}
%>
<input type="button" value="글목록" class="btn" onclick="location.href='notice.jsp'"/>
</div>
<div class="clear"></div>
</article>
<!-- 게시판 -->
<!-- 본문들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>