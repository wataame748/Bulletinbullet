package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class RegisterDAO {
		private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Bulletinbullet";
		private final String DB_USER = "sa";
		private final String DB_PASS = "";


public int registerUser(User user) {
	try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
		PreparedStatement pStmt = conn.prepareStatement
				("INSERT INTO USER (ID, NAME, PASSWORD) VALUES (?, ?, ?)");
		pStmt.setString(1, user.getUserid());
		pStmt.setString(2, user.getName());
		pStmt.setString(3, user.getPass());
		 int r = pStmt.executeUpdate();
		pStmt.close();
		return r;
	}catch(SQLException e) {
		e.printStackTrace();
		return 0;
	}
}
}
