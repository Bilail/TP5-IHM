package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage)
    {

      
        View controlleur = new View();

        try
        {
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));


            //On charge le fichier FXML, il appellera la méthode *initialize()* de la vue
            Parent root = loader.load();

            
            Scene scene = new Scene(root);

            
            primaryStage.setScene(scene);

           
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    	
    
    
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
