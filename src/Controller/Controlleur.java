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
	
	public void ajoutRectangle(float x, float y, Color c) {
		model.createRectangle(x,y,c);
	}
	
	public void ajoutEllipse(float x, float y, Color color) {
		model.createEllipse(x,y,color);
	}
	
	public void ajoutLine(float x1, float y1, float x2, float y2, Color c) {
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
}
