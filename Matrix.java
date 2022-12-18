import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//This is the main class 
public class Matrix extends Application{

public void start(Stage stage) throws Exception{
Parent root = (Parent)

FXMLLoader.load(getClass().getResource("Matrix.fxml"));

Scene scene = new Scene(root);
stage.setTitle("Matrix");
stage.setScene(scene);
stage.show();
}


public static void main(String[] args) {
launch(args);
System.out.println();
}
}