package GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Models.Address;
import Models.Order;
import Models.PaymentType;
import Models.Product;
import Models.ProductCategory;
import Models.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Home extends Application
{

	public final Color darkGreen = Color.rgb(56, 142, 60);
	public final Color lightGreen = Color.rgb(76, 175, 80);
	public final Color fadedGreen = Color.rgb(76, 175, 80);
	public final int appWidth = 360;
	List<Product> cartProductList = new ArrayList<Product>();
	Label title = new Label("ECommerce App");
	Label cartTitle = new Label("Your Order");
	Label cartTotal = new Label("");
	Label transactionInfo = new Label("Transaction Information:");
	@FXML
	public TextField textField = new TextField();
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		User user = new User("jortiz3");
		//Create an order
		Order order = new Order(user.getId());
		order.setShippingAddress(new Address()); //TODO: Create GUI for address field Then get address from user input. 
		user.orders.add(order);

		//Create Category
		ProductCategory category = new ProductCategory("Books");

		//Create Products
		Product p1 = new Product(1, "Financial Management", 60.00, category);
		Product p2 = new Product(2, "Advanced Programming", 80.00, category);
		Product p3 = new Product(3, "Networking Book", 40.00, category);

		//Create GUI Here
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(30));
		pane.setStyle("-fx-background-color: #FAFAFA;");

		//create items in list view.
		//pane.add(title, 0, 0);

		//Create label and button
		//TODO: put this in a function to add this to a list.
		
		pane.add(new Label(p1.name), 0, 1);
		pane.add(CreateItemButton(p1), 1, 1);

		pane.add(new Label(p2.name), 0, 2);
		pane.add(CreateItemButton(p2), 1, 2);

		pane.add(new Label(p3.name), 0, 3);
		pane.add(CreateItemButton(p3), 1, 3);

		HBox paymentTypeRadioButtons = new HBox();
		final ToggleGroup group = new ToggleGroup();

		Stream.of(PaymentType.values()).map(Enum::name)
				.collect(Collectors.toList()).forEach(name ->
				{
					RadioButton rb = new RadioButton(name);
					rb.setToggleGroup(group);
					rb.setOnAction(e ->
					{
						PaymentType paymentTypeVal = PaymentType.valueOf(name);
						order.getPayment().setType(paymentTypeVal);
						textField.setText("Set the payment type to: "
									+ paymentTypeVal.toString());
						//System.out.println("Set the payment type to: "
							//	+ paymentTypeVal.toString());
						//TODO: add button to pane
					});
					paymentTypeRadioButtons.getChildren().add(rb);
				});

		pane.add(paymentTypeRadioButtons, 0, 6);

		//Create cart View
		pane.add(cartTitle, 0, 4);
		pane.add(cartTotal, 1, 4);

		//TODO: Create Textbox as a class field property. Then log all system.out.println() to somewhere on the GUI.
		
		HBox hb = new HBox();
		hb.getChildren().addAll(transactionInfo, textField);
		hb.setSpacing(10);
		pane.add(textField, 0, 5);
		
		Button placeOrderButton = new Button("Place Order");
		placeOrderButton.setOnAction(e ->
		{
			//order.CalculateTotal();
			order.setProducts(this.cartProductList);
			order.placeOrder();
			textField.setText("Order placed.  Your total is: " + order.getTotal());
		});
		pane.add(placeOrderButton, 1, 5);

		//Create a scene and place it on the stage.
		Scene scene = new Scene(pane, 800, 600);
		primaryStage.setTitle("ECommerce App");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Node CreateItemButton(Product product)
	{

		Button button = new Button("Add to Cart");
		button.setOnAction(e ->
		{
			this.cartProductList.add(product);
			button.setText("Added");
			textField.setText(product.name + " has been added to the cart");
			//System.out.println(product.name + " has been added to the cart");
		});
		return button;
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
