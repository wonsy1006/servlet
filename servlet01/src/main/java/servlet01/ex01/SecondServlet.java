package servlet01.ex01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet method called from second servlet");
	}

	@Override
	public void destroy() {
		System.out.println("destroy method called from second servlet");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init method called from second servlet");
	}
	
}
