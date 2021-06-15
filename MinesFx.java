package mines;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

	public class MinesFx extends Application {
		
		public static void main(String[] args) {
			launch(args);
		}
			
		@Override
		public void start(Stage stage) {
			BorderPane pane;
			try {
			    FXMLLoader loader = new FXMLLoader();
			    loader.setLocation(getClass().getResource("layout.fxml"));
			    pane = loader.load();
			} catch (IOException e) {
			    e.printStackTrace();
			    return;
			}
			
			Scene scene=new Scene(pane);
		
			stage.setTitle("Classic Minesweeper");
			stage.setScene(scene);		
			stage.show();	
		}
	
}
