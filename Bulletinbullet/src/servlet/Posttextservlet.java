package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PosttextDAO;
import model.Post;


@WebServlet("/Posttextservlet")
public class Posttextservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Post post;
		PosttextDAO ptdao = new PosttextDAO();
		//useridとpdateを取得
		String userid = request.getParameter("userid");
		String pdate = request.getParameter("pdate");
		post = ptdao.findPost(userid, pdate);
		if(post != null) {
			session.setAttribute("Post", post);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Posttext.jsp");
			dispatcher.forward(request, response);
		}else {
			String posterrormsg = "閲覧に失敗しました";
			session.setAttribute("posterrormsg",posterrormsg);
			response.sendRedirect("/Bulletinbullet/Postservlet");
		}
	}
}
