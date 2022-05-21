package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
  public Connection getConnection() throws Exception {
    Context init = new InitialContext();
    DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
    Connection con = ds.getConnection();
    return con;
  }
  
  public void insertBoard(BoardDTO boardDTO) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      int num = 0;
      String sql = "select max(num) from board";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if (rs.next())
        num = rs.getInt("max(num)") + 1; 
      sql = "insert into board(num,name,pass,subject,content,readcount,date,file) values(?,?,?,?,?,?,now(),?)";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, num);
      pstmt.setString(2, boardDTO.getName());
      pstmt.setString(3, boardDTO.getPass());
      pstmt.setString(4, boardDTO.getSubject());
      pstmt.setString(5, boardDTO.getContent());
      pstmt.setInt(6, boardDTO.getReadcount());
      pstmt.setString(7, boardDTO.getFile());
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
  
  public List<BoardDTO> getBoardList(int startRow, int pageSize) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<BoardDTO> boardList = new ArrayList<>();
    try {
      con = getConnection();
      String sql = "select * from board order by num desc limit ?,?";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, startRow - 1);
      pstmt.setInt(2, pageSize);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setNum(rs.getInt("num"));
        boardDTO.setPass(rs.getString("pass"));
        boardDTO.setName(rs.getString("name"));
        boardDTO.setSubject(rs.getString("subject"));
        boardDTO.setContent(rs.getString("content"));
        boardDTO.setReadcount(rs.getInt("readcount"));
        boardDTO.setDate(rs.getTimestamp("date"));
        boardDTO.setFile(rs.getString("file"));
        boardList.add(boardDTO);
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
    return boardList;
  }
  
  public BoardDTO getBoard(int num) {
    BoardDTO boardDTO = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      String sql = "select * from board where num=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, num);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        boardDTO = new BoardDTO();
        boardDTO.setNum(rs.getInt("num"));
        boardDTO.setPass(rs.getString("pass"));
        boardDTO.setName(rs.getString("name"));
        boardDTO.setSubject(rs.getString("subject"));
        boardDTO.setContent(rs.getString("content"));
        boardDTO.setReadcount(rs.getInt("readcount"));
        boardDTO.setDate(rs.getTimestamp("date"));
        boardDTO.setFile(rs.getString("file"));
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
    return boardDTO;
  }
  
  
  
  
  
  
  
  public List<BoardDTO> getBoardList2(int pageSize) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<BoardDTO> boardList = new ArrayList<>();
    try {
      con = getConnection();
      String sql = "select * from board order by num desc limit ?";
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, pageSize);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setNum(rs.getInt("num"));
        boardDTO.setPass(rs.getString("pass"));
        boardDTO.setName(rs.getString("name"));
        boardDTO.setSubject(rs.getString("subject"));
        boardDTO.setContent(rs.getString("content"));
        boardDTO.setReadcount(rs.getInt("readcount"));
        boardDTO.setDate(rs.getTimestamp("date"));
        boardDTO.setFile(rs.getString("file"));
        boardList.add(boardDTO);
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
    return boardList;
  }
  
  
  
  public List<BoardDTO> getBoardList3(int h_pageSize) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<BoardDTO> boardList = new ArrayList<>();
	    try {
	      con = getConnection();
	      String sql = "select * from board order by readcount desc limit ?";
	      pstmt = con.prepareStatement(sql);
	      pstmt.setInt(1, h_pageSize);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	        BoardDTO boardDTO = new BoardDTO();
	        boardDTO.setNum(rs.getInt("num"));
	        boardDTO.setPass(rs.getString("pass"));
	        boardDTO.setName(rs.getString("name"));
	        boardDTO.setSubject(rs.getString("subject"));
	        boardDTO.setContent(rs.getString("content"));
	        boardDTO.setReadcount(rs.getInt("readcount"));
	        boardDTO.setDate(rs.getTimestamp("date"));
	        boardDTO.setFile(rs.getString("file"));
	        boardList.add(boardDTO);
	      } 
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("d");
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
	    return boardList;
	  }
  
  public void updateReadcount(int num) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      String sql = "update board set readcount = readcount +1 where num=?";
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
  
  public void updateBoard(BoardDTO boardDTO) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      String sql = "update board set subject=?, content=?, file=? where num=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, boardDTO.getSubject());
      pstmt.setString(2, boardDTO.getContent());
      pstmt.setString(3, boardDTO.getFile());
      pstmt.setInt(4, boardDTO.getNum());
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
  
  public void deleteBoard(int num) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      String sql = "delete from board where num=?";
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
  
  public int getBoardCount() {
    int count = 0;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      String sql = "select count(*) from board";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if (rs.next())
        count = rs.getInt("count(*)"); 
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
    return count;
  }
  
  public List<BoardDTO> getSearch(String searchField, String searchText) {
    List<BoardDTO> list = new ArrayList<>();
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String SQL = "select * from board WHERE " + searchField.trim();
    System.out.println(SQL);
    try {
      con = getConnection();
      if (searchText != null && !searchText.equals(""))
        SQL = String.valueOf(SQL) + " LIKE'%" + searchText.trim() + "%' order by num desc"; 
      System.out.println(SQL);
      pstmt = con.prepareStatement(SQL);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setNum(rs.getInt("num"));
        boardDTO.setPass(rs.getString("pass"));
        boardDTO.setName(rs.getString("name"));
        boardDTO.setSubject(rs.getString("subject"));
        boardDTO.setContent(rs.getString("content"));
        boardDTO.setReadcount(rs.getInt("readcount"));
        boardDTO.setDate(rs.getTimestamp("date"));
        boardDTO.setFile(rs.getString("file"));
        list.add(boardDTO);
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return list;
  }
}
