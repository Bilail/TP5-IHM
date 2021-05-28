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
	public void createRectangle(double x, double y, Color c) {
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
	
	public void createLine(double x1, double y1, double x2, double y2, Color c) {
		Line l = new Line(x1,y1,x2,y2);
		l.setFill(c);
		l.setStrokeWidth(3);
		l.setStroke(c);
		listeForme.add(l);
	}
	public ArrayList<Shape> getListeForme() {
		return listeForme;
	}
	
	public void setColor(Shape f,Color c) {
		int index = listeForme.indexOf(f);
		f.setFill(c);
		listeForme.set(index, f);
		
	}
	
	public void setContour(Shape f) {
		//Permet en cas de superposition de selectionner la forme le plus en hauteur
		for (Shape e : listeForme) {
			setContourBase(e);
			}
		int index = listeForme.indexOf(f);
		f.setStroke(Color.GREEN);
		f.setStrokeWidth(5);
		listeForme.set(index, f);
		
		
	}
	
	public void setContourBase(Shape f) {
		int index = listeForme.indexOf(f);
		f.setStroke(Color.BLACK);
		f.setStrokeWidth(2);
		listeForme.set(index, f);
		
	}
	
	public void move(Shape f, double xNew, double yNew) {
		int index = listeForme.indexOf(f);
		
		if(f instanceof Rectangle) {
			/*double x  = ((Rectangle) f).getX();
			double y =  ((Rectangle) f).getY();
			double deltaX = xNew + x;
			double deltaY = yNew + y;
			((Rectangle) f).setTranslateX(deltaX);
			((Rectangle) f).setTranslateY(deltaY);*/
			
			((Rectangle) f).setX(xNew);
			((Rectangle) f).setY(yNew);
		}
		
		if(f instanceof Ellipse) {
			
			/*double x  = ((Ellipse) f).getCenterX();
			double y =  ((Ellipse) f).getCenterY();
			double deltaX = xNew - x;
			double deltaY = yNew - y;
			((Ellipse) f).setTranslateX(deltaX);
			((Ellipse) f).setTranslateY(deltaY);*/
			
			((Ellipse) f).setCenterX(xNew);
			((Ellipse) f).setCenterY(yNew);
		}
		
		if(f instanceof Line) {
			((Line) f).setStartX(xNew);
			((Line) f).setStartY(yNew);

		}
	
		listeForme.set(index, f);
	}
	
	public void delete(Shape f) {
		listeForme.remove(f);
	}
	
	public void clone(Shape f) {
		
		if(f instanceof Rectangle) {
			createRectangle(((Rectangle) f).getX()+20, ((Rectangle) f).getY()+20, (Color) f.getFill());
			}
		
		if(f instanceof Ellipse) {
			createEllipse(((Ellipse) f).getCenterX()+20,((Ellipse) f).getCenterY()+20,  (Color) f.getFill());
			}
		
		if(f instanceof Line) {
			double x = ((Line) f).getStartX()+20;
			double y = ((Line) f).getStartY()+20;
			createLine(x,y,x+100,y+100,(Color) f.getFill());

		}
		
	}
}


