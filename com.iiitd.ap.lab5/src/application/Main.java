package application;
/**
 * Siddharth Singh
 * 2014105
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	public static int budget=0;
	public static int avail=0;
	public void reading()
	{
	BufferedReader buffr = null;
	String line;
	try {

		buffr = new BufferedReader(new FileReader("./src/Expenses.txt"));
		while ((line = buffr.readLine()) != null) 
		{
			String[] data = line.split(" ");
			//System.out.println(data[0]);
			{
				if(data[0].equals("Budget"))
				{
					String bd=data[1];
					bd = bd.replaceAll("\\D+","");
					System.out.println(bd);
					budget = Integer.parseInt(bd);
				}
				else if(data[0].equals("Available"))
				{
					String bd=data[1];
					bd = bd.replaceAll("\\D+","");
					System.out.println(bd);
					avail = Integer.parseInt(bd);
				}
			}
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	@Override
	public void start(Stage primaryStage) {
		URL url = getClass().getResource("testwind.fxml");
	    AnchorPane pane;
		try {
			reading();
			pane = FXMLLoader.load(url);
		    Scene scene = new Scene(pane);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle( "MyBudget" );
		    primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
