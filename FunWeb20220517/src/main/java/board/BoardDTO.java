package board;

import java.sql.Timestamp;

public class BoardDTO {
  private int num;
  
  private String name;
  
  private String pass;
  
  private String subject;
  
  private String content;
  
  private int readcount;
  
  private Timestamp date;
  
  private String file;
  
  public String getFile() {
    return this.file;
  }
  
  public void setFile(String file) {
    this.file = file;
  }
  
  public int getNum() {
    return this.num;
  }
  
  public void setNum(int num) {
    this.num = num;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPass() {
    return this.pass;
  }
  
  public void setPass(String pass) {
    this.pass = pass;
  }
  
  public String getSubject() {
    return this.subject;
  }
  
  public void setSubject(String subject) {
    this.subject = subject;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public int getReadcount() {
    return this.readcount;
  }
  
  public void setReadcount(int readcount) {
    this.readcount = readcount;
  }
  
  public Timestamp getDate() {
    return this.date;
  }
  
  public void setDate(Timestamp date) {
    this.date = date;
  }
}
