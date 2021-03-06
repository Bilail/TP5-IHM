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
	private ArrayList<Boolean> EnCours;
	
	public Model(){
		listeForme = new ArrayList<Shape>();
		EnCours = new ArrayList<Boolean>();
		}

	public void createRectangle(double x, double y, Color c) {
		Rectangle r = new Rectangle(x,y,100,150);
		r.setFill(c);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(2);
		listeForme.add(r);
		Boolean b = false;
		EnCours.add(b);
	}
	
	public void createEllipse(double x, double y, Color c) {
		Ellipse e = new Ellipse(50,50);
		e.setCenterX(x);
		e.setCenterY(y);
		e.setFill(c);
		e.setStroke(Color.BLACK);
		e.setStrokeWidth(2);
		listeForme.add(e);
		Boolean b = false;
		EnCours.add(b);
	}
	
	public void createLine(double x1, double y1, double x2, double y2, Color c) {
		Line l = new Line(x1,y1,x2,y2);
		l.setFill(c);
		l.setStrokeWidth(5);
		l.setStroke(c);
		listeForme.add(l);
		Boolean b = false;
		EnCours.add(b);
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
		f.setStrokeWidth(6);
		listeForme.set(index, f);
		
		
	}
	
	public void setContourBase(Shape f) {
		
		int index = listeForme.indexOf(f);
		if (f instanceof Line) {// Si on a une ligne on red?fini le contour de ligne par sa couleur d'o? l'utilis? du Fill pour la ligne
			Paint c = f.getFill();
			f.setStroke(c);
			f.setStrokeWidth(5);
		}
		else {
			f.setStroke(Color.BLACK);
			f.setStrokeWidth(2);
		}
		listeForme.set(index, f);
		
	}
	
	
	public void debut(Shape f) {
		int index = listeForme.indexOf(f);
		EnCours.set(index, true);
	}
	public void fin(Shape f) {
		int index = listeForme.indexOf(f);
		EnCours.set(index, false);
	}
	public Boolean getEnCours(Shape f) {
		int index = listeForme.indexOf(f);
		return EnCours.get(index);
	}
	
	public void libere() {
		for (Boolean b : EnCours) {
			b = false;
		}
	}
	
	
	public void move(Shape f, double xNew, double yNew) {
		int index = listeForme.indexOf(f);
		
		if(f instanceof Rectangle) {
			
			// Autre methode
			/*double x  = ((Rectangle) f).getX();
			double y =  ((Rectangle) f).getY();
			double deltaX = xNew + x;
			double deltaY = yNew + y;
			((Rectangle) f).setTranslateX(deltaX);
			((Rectangle) f).setTranslateY(deltaY);*/
			
			double h = ((Rectangle) f).getHeight();
			double l = ((Rectangle) f).getWidth();
			((Rectangle) f).setX(xNew-l/2);
			((Rectangle) f).setY(yNew-h/2);
			
			/*((Rectangle) f).setX((xNew));
			((Rectangle) f).setY((yNew));*/
		}
		
		if(f instanceof Ellipse) {
			
			// Autre methode
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
			((Line) f).setEndX(xNew+100);
			((Line) f).setEndY(yNew+100);
		}
	
		listeForme.set(index, f);
	}
	
	public void delete(Shape f) {
		EnCours.remove(listeForme.indexOf(f));
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


