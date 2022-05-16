package comment;

import java.sql.Timestamp;

public class CommentDTO {
	
	private int comment_num;
	private int comment_board_no;
	private String comment_name;
	private String comment_cont;
	 private Timestamp comment_date;
	 
	 
	 
	public Timestamp getComment_date() {
		return comment_date;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getComment_board_no() {
		return comment_board_no;
	}
	public void setComment_board_no(int comment_board_no) {
		this.comment_board_no = comment_board_no;
	}
	public String getComment_name() {
		return comment_name;
	}
	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}
	public String getComment_cont() {
		return comment_cont;
	}
	public void setComment_cont(String comment_cont) {
		this.comment_cont = comment_cont;
	}
	
	public void setComment_date(Timestamp timestamp) {
		// TODO Auto-generated method stub
		
	}
	 
	 
	
	
}
