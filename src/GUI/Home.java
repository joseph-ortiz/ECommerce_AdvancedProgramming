package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Home extends Application{

	public final Color darkGreen = Color.rgb(56, 142, 60);
	public final Color lightGreen = Color.rgb(76, 175, 80);
	public final Color fadedGreen = Color.rgb(76, 175, 80);
	public final int appWidth = 360;
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(30));
		pane.setStyle("-fx-background-color: #FAFAFA;");
		
		//create items in list view.
		Label title = new Label("ECommerce App");
		pane.add(title, 0, 0);
		
		Label item = new Label("Java Programming Book");
		pane.add(item, 0, 1);
		pane.add(CreateButton("add to order", "Item added to order"), 1, 1);
		
		Label item2 = new Label("Financial management Book");
		pane.add(item2, 0, 2);
		pane.add(CreateButton("add to order", "Item added to order"), 1, 2);
		
		Label item3 = new Label("Networking Book");
		pane.add(item3, 0, 3);
		pane.add(CreateButton("add to order", "Item added to order"), 1, 3);
		
		
		//Create cart View
		Label cartTitle = new Label("Your Order");
		
		Label cartTotal = new Label("Your total");
		pane.add(cartTitle, 0, 4);
		pane.add(cartTotal, 1, 4);
	
		//TODO: Click Add to Order --> adds item to arraylist<products>
		//TODO: change text on button click to say "added"
		//TODO: set the order.products = arraylist<products>
		
		//Create a scene and place it on the stage.
		Scene scene = new Scene(pane, 360,640);
		primaryStage.setTitle("ECommerce App");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Node CreateButton(String title, String buttonClickMessage) {
		
		Button button = new Button(title);
		
		button.setOnAction(e -> {
			System.out.println(buttonClickMessage);
		});
		return button;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
