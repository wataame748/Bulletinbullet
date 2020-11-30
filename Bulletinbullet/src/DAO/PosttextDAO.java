package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Post;

public class PosttextDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Bulletinbullet";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
  public Post findPost(String userid, String pdate){
	  try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
		  String sql = "SELECT POST.POSTID, NAME, DATE, TITLE, TEXT FROM USER RIGHT OUTER JOIN POST ON USER.ID = POST.POSTID WHERE POST.POSTID=? AND DATE=? ";
          PreparedStatement pStmt = conn.prepareStatement(sql);
          pStmt.setString(1,userid);
          pStmt.setString(2,pdate);
		  ResultSet rs = pStmt.executeQuery();
		  Post post = null;
		  if(rs.next()) {
			  String postid = rs.getString("POST.POSTID");
			  String name = rs.getString("NAME");
			  String title = rs.getString("TITLE");
			  String date = rs.getString("DATE");
			  String text = rs.getNString("TEXT");
			  post = new Post(postid, name, date, title, text);
		  }
		  return post;
	  }catch(SQLException e) {
		  e.printStackTrace();
	      return null;
	  }
  }
}
