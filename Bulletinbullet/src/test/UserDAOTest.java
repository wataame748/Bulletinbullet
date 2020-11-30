package test;

import DAO.UserDAO;
import model.Login;
import model.User;
public class UserDAOTest {
	public static void main(String[] args) {
		testFindByLogin1();
	}
	public static void testFindByLogin1() {
		Login login = new Login("wataame2001@gmail.com", "Wataru0720");
		UserDAO dao = new UserDAO();
		User result = dao.findByLogin(login);
		if (
				result != null &&
				result.getUserid().equals("wataame2001@gmail.com") &&
				result.getName().equals("wataru") &&
				result.getPass().equals("Wataru0720")
				) {
			System.out.println("test1成功");
		}else {System.out.println("test1失敗");}
	}
}
