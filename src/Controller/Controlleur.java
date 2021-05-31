package Controller;


import java.util.ArrayList;

import Model.Model;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


public class Controlleur {

	private Model model;
	
	public Controlleur()
	{
		model = new Model();
	}
	
	public void ajoutRectangle(double x, double y, Color c) {
		model.createRectangle(x,y,c);
	}
	
	public void ajoutEllipse(double x, double y, Color color) {
		model.createEllipse(x,y,color);
	}
	
	public void ajoutLine(double x1, double y1, double x2, double y2, Color c) {
		model.createLine(x1,y1,x2,y2,c);
	}
	
	public ArrayList<Shape> obtenirForme() {
		return model.getListeForme();
	}
	
	public void setColor(Shape f, Color c) {
		model.setColor(f, c);
	}
	
	public void setContour(Shape f) {
		model.setContour(f);
	}
	public void setContourBase(Shape f) {
		model.setContourBase(f);
	}
	
	public void move(Shape f, double xNew, double yNew) {
		model.move(f, xNew, yNew);
	}
	
	public void delete(Shape f) {
		model.delete(f);
	}
	
	public void clone(Shape f) {
		model.clone(f);
	}
	
	public void debut(Shape f) {
		model.debut(f);
	}
	public void fin(Shape f) {
		model.fin(f);
	}
	public Boolean getEnCours(Shape f) {
		return model.getEnCours(f);
	}
	
	public void libere() {
		model.libere();
	}
	
	public void selection(Shape f, Color c) {
		// On red�fini le couleur choisi 
		setColor(f, c);
					
		// on d�finie le contour accentue
		setContour(f);
		
	}
	
	public void draw(Shape f, Color c , double X, double Y) {
		
		if (model.getEnCours(f) == true) {
			selection(f,c);
			
			//on bouge la forme
			
			move(f, X, Y);
		}
	}
}
