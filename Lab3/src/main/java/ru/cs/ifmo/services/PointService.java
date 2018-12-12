package ru.cs.ifmo.services;

import org.hibernate.service.spi.InjectService;
import ru.cs.ifmo.DAO.PointsDAO;
import ru.cs.ifmo.entities.Point;

import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.*;

@SessionScoped
@ManagedBean(name = "points")
public class PointService {

	private String sessionID;
	private Boolean[] arrX = new Boolean[9];
	private PointsDAO pointsDAO = new PointsDAO();
	private String yStr;
	private String rStr;
	private String canvasXStr;

	{
		FacesContext fCtx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(true);
		sessionID = session.getId();
		arrX[4] = true;
	}

	public int addPoint(){

		double y;
		double r;
		try {
			r = Double.parseDouble(rStr);
			y = Double.parseDouble(yStr.replace(',', '.'));
		} catch (Exception e) {
			return -1;
		}

		if(canvasXStr == null || canvasXStr.equals("")) {
			boolean check;

			for (int i = 0; i < 9; i++) {

				if (arrX[i]) {

					int curX = i - 4;

					if (!valid(curX, y, r))
						return -1;

					check = match(curX, y, r);

					Point point = new Point();
					point.setX(curX);
					point.setY(y);
					point.setR(r);
					point.setDate(new Date());
					point.setSessionID(sessionID);
					point.setResult(check ? "Лежит" : "Не лежит");
					save(point);
				}

			}

		}else {
			double x;
			try{
				x = Double.parseDouble(canvasXStr);
			}catch (Exception e){
				return -1;
			}

			if (!valid(x, y, r))
				return -1;

			boolean check = match(x, y, r);

			Point point = new Point();
			point.setX(x);
			point.setY(y);
			point.setR(r);
			point.setDate(new Date());
			point.setSessionID(sessionID);
			point.setResult(check ? "Лежит" : "Не лежит");
			save(point);
			canvasXStr = null;

		}
		return 1;
	}

	private boolean match(double x, double y, double r) {

		if (x >= 0 && y >= 0 ){

			double negHalfX = x/(-2.0);
			double halfR = r/(2.0);

			if( y<=(negHalfX+halfR) ){
				return true;
			}

		}else if( x >= 0 && y<=0 ) {

			double negHalfR = r/(-2.0);

			if(x<=r && y>=negHalfR){
				return true;
			}

		}else if(x<=0 && y>=0) {

			if (x * x + y * y <= r * r) {
				return true;
			}

		}
		return false;
	}

	private boolean valid(double x, double y, double r){

		if(x < -4 || x > 4)
			return false;

		if(y < -5 || y > 5)
			return false;

		if(r < 1 || r > 5)
			return false;

		return true;
	}

	public void save(Point point){
		pointsDAO.save(point);
	}

	public List<Point> findAll(){
		return pointsDAO.findAll(sessionID);
	}

	public Point findById(int id){
		return pointsDAO.findById(id);
	}

	public Boolean[] getArrX(){return arrX;}

	public Boolean getArrXI(int i){
		return arrX[i];
	}

	private List<Integer> getNums(){

		List<Integer> list = new ArrayList<Integer>();

		for (int i=0;i<9;i++) {
			if(arrX[i]){
				list.add(i-4);
			}
		}

		return list;
	}
	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public void setArrX(Boolean[] arrX) {
		this.arrX = arrX;
	}

	public PointsDAO getPointsDAO() {
		return pointsDAO;
	}

	public void setPointsDAO(PointsDAO pointsDAO) {
		this.pointsDAO = pointsDAO;
	}

	public String getyStr() {
		return yStr;
	}

	public void setyStr(String yStr) {
		this.yStr = yStr;
	}

	public String getrStr() {
		return rStr;
	}

	public void setrStr(String rStr) {
		this.rStr = rStr;
	}

	public String getCanvasXStr() {
		return canvasXStr;
	}

	public void setCanvasXStr(String canvasXStr) {
		this.canvasXStr = canvasXStr;
	}
}
