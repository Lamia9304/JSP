<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/front.css" rel="stylesheet" type="text/css">

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


</head>
<body>
<div id="wrap">
<!-- 헤더파일들어가는 곳 -->
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더파일들어가는 곳 -->
<!-- 메인이미지 들어가는곳 -->
<div class="clear"></div>
<div id="main_img"><img src="../images/main_img.jpg"
 width="971" height="282"></div>
<!-- 메인이미지 들어가는곳 -->
<!-- 메인 콘텐츠 들어가는 곳 -->
<article id="front">
<div id="solution">
<div id="hosting">







<h3>Web Hosting Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
<div id="security">
<h3>Web Security Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
<div id="payment">
<h3>Web Payment Solution</h3>
<p>Lorem impsun Lorem impsunLorem impsunLorem
 impsunLorem impsunLorem impsunLorem impsunLorem
  impsunLorem impsunLorem impsun....</p>
</div>
</div>
<div class="clear"></div>


<%
// BoardDAO 객체 생성
 int h_pageSize=2;

BoardDAO boardDAO=new BoardDAO();
List<BoardDTO> boardList=boardDAO.getBoardList3(h_pageSize);

%>
<div id="sec_news">
<h3><span class="orange">조회수</span> 게시글</h3>
<% 

    // 배열크기 : boardList.size()
    for(int i=0;i<boardList.size();i++){
    	//배열 한칸 데이터 가져올때 boardList.get()
    	// 모든형 => 자식형 형변화(다운캐스팅)
//     	BoardDTO boardDTO=(BoardDTO)boardList.get(i);
    	// List<BoardDTO> 데이터 타입으로 가져오면 형변환없이 사용가능
    	BoardDTO boardDTO=boardList.get(i);
    	%>
    	


<dl>
<dt><%=boardDTO.getSubject() %></dt>
<dd><%=boardDTO.getContent() %></dd>
</dl>
<dl>

</dl>


  

 
    <% 
    	   	}
 %>
 
 </div>





 <%
     
     


  // 한페이지에 보여줄 글개수 지정
  int pageSize=5;

  //http://localhost:8080/FunWeb/center/notice.jsp
  //http://localhost:8080/FunWeb/center/notice.jsp?pageNum=2
  // 페이지 번호 가져오기 
  String pageNum=request.getParameter("pageNum");
  // 페이지 번호가 없으면 "1"페이지 지정
  if(pageNum==null){
  	pageNum="1";
  }
  // pageNum   pageSize 조합해서 => startRow 시작하는 행번호 구하기 => 식(알고리즘)
  // pageNum => 문자열 정수형 변경 
  int currentPage=Integer.parseInt(pageNum);
  // pageNum pageSize  => startRow
//      1       10     =>    (1-1)*10+1=> 0*10+1=> 0+1=>1
//      2       10     =>    (2-1)*10+1=> 1*10+1=>10+1=>11
//      3       10     =>    (3-1)*10+1=> 2*10+1=>20+1=>21
  int startRow =(currentPage-1)*pageSize+1; 

  // startRow pageSize 조합해서 => endRow 끝나는 행번호 구하기 => 식(알고리즘)
  // startRow pageSize  => endRow
//      1        10     =>   10
//      11       10     =>   20
//      21       10     =>   30
  int endRow=startRow+pageSize-1;


  // 리턴할형 List   getBoardList()메서드 정의
  // BoardDTO 여러개를 담을수 있는 자바 배열형태의 내장객체List에 담아서 리턴받아옴
  // List<BoardDTO> boardList = getBoardList() 메서드 호출
  // List<BoardDTO> boardList=boardDAO.getBoardList();
  // List<BoardDTO> boardList=boardDAO.getBoardList(시작하는 행번호,한페이지 보여줄글개수);
  // select * from board order by num desc limit 시작하는 행번호-1,한페이지 보여줄글개수
  List<BoardDTO> boardList2=boardDAO.getBoardList2(pageSize);

  //날짜 => 문자열(원하는 포맷) 변경
  SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
  %>

<div id="news_notice"> 
<h3 class="brown">News &amp; Notice</h3>
<table>
 <%
    // 배열크기 : boardList.size()
    for(int i=0;i<boardList2.size();i++){
    	//배열 한칸 데이터 가져올때 boardList.get()
    	// 모든형 => 자식형 형변화(다운캐스팅)
//     	BoardDTO boardDTO=(BoardDTO)boardList.get(i);
    	// List<BoardDTO> 데이터 타입으로 가져오면 형변환없이 사용가능
    	BoardDTO boardDTO=boardList2.get(i);
    	%>
    	
 

   <tr><td class="contxt"><a href="../center/content.jsp?num=<%=boardDTO.getNum()%>"><%=boardDTO.getSubject()%></a></td>
    <td><%=dateFormat.format(boardDTO.getDate()) %></td></tr>

 
    <% 
    	   	}
 %>

</table> 



    
 

</div>



</article>
<!-- 메인 콘텐츠 들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터 들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터 들어가는 곳 -->
</div>
</body>
</html>