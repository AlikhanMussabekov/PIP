package ru.cs.ifmo.controller;

import ru.cs.ifmo.model.Point;
import ru.cs.ifmo.model.User;
import ru.cs.ifmo.utils.PointService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Date;
import java.util.List;

@Stateless
@Path("/points")
public class PointsController {

	@EJB
	private PointService pointService;

	@GET
	public Response getAllPoints(@Context HttpServletRequest req){

		User user = (User)req.getSession(false).getAttribute("user");

		if(user == null){

			String msg = "{\"msg\": \"user not logged\"}";

			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(msg)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		List<Point> points = pointService.getAllShots(user);

		GenericEntity<List<Point>> genericEntity = new GenericEntity<List<Point>>(points){};

		return Response
				.status(Response.Status.OK)
				.entity(genericEntity)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

	@POST
	@Path("/check")
	public Response checkPoint(@QueryParam("x") double x, @QueryParam("y") double y , @QueryParam("r") double r, @Context HttpServletRequest req, @Context HttpServletResponse resp){

		User user = (User)req.getSession(false).getAttribute("user");
		String msg = "{\"msg\": \"out\"}";

		if( user == null){

			msg = "{\"msg\": \"user not logged\"}";

			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(msg)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}


		Point point = new Point(
				x,y,r,
				new Date(),
				"Не лежит",
				(User)req.getSession().getAttribute("user")
		);


		if(checkPoint(x,y,r)){
			msg = "{\"msg\": \"in\"}";

			point.setResult("Лежит");
		}

		pointService.addPoint(point);

		return Response
				.status(Response.Status.CREATED)
				.entity(point)
				.type(MediaType.APPLICATION_JSON)
				.build();

	}

	@POST
	@Path("/delete")
	public Response deletePoint(@QueryParam("id") Integer id, @Context HttpServletRequest req){
		User user = (User)req.getSession(false).getAttribute("user");

		if(user == null){

			String msg = "{\"msg\": \"user not logged\"}";

			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(msg)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		pointService.delete(id);
		return Response
				.status(Response.Status.OK)
				.build();
	}

	private boolean checkPoint(double x, double y, double r){
		if(x < 0 && y > 0)
			return false;

		if(x <= 0 && y <= 0)
			return y >= -x-r;

		if(x >= 0 && y <= 0)
			return x*x +y*y < (r/2)*(r/2);

		return x < r && y < r/2;
	}

}
