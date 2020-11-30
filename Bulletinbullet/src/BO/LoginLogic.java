package BO;

import DAO.UserDAO;
import model.Login;
import model.User;
public class LoginLogic {
	public boolean execute(Login login) {
		UserDAO dao = new UserDAO();
		User result = dao.findByLogin(login);
		if(result != null && login.getUserid().equals(result.getUserid()) && login.getPass().equals(result.getPass())) {
		return true;}
		else {
			return false;}
		}
	}

