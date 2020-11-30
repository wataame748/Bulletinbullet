package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.PostNewLogic;
import DAO.PostDAO;
import model.Post;
import model.User;

@WebServlet("/Postservlet")
public class Postservlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ポストリストを取得
		PostDAO dao = new PostDAO();
		List<Post> postlist = dao.findAll();
		//ポストリストをセッションスコープへ保存
		HttpSession session = request.getSession();
		session.setAttribute("postlist", postlist);
		//Post.jsp へフォワード
		User user = (User)session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("/Bulletinbullet/");
			final String timeoutmsg = "タイムアウトしました";
			session.setAttribute("timeoutmsg", timeoutmsg);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Post.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//postされた日付の取得
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String pdate = sdf.format(timestamp);
		//ユーザーid及びユーザーネームの取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("/Bulletinbullet/");
		    }
		String puserid = user.getUserid();
		String pname = user.getName();
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String ptitle = request.getParameter("title");
		String ptext = request.getParameter("text");

		//Postインスタンスの生成
		Post post;
		if(ptitle.length() == 0 || ptext.length() == 0) {
			post = null;
		}
		else {post = new Post(puserid, pname, pdate, ptitle, ptext);}
		PostNewLogic pnl = new PostNewLogic();
		if(pnl.execute(post)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Post.jsp");
			dispatcher.forward(request, response);
		}else if(pnl.execute(post) == false) {
			String posterrormsg = "投稿に失敗しました";
			session.setAttribute("posterrormsg", posterrormsg);
			response.sendRedirect("/Bulletinbullet/Postservlet");
		}
  }
}
/*10/28 セッションの破棄をどうにかしたい
 *		投稿を更新ボタンなしで更新できるようにしたい
 *
 */

