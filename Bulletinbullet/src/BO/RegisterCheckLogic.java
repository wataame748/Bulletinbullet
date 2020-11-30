package BO;

import DAO.RegisterDAO;
import model.User;
public class RegisterCheckLogic {
	public boolean execute(User user) {
		if(user == null) {return false;}
		RegisterDAO rdao = new RegisterDAO();
		int check = rdao.registerUser(user);
		if(check != 0) {return true;}
		else {return false;}
	}
}
