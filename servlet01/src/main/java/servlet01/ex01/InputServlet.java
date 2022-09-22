package servlet01.ex01;

import java.io.IOException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method called from input");
	}

	public void destroy() {
		System.out.println("destroy method called from input");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id"); // 하나의 전송된 값
		System.out.println(user_id + "'s class enrollments");
		String[] subject = request.getParameterValues("subject"); // 하나의 name으로 여러 개의 값을 전송하는 경우
		for(String sub:subject) {
			System.out.println("enrolled class : " + sub);
		}
		// getParameterNames -> name 값을 모를 때 사용(전송된 데이터가 많아 일일히 name을 기억하기 힘들 때)
	}

}
