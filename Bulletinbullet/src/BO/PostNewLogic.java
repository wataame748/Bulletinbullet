package BO;

import DAO.PostDAO;
import model.Post;
public class PostNewLogic {
	public boolean execute(Post post) {
		if(post == null) {return false;}
		PostDAO dao = new PostDAO();
		int check = dao.registerPost(post);
		if(check != 0) {return true;}
		else {return false;}
	}
}
