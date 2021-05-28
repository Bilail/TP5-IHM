package View;

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
import javafx.scene.shape.Line;
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
		
		// On désactive les boutons
		btnDelete.setDisable(true);
		btnClone.setDisable(true);
		
		//On initialise toutes les varaibles dont on aura besoin 
		// Evenement si on clique sur la zone de dessin
		ZoneDessin.setOnMouseClicked(event -> {
			
			//On récupère les coordonnées de la souris 
            float x = (float) event.getX();
            float y = (float) event.getY(); 
            
            ArrayList<Shape> listForme = controlleur.obtenirForme();
            
        
            //On récupère la valeur couleur sélectionné 
            Color color = ColorSelector.getValue();
            
          // Si on a selectionne le bouton ellipse
            if (btnEllipse.isSelected() == true) {
            	controlleur.ajoutEllipse(x,y,color);  
            	}
            
         // Si on a selectionne le bouton Line
            if (btnLine.isSelected() == true) {
            	controlleur.ajoutLine(x,y,x+100,y+100,color);
            	}
            
         // Si on a selectionne le bouton Rectangle
            if (btnRectangle.isSelected() == true) {
            	controlleur.ajoutRectangle(x,y,color);
            	}
            
         // Si on a selectionne le bouton Select
            if (btnSelect.isSelected() == true) {
            	
            	
        		
            	for (Shape f : listForme) {
            		// on déselectionne tout à chaque nouveau appuie sur le bouton 
        			controlleur.setContourBase(f);
            	}
            	for (Shape f : listForme ) {
            		if (f.contains(x,y)) {
            			// On réactive les boutons 
                    	btnDelete.setDisable(false);
                		btnClone.setDisable(false);
                		
            			// On redéfini le couleur choisi 
            			controlleur.setColor(f, color);
            			
            			// on définie le contour accentue
            			controlleur.setContour(f);
            			
            			btnDelete.setOnAction(supr -> {
            				System.out.println("supprimer de " + f);
            				controlleur.delete(f);
            			});
            			
            			btnClone.setOnAction(add -> {
            				System.out.println("Clone de " + f);
            				controlleur.clone(f);
            					});
            				
            				}
            			}
            		
         	
            	}
            	
            	
            
            // ON met à jours la vue 
            MAJ();
            
        });
		
		//Si on click et glisse avec la souris 
		ZoneDessin.setOnMouseDragged(event ->
	        {
	        	//On initialise toutes les varaibles dont on aura besoin 
	        	// On recupere les coordonnées de la souris  	             
	             double X = event.getX();
	             double Y = event.getY(); 
	             
	                       
	            //On récupère la valeur couleur sélectionné 
	            Color color = ColorSelector.getValue();
	               
	             // On regarde sur quelle forme on est 
	             ArrayList<Shape> listForme = controlleur.obtenirForme();
	             
	             // Si le bouton select est sélectionner 
	             if(btnSelect.isSelected()) {
	            	 for (Shape f : listForme) {
	            		 //On regarde quelle forme est sélectionné 
	            		 if (f.contains(X,Y)) {
	            			 
	            			// On redéfini le couleur choisi 
	             			controlleur.setColor(f, color);
	             			
	             			// on définie le contour accentue
	             			controlleur.setContour(f);
	             			
	             			//on bouge la forme 
	             			controlleur.move(f, X, Y);
	            			 
	            		 }
	            	 }
	            	 
	             }
	             
	        });
		
		
		
		
	}
	
	public void MAJ() {
		ArrayList<Shape> L = controlleur.obtenirForme();
		ZoneDessin.getChildren().clear();
		ZoneDessin.getChildren().addAll(L);
	}
		
}

