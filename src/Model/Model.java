package Model;


import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Model {
	private ArrayList<Shape> listeForme;
	
	public Model(){
		listeForme = new ArrayList<Shape>();
		}
	public void createRectangle(float x, float y, Color c) {
		Rectangle r = new Rectangle(x,y,100,150);
		r.setFill(c);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(2);
		listeForme.add(r);
	}
	
	public void createEllipse(double x, double y, Color c) {
		Ellipse e = new Ellipse(50,50);
		e.setCenterX(x);
		e.setCenterY(y);
		e.setFill(c);
		e.setStroke(Color.BLACK);
		e.setStrokeWidth(2);
		listeForme.add(e);
	}
	
	public void createLine(float x1, float y1, float x2, float y2, Color c) {
		Line l = new Line(x1,y1,x2,y2);
		l.setFill(c);
		listeForme.add(l);
	}
	public ArrayList<Shape> getListeForme() {
		return listeForme;
	}
	
	
}


