package ru.cs.ifmo.servlets;

import ru.cs.ifmo.entities.Point;
import ru.cs.ifmo.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		double x = Double.valueOf(req.getParameter("x"));
		double y = Double.valueOf(req.getParameter("y").replace(",","."));
		int r = Integer.valueOf(req.getParameter("r"));
		long time = (long) req.getAttribute("time");

		Point point = new Point();

		if((x<(-4) || x>4) || (y<(-5) || y>(5)) || (r<1 || r>5)){
			point.setResult("Ошибка");
		}else{

			point.setX(x);
			point.setY(y);
			point.setR(r);
			point.setDate(new Date());
			point.setResult("Не лежит");

			if (x >= 0 && y >= 0){

				if(checkTriangle(x,y,r)){
					point.setResult("Лежит");
				}

			}else if(x >= 0 && y<=0){

				if(checkRectangle(x,y,r)){
					point.setResult("Лежит");
				}

			}else if(x<=0 && y>=0){

				if(checkArc(x,y,r)){
					point.setResult("Лежит");
				}

			}

		}

		point.setWorkTime(new Date().getTime()-time);

		Model model = Model.getInstance();
		model.add(point);
		req.setAttribute("list",  model.list());

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
		requestDispatcher.forward(req, resp);

		/*PrintWriter writer = resp.getWriter();
		writer.write(x + " " + y + " time: " + (new Date().getTime()-time) + "мс");*/

	}

	private boolean checkArc(double x, double y, int r){

		return x*x + y*y <= r*r;

	}

	private boolean checkTriangle(double x, double y, int r){

		return y<=((-x/2)+r/2);

	}

	private boolean checkRectangle(double x, double y, int r){
		return (x<=r && y>=(-r/2));
	}

}
