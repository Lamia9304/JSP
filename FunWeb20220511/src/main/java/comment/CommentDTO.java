package comment;

import java.sql.Timestamp;

public class CommentDTO {
  private int comment_num;
  
  private int comment_board_no;
  
  private String comment_name;
  
  private String comment_cont;
  
  private Timestamp comment_date;
  
  public Timestamp getComment_date() {
    return this.comment_date;
  }
  
  public int getComment_num() {
    return this.comment_num;
  }
  
  public void setComment_num(int comment_num) {
    this.comment_num = comment_num;
  }
  
  public int getComment_board_no() {
    return this.comment_board_no;
  }
  
  public void setComment_board_no(int comment_board_no) {
    this.comment_board_no = comment_board_no;
  }
  
  public String getComment_name() {
    return this.comment_name;
  }
  
  public void setComment_name(String comment_name) {
    this.comment_name = comment_name;
  }
  
  public String getComment_cont() {
    return this.comment_cont;
  }
  
  public void setComment_cont(String comment_cont) {
    this.comment_cont = comment_cont;
  }
  
  public void setComment_date(Timestamp comment_date) {
	  this.comment_date=comment_date;
  }
}
