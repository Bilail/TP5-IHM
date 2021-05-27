package application;

import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Controller.Controlleur;
import Model.Model;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;



public class View
{
	Controlleur controlleur;

	@FXML
    private Button btnClone;

    @FXML
    private Button btnDelete;

    @FXML
    private ColorPicker ColorSelector;

    @FXML
    private RadioButton btnEllipse;

    @FXML
    private RadioButton btnRectangle;

    @FXML
    private RadioButton btnLine;

    @FXML
    private RadioButton btnSelect;

    @FXML
    public AnchorPane ZoneDessin;
    
    @FXML
    private ToggleGroup TG;
    
    
	
	public View()
	{

		controlleur = new Controlleur();

	}
	
	@FXML
	public void initialize()
	{
		ZoneDessin.setOnMouseClicked(event -> {
            float x = (float) event.getX();
            float y = (float) event.getY();
            Color color = ColorSelector.getValue();
            if (btnEllipse.isSelected() == true) {
            	controlleur.ajoutEllipse(x,y,color);
            }
            if (btnLine.isSelected() == true) {;
            	controlleur.ajoutLine(x,y,x+100,y+100,color);
            }
            if (btnRectangle.isSelected() == true) {
            	controlleur.ajoutRectangle(x,y,color);
            }
            if (btnSelect.isSelected() == true) {
            
            }
            
            
            MAJ();
            
        });
		/*EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent mouseEvent) {
	        	if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
	        		int x1 = mouseEvent.getX();
                    int y1 = mouseEvent.getY();
                    ZoneDessin.getChildren().add(new Ellipse(x1,y1));
	        	}
	        	
	        	else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
	        		int x2 = mouseEvent.getX();
                    int y2 = mouseEvent.getY();
	        	}
	        }
	
	};*/
	}
	
	public void MAJ() {
		ArrayList<Shape> L = controlleur.obtenirForme();
		Shape e = L.get(L.size()-1);
		ZoneDessin.getChildren().add(e);
	}
		
}

