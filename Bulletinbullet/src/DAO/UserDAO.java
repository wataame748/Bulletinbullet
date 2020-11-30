package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.User;

public class UserDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Bulletinbullet";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	public User findByLogin(Login login) {
		User user = null;
		//データベース接続の処理
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT ID, NAME, PASSWORD FROM USER WHERE ID = ? AND PASSWORD = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserid());
			pStmt.setString(2, login.getPass());
			ResultSet rs = pStmt.executeQuery();
			if( rs.next()) {
			String ID = rs.getString("ID");
			String NAME = rs.getString("NAME");
			String PASS = rs.getString("PASSWORD");
			user = new User(ID, NAME, PASS);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
}
