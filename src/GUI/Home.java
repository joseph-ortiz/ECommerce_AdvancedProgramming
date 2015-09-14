package GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Models.Address;
import Models.Order;
import Models.PaymentType;
import Models.Product;
import Models.ProductCategory;
import Models.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
	public final String ecommerceLogo = "http://www.publicpolicy.telefonica.com/blogs/wp-content/uploads/2012/01/iStock_000018168079Large.jpg";
	
	public TextField textField = new TextField();
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		User user = new User("jortiz3");
		//Create an order
		Order order = new Order(user.getId());
		order.setShippingAddress(new Address()); //TODO: Create GUI for address field Then get address from user input. 
		user.orders.add(order);

		//Create Category
		ProductCategory category = new ProductCategory("Books");

		//Create Products
		Product p1 = new Product("Financial Management", 60.00, category);
		Product p2 = new Product("Advanced Programming", 80.00, category);
		Product p3 = new Product( "Networking Book", 40.00, category);

		//Create Pane
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(30));
		pane.setStyle("-fx-background-color: black;");

		//Create product label and button
		Label pr1 = new Label(p1.name);
		pr1.setFont(Font.font("Cambria", 18));
		pr1.setTextFill(Color.WHITE);
		pane.add(pr1, 0, 1);
		pane.add(CreateItemButton(p1), 1, 1);
		
		Label pr2 = new Label(p2.name);
		pr2.setFont(Font.font("Cambria", 18));
		pr2.setTextFill(Color.WHITE);
		pane.add(pr2, 0, 2);
		pane.add(CreateItemButton(p2), 1, 2);
		
		Label pr3 = new Label(p3.name);
		pr3.setFont(Font.font("Cambria", 18));
		pr3.setTextFill(Color.WHITE);
		pane.add(pr3, 0, 3);
		pane.add(CreateItemButton(p3), 1, 3);

		//Create Payment Type Radio buttons and Label
		HBox paymentTypeRadioButtons = new HBox();
		final ToggleGroup group = new ToggleGroup();
		Stream.of(PaymentType.values()).map(Enum::name)
				.collect(Collectors.toList()).forEach(name ->
				{
					RadioButton rb = new RadioButton(name);
					rb.setTextFill(Color.WHITE);
					rb.setToggleGroup(group);
					rb.setOnAction(e ->
					{
						executor.execute(new Runnable(){
							public void run(){
								PaymentType paymentTypeVal = PaymentType.valueOf(name);
								order.getPayment().setType(paymentTypeVal);
								textField.setText("Set the payment type to: "
											+ paymentTypeVal.toString());
							}
						});
						
					});
					paymentTypeRadioButtons.getChildren().add(rb);
				});

		pane.add(paymentTypeRadioButtons, 0, 6);

		//Create cart View
		pane.add(cartTitle, 0, 4);
		pane.add(cartTotal, 1, 4);

		//Create Image and Title
		Image image = new Image(ecommerceLogo);
		ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(150);
        imageView.setFitHeight(100);
		pane.add(imageView, 0, 0);
		Label title = new Label("E-Commerce App");
		title.setFont(Font.font("Cambria", 26));
		pane.add(title, 1, 0);
	
		
		cartTitle.setTextFill(lightGreen);
		cartTitle.setFont(Font.font("Cambria", 24));
		
		cartTotal.setTextFill(lightGreen);
		cartTotal.setFont(Font.font("Cambria", 24));

		//Create Logging box.
		HBox hb = new HBox();
		hb.getChildren().addAll(transactionInfo, textField);
		hb.setSpacing(10);
		pane.add(textField, 0, 5);
		
		Button placeOrderButton = new Button("Place Order");
		placeOrderButton.setOnAction(e ->
		{
			order.setProducts(this.cartProductList);
			try{
				executor.execute(new Runnable(){ //async tas
					@Override
					public void run(){
						order.placeOrder();
						textField.setText("Order placed.  Your total is: " + order.getTotal());
					}
				});
				
					
			}catch(Exception error){
				String message = "Error processing your order: " +  error.getMessage();
				System.out.println(message);
				textField.setText(message);
			}
			
		});
		pane.add(placeOrderButton, 1, 5);

		//Create a scene and place it on the stage.
		Scene scene = new Scene(pane, 800,300);
		primaryStage.setTitle("JavaFX ECommerce App");
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
		});
		return button;
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
