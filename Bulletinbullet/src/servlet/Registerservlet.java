package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.RegisterCheckLogic;
import model.User;

@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Register.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errormsg = null;
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		User user;
		if(userid.length() != 0 && name.length() != 0 && pass.length() != 0) {
			user = new User(userid, name, pass);
		}else {
			user = null;
		}

		RegisterCheckLogic rcl = new RegisterCheckLogic();
		if(rcl.execute(user)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Registerok.jsp");
			dispatcher.forward(request, response);
		}else if(rcl.execute(user) == false) {
			errormsg = "新規登録に失敗しました";
			session.setAttribute("regerrormsg", errormsg);
			response.sendRedirect("/Bulletinbullet/Registerservlet");
		}
	}

}
