package model;

import java.io.Serializable;

public class Post implements Serializable{
	private String postid;
	private String date;
	private String title;
	private String text;
	private String username;
  public Post() {}
  public Post(String postid, String username, String date, String title, String text) {
	  this.postid = postid;
	  this.date = date;
	  this.title = title;
	  this.text = text;
	  this.username = username;
  }
  public String getPostid(){return this.postid;}
  public String getDate() {return this.date;}
  public String getTitle() {return this.title;}
  public String getText() {return this.text;}
  public String getUsername() {return this.username;}

  }

