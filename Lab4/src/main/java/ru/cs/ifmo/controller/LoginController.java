package ru.cs.ifmo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cs.ifmo.model.Point;
import ru.cs.ifmo.model.User;
import ru.cs.ifmo.utils.UserService;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;

@Path("/user")
@Singleton
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@EJB
	private UserService userService;

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces("text/plain")
	public String hello(){
		return "hello";
	}

	@POST
	@Path("/register")
	public Response register(@FormParam("login") String login, @FormParam("password") String password, @Context HttpServletResponse resp, @Context HttpServletRequest req){

		User user = new User(login,password);

		boolean status = userService.saveUsr(user);

		if (status) {
			req.getSession().setAttribute("user", user);

			return Response
					.status(Response.Status.OK)
					.entity(user)
					.build();
		}
		else {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("User exists")
					.build();
		}
	}

	@POST
	@Path("/login")
	public Response login(@FormParam("login") String login, @FormParam("password") String password, @Context HttpServletResponse resp, @Context HttpServletRequest req){

		User curUser = userService.assertUser(login, password);
		if (curUser != null) {
			req.getSession().setAttribute("user", curUser);

			String msg = "{\"msg\": \"logged in\"}";

			return Response
					.status(Response.Status.OK)
					.entity(msg)
					.type(MediaType.APPLICATION_JSON)
					.build();

		} else {

			String msg = "{\"msg\": \"incorrect data\"}";

			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(msg)
					.build();
		}
	}

	@Path("/logout")
	@POST
	public Response logOut(@Context HttpServletRequest req){

		req.getSession().invalidate();

		String msg = "{\"msg\": \"logged out\"}";

		return Response
				.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(msg)
				.build();

	}

}
