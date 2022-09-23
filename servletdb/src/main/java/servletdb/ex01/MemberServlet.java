package servletdb.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO(); // sql문으로 조회할 MemberDAO 객체 생성
		
		List<MemberVO> list = dao.listMembers();
		
		out.print("<html><body><p>");
		for(int i = 0; i < list.size(); i++) {
			out.print(list.get(i).getId() + ", " + list.get(i).getPwd() + ", " + list.get(i).getName() +
					", " + list.get(i).getEmail() + ", " + list.get(i).getJoinDate());
		}
		out.print("</p></body></html>");
	}
}
