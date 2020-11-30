package model;

import java.io.Serializable;

public class User implements Serializable{
	private String userid;
	private String name;
	private String pass;
  public User() {}
  public User(String userid, String name, String pass) {
	  this.userid = userid;
	  this.name = name;
	  this.pass = pass;
  }
  public String getUserid() {return this.userid;}
  public String getName() {return this.name;}
  public String getPass() {return this.pass;}
}
