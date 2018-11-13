package ru.cs.ifmo.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ControllerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String x = req.getParameter("x");
		String y = req.getParameter("y");
		String r = req.getParameter("r");

		if(x!=null && y!=null && r!=null){

			req.setAttribute("time", new Date().getTime());

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/check");
			requestDispatcher.forward(req, resp);

		}else{

			PrintWriter writer = resp.getWriter();
			writer.write("Координаты не переданы");

		}

	}
}
