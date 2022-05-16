package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




public class CommentDAO {
	
	
	public Connection getConnection() throws Exception{
		// throws Exception : 예외처리는 함수호출하는 곳에서 하겠다
		
		// Connection Pool : 미리 디비연결을 서버에서 하고 디비연결 자원을 불러다가 사용
		//                 : 서버에서 하나만 정의하고 자원의 이름을 불러다가 사용, 수정 최소화
		
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con=ds.getConnection();
		return con;
	}
	
	
	public CommentDTO getComment(int board_no) {
		CommentDTO commentDTO=null;
		
		Connection con=null;	
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		try {
			// 1,2 디비연결 메서드 호출
			con=getConnection();
			// 3 sql select 게시판 num 글 가져오기
			/* int num=0; */
			// 3. sql  max(num)
			
			
			
			
			sql="select * from comment where comment_board_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 4 실행 => 결과 저장
			rs=pstmt.executeQuery();
			
			// 5. 결과 다음행 데이터 있으면 max(num)+1 => num 구하기
					
		
			if(rs.next()) {
				//댓글 한개를 commentDTO 저장
				commentDTO=new CommentDTO();
				commentDTO.setComment_num(rs.getInt("comment_num"));
				commentDTO.setComment_board_no(rs.getInt("comment_board"));
				commentDTO.setComment_name(rs.getString("comment_name"));
				commentDTO.setComment_cont(rs.getString("comment_cont"));
				commentDTO.setComment_date(rs.getTimestamp("comment_date"));
			}
			      
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//마무리 기억장소 해제
			if(rs!=null) try { rs.close(); } catch (Exception e2) {	}
			if(pstmt!=null) try { pstmt.close(); } catch (Exception e2) {	}
			if(con!=null) try { con.close(); } catch (Exception e2) {	}	
		}
		return commentDTO;
	}//
	
	
	public void insertComment(CommentDTO commentDTO) {
		
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		try {
			//1,2 디비연결 메서드 호출
			con=getConnection();
			// num 구하기
			int num=0;
			// 3. sql  max(num)
			String sql="select max(comment_num) from comment";
			pstmt=con.prepareStatement(sql);
			
		
			rs=pstmt.executeQuery();
			
			// 5. 결과 다음행 데이터 있으면 max(num)+1 => num 구하기
			if(rs.next()) {
				num=rs.getInt("max(comment_num)")+1;
			}			
			// 3. sql  max(num)
			
			// 5. 결과 다음행 데이터 있으면 max(num)+1 => num 구하기
			
			//3 sql insert구문 만들기
			sql="insert into comment(comment_num,comment_board_no,comment_name,comment_cont) values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, commentDTO.getComment_board_no());
			pstmt.setString(3, commentDTO.getComment_name());
			pstmt.setString(4, commentDTO.getComment_cont());
			
			//파일
			
			
			//4 실행
			pstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//마무리 기억장소 해제
			if(rs!=null) try { rs.close(); } catch (Exception e2) {	}
			if(pstmt!=null) try { pstmt.close(); } catch (Exception e2) {	}
			if(con!=null) try { con.close(); } catch (Exception e2) {	}	
		}
	}//
		
	}
	

