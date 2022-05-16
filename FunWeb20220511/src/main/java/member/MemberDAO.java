package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
  public Connection getConnection() throws Exception {
    Context init = new InitialContext();
    DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
    Connection con = ds.getConnection();
    return con;
  }
  
  public void insertMember(MemberDTO memberDTO) {
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
      con = getConnection();
      String sql = "insert into member(id,pass,name,date,email,address,phone,mobile) values(?,?,?,now(),?,?,?,?)";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, memberDTO.getId());
      pstmt.setString(2, memberDTO.getPass());
      pstmt.setString(3, memberDTO.getName());
      pstmt.setString(4, memberDTO.getEmail());
      pstmt.setString(5, memberDTO.getAddress());
      pstmt.setString(6, memberDTO.getPhone());
      pstmt.setString(7, memberDTO.getMobile());
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
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
  
  public MemberDTO userCheck(String id, String pass) {
    MemberDTO memberDTO = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      String sql = "select * from member where id=? and pass=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pass);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        memberDTO = new MemberDTO();
        memberDTO.setId(rs.getString("id"));
        memberDTO.setPass(rs.getString("pass"));
        memberDTO.setName(rs.getString("name"));
        memberDTO.setDate(rs.getTimestamp("date"));
        memberDTO.setEmail(rs.getString("email"));
        memberDTO.setAddress(rs.getString("address"));
        memberDTO.setPhone(rs.getString("phone"));
        memberDTO.setMobile(rs.getString("mobile"));
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
    return memberDTO;
  }
  
  public MemberDTO getMember(String id) {
    MemberDTO memberDTO = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      con = getConnection();
      String sql = "select * from member where id=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        memberDTO = new MemberDTO();
        memberDTO.setId(rs.getString("id"));
        memberDTO.setPass(rs.getString("pass"));
        memberDTO.setName(rs.getString("name"));
        memberDTO.setDate(rs.getTimestamp("date"));
        memberDTO.setEmail(rs.getString("email"));
        memberDTO.setAddress(rs.getString("address"));
        memberDTO.setPhone(rs.getString("phone"));
        memberDTO.setMobile(rs.getString("mobile"));
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
    return memberDTO;
  }
  
  public void updateMember(MemberDTO updateDTO) {
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
      con = getConnection();
      String sql = "update member set name=?,email=?,address=?,phone=?,mobile=? where id=?";
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, updateDTO.getName());
      pstmt.setString(2, updateDTO.getEmail());
      pstmt.setString(3, updateDTO.getAddress());
      pstmt.setString(4, updateDTO.getPhone());
      pstmt.setString(5, updateDTO.getMobile());
      pstmt.setString(6, updateDTO.getId());
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
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
