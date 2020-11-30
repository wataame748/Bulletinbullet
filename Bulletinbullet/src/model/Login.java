package model;

import java.io.Serializable;

public class Login implements Serializable{
	private String userid;
	private String pass;
  public Login() {}
  public Login(String userid, String pass) {
	  this.userid = userid;
	  this.pass = pass;
  }
  public String getUserid() {return this.userid;}
  public String getPass() {return this.pass;}
}
