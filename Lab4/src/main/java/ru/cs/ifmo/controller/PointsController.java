package ru.cs.ifmo.controller;

import net.bytebuddy.utility.RandomString;
import ru.cs.ifmo.model.Point;
import ru.cs.ifmo.model.User;
import ru.cs.ifmo.utils.PointService;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/points")
public class PointsController {

	@EJB
	private PointService pointService;

	@GET
	public Response getAllPoints(@Context HttpServletRequest req){

		if(req.getSession().getAttribute("user") == null){

			String msg = "{\"msg\": \"user not logged\"}";

			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(msg)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		List<Point> points = pointService.getAllShots(req);

		return Response
				.status(Response.Status.OK)
				.entity(points)
				.build();
	}

	@POST
	@Path("/check")
	public Response checkPoint(@FormParam("x") double x,@FormParam("y") double y , @FormParam("r") double r, @Context HttpServletRequest req, @Context HttpServletResponse resp){

		if(req.getSession().getAttribute("user") == null){

			String msg = "{\"msg\": \"user not logged\"}";

			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(msg)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}


		if(x > 0 && y >0 && r>0){
			Point point = new Point(
					x,y,r,
					new Date(),
					"Лежит",
					(User)req.getSession().getAttribute("user")
			);

			pointService.addPoint(point);

			String msg = "{\"msg\": \"in\"}";

			return Response
					.status(Response.Status.OK)
					.entity(msg)
					.type(MediaType.APPLICATION_JSON)
					.build();

		}else {

			String msg = "{\"msg\": \"out\"}";

			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(msg)
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

	}

}
