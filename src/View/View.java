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
				// On d?sactive les boutons
		btnDelete.setDisable(true);
		btnClone.setDisable(true);
		
		//On initialise toutes les varaibles dont on aura besoin 
		// Evenement si on clique sur la zone de dessin
		ZoneDessin.setOnMouseClicked(event -> {
			
			//On r?cup?re les coordonn?es de la souris 
            double x = event.getX();
            double y = event.getY(); 
            
            ArrayList<Shape> listForme = controlleur.obtenirForme();
            
        
            //On r?cup?re la valeur couleur s?lectionn? 
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
            	
            	// On d?sactive les boutons si on est en dehor
            	btnDelete.setDisable(true);
        		btnClone.setDisable(true);
        		
            	for (Shape f : listForme) {
            		// on d?selectionne tout ? chaque nouveau appuie sur le bouton 
        			controlleur.setContourBase(f);
            	}
            	for (Shape f : listForme ) {
            		if (f.contains(x,y)) {
            			
            			
            			// On r?active les boutons 
                    	btnDelete.setDisable(false);
                		btnClone.setDisable(false);
                		
            			// On selectionne la figure
            			controlleur.selection(f, color);
            		
            			
            			btnDelete.setOnAction(supr -> {
            				controlleur.delete(f);
            				 MAJ();
            			});
            			
            			btnClone.setOnAction(add -> {
            				controlleur.clone(f);
            				 MAJ();
            					});
            			
            				}
            		
            		
            			}
            		}
            // Quand on est plus sur la s?lection on redesactive les boutons 
            if (btnSelect.isSelected() == false) {
            	btnDelete.setDisable(true);
        		btnClone.setDisable(true);
            }
            // ON met ? jours la vue 
            MAJ();
            
        });
		
		
		
		//Si on click et glisse avec la souris 
		ZoneDessin.setOnMouseDragged(event ->
	        {
	        	//On initialise toutes les varaibles dont on aura besoin 
	        	// On recupere les coordonn?es de la souris  	             
	             double X = event.getX();
	             double Y = event.getY(); 
	             Boolean selected;
	                       
	            //On r?cup?re la valeur couleur s?lectionn? 
	            Color color = ColorSelector.getValue();
	               
	             // On regarde sur quelle forme on est 
	             ArrayList<Shape> listForme = controlleur.obtenirForme();

	             
	             // Si le bouton select est s?lectionner 
	             if(btnSelect.isSelected()) {
	            	 
	            		 
	            	 for (Shape f : listForme) {
	            		 
	            		 selected = controlleur.getEnCours(f);
	            		 controlleur.debut(f);
	            		 //On regarde quelle forme est s?lectionn? 
	            		 if (f.contains(X,Y) && selected) {
	            			 
	            			 //ontrolleur.debut(f);
	            				 for (Shape autre : listForme) {
		            				  if (autre != f) {
		            					  controlleur.fin(autre);
		            				  }
		            			  }
	            		 	
	            			  controlleur.draw(f,color,X,Y);  
	            		 	}
	            		
	            		 } 
	            	 controlleur.libere(); 
	             }
	             
	             MAJ();
	             
	        });  
	}
	
	
	//Permet de mettre ? jour la zone de dessin avec les modifications
	public void MAJ() {
		
		ArrayList<Shape> L = controlleur.obtenirForme();
		ZoneDessin.getChildren().clear();
		ZoneDessin.getChildren().addAll(L);
		}
	
	}
		


