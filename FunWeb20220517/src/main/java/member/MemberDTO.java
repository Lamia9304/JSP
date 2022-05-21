package member;

import java.sql.Timestamp;

public class MemberDTO {
  private String id;
  
  private String pass;
  
  private String name;
  
  private Timestamp date;
  
  
  private String postcode;
  
  private String email;
  
  private String address;
  private String address2;
  
  private String phone;
  
  private String mobile;
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getPass() {
    return this.pass;
  }
  
  public void setPass(String pass) {
    this.pass = pass;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Timestamp getDate() {
    return this.date;
  }
  
  public String getPostcode() {
	return postcode;
}

public void setPostcode(String postcode) {
	this.postcode = postcode;
}

public String getAddress2() {
	return address2;
}

public void setAddress2(String address2) {
	this.address2 = address2;
}

public void setDate(Timestamp date) {
    this.date = date;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getAddress() {
    return this.address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getPhone() {
    return this.phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public String getMobile() {
    return this.mobile;
  }
  
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }
}
