package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class CommentDAO {
  public Connection getConnection() throws Exception {
    Context init = new InitialContext();
    DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
    Connection con = ds.getConnection();
    return con;
  }
  
  
  public List<CommentDTO> getCommentList(int board_num) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<CommentDTO> commentList = new ArrayList<>();
	    try {
	      con = getConnection();
	      String sql = "select * from comment where comment_board_no=?";
	      pstmt = con.prepareStatement(sql);
	      pstmt.setInt(1, board_num);
	      
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	        CommentDTO commentDTO = new CommentDTO();
	        commentDTO.setComment_num(rs.getInt("comment_num"));
	        commentDTO.setComment_board_no(rs.getInt("comment_board_no"));
	        commentDTO.setComment_name(rs.getString("comment_name"));
	        commentDTO.setComment_cont(rs.getString("comment_cont"));
	        commentDTO.setComment_date(rs.getTimestamp("comment_date"));
	        
	        
	        commentList.add(commentDTO);
	      } 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (rs != null)
	        try {
	          rs.close();
	        } catch (Exception exception) {} 
	      if (pstmt != null)
	        try {
	          pstmt.close();
	        } catch (Exception exception) {} 
	      if (con != null)
	        try {
	          con.close();
	        } catch (Exception exception) {} 
	    } 
	    return commentList;
	  }
  
  
  
  
  
  
  public CommentDTO getComment(int num) {
    CommentDTO commentDTO = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      String sql = "select * from comment where comment_board_no=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, num);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        commentDTO = new CommentDTO();
        commentDTO.setComment_num(rs.getInt("comment_num"));
        commentDTO.setComment_board_no(rs.getInt("comment_board"));
        commentDTO.setComment_name(rs.getString("comment_name"));
        commentDTO.setComment_cont(rs.getString("comment_cont"));
        commentDTO.setComment_date(rs.getTimestamp("comment_date"));
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (Exception exception) {} 
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (Exception exception) {} 
      if (con != null)
        try {
          con.close();
        } catch (Exception exception) {} 
    } 
    return commentDTO;
  }
  
  public void insertComment(CommentDTO commentDTO) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      
      
      int num = 0;
      String sql = "select max(comment_num) from comment";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if (rs.next())
        num = rs.getInt("max(comment_num)") + 1; 
      
      sql = "insert into comment(comment_num,comment_board_no,comment_name,comment_cont,comment_date) values(?,?,?,?,now())";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, num);
      pstmt.setInt(2, commentDTO.getComment_board_no());
      pstmt.setString(3, commentDTO.getComment_name());
      pstmt.setString(4, commentDTO.getComment_cont());
   
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (Exception exception) {} 
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (Exception exception) {} 
      if (con != null)
        try {
          con.close();
        } catch (Exception exception) {} 
    } 
  }
  
  public void deleteComment(int num) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	      con = getConnection();
	      String sql = "delete from comment where comment_num=?";
	      pstmt = con.prepareStatement(sql);
	      pstmt.setInt(1, num);
	      pstmt.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (rs != null)
	        try {
	          rs.close();
	        } catch (Exception exception) {} 
	      if (pstmt != null)
	        try {
	          pstmt.close();
	        } catch (Exception exception) {} 
	      if (con != null)
	        try {
	          con.close();
	        } catch (Exception exception) {} 
	    } 
	  }
  
  
  public void updateComment(CommentDTO commentDTO) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	      con = getConnection();
	      String sql = "update comment set comment_cont=? where comment_num=?";
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, commentDTO.getComment_cont());
	      pstmt.setInt(2, commentDTO.getComment_num());
	     
	      pstmt.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (rs != null)
	        try {
	          rs.close();
	        } catch (Exception exception) {} 
	      if (pstmt != null)
	        try {
	          pstmt.close();
	        } catch (Exception exception) {} 
	      if (con != null)
	        try {
	          con.close();
	        } catch (Exception exception) {} 
	    } 
	  }
  
  
}
