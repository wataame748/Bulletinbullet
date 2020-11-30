package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Post;


public class PostDAO {
		//データベース構築に使う情報
		private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Bulletinbullet";
		private final String DB_USER = "sa";
		private final String DB_PASS = "";


  public List<Post> findAll(){
	  List<Post> postlist = new ArrayList<Post>();
	  try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
		  String sql = "SELECT POST.POSTID, NAME, DATE, TITLE, TEXT FROM USER RIGHT OUTER JOIN POST ON USER.ID = POST.POSTID ";
          PreparedStatement pStmt = conn.prepareStatement(sql);
		  ResultSet rs = pStmt.executeQuery();

		  while(rs.next()) {
			  String postid = rs.getString("POST.POSTID");
			  String name = rs.getString("NAME");
			  String title = rs.getString("TITLE");
			  String date = rs.getString("DATE");
			  String text = rs.getNString("TEXT");
			  Post post = new Post(postid, name, date, title, text);
			  postlist.add(post);
		  }
		  return postlist;
	  }catch(SQLException e) {
		  e.printStackTrace();
	      return null;
	  }

  }

  public int registerPost(Post post) {
	  try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			PreparedStatement pStmt = conn.prepareStatement
					("INSERT INTO POST (POSTID, DATE, TITLE, TEXT) VALUES (?, ?, ?, ?)");
			pStmt.setString(1, post.getPostid());
			pStmt.setString(2, post.getDate());
			pStmt.setString(3, post.getTitle());
			pStmt.setString(4, post.getText());
			 int r = pStmt.executeUpdate();
			pStmt.close();
			return r;
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
	    }
  }
  }