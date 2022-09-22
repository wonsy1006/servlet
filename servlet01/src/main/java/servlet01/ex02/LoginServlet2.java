package servlet01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method called from login2");
	}

	public void destroy() {
		System.out.println("destroy method called from login2");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String data = "<html>";
		data += "<body>";
		data += "<p>" + user_id + " is logged in.</p>";
		data += "<p>" + user_pw + " is logged in.</p>";
		data += "</body>";
		data += "</html>";
		
		out.print(data); // print 메소드로 html 태그를 웹 브라우저에 출력
	}

}
