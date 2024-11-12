package Mian;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class appplication extends Application {
    Label titlelabel, emaillabel, passwordlabel;
    TextField email;
    Text description;
    PasswordField password;
    Button loginbutton;
    Scene scene;
    BorderPane border;
    GridPane grid;

    // Initialize components
    public void inisiate() {
        titlelabel = new Label("Login");
        titlelabel.setFont(new Font("Arial", 24));

        emaillabel = new Label("Email");
        email = new TextField();
        email.setPromptText("Enter your email");

        passwordlabel = new Label("Password");
        password = new PasswordField();
        password.setPromptText("Enter your password");

        loginbutton = new Button("Login");
        loginbutton.setOnAction(e ->{
        	hanndlelogin();
        });

        description = new Text("Don't have an account yet? Register Here!");
        description.setFill(Color.BLUE);
        description.setOnMouseClicked(e -> {
        	registion();
        });
    }

    // Add components to layout
    public void addcomponent() {
        grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Add components to GridPane
        grid.add(titlelabel, 0, 0, 2, 1);
        grid.add(emaillabel, 0, 1);
        grid.add(email, 1, 1);
        grid.add(passwordlabel, 0, 2);
        grid.add(password, 1, 2);
        grid.add(loginbutton, 1, 3);
        grid.add(description, 1, 4);
        description.setOnMouseClicked(e -> {
            registion();
        });
 
        border = new BorderPane();
        border.setCenter(grid);
        GridPane.setHalignment(loginbutton, HPos.CENTER);
        GridPane.setHalignment(titlelabel, HPos.CENTER);

        scene = new Scene(border, 400, 300);
    }

	
    public void hanndlelogin() {
		String useremail = email.getText();
		String userpassword = password.getText();
		
	    if (useremail.isEmpty()) {
	        show(Alert.AlertType.ERROR,"Login Error", "Email cannot be empty");
	    } else if (userpassword.isEmpty()) {
	        show(Alert.AlertType.ERROR,"Login Error", "Password cannot be empty");
	    }
    }
    public void show(Alert.AlertType alerrttype ,String title,String messenger) {
		Alert alertn = new Alert(alerrttype);
		alertn.setTitle(title);
		alertn.setContentText(messenger);
		  alertn.setHeaderText(null);
		alertn.showAndWait();
	}
    
    public void registion() {
		Stage registionstage = new Stage();
		register registionpage = new register();
		try {
			registionpage.start(registionstage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
    @Override
    public void start(Stage primaryStage) throws Exception {
        inisiate(); 
        addcomponent();
        primaryStage.setTitle("Kings Hair Cut");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
