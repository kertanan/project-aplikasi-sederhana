package Mian;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class register extends Application { // Capitalize class name
    Label titleLabel, usernameLabel, emailLabel, passwordLabel, confirmPasswordLabel, phoneLabel, genderLabel;
    TextField usernameField, emailField, phoneField;
    PasswordField passwordField, confirmPasswordField;
    RadioButton maleRadio, femaleRadio;
    ToggleGroup genderGroup;
    Button registerButton;
    Text description, errorText;
    Scene scene;
    BorderPane border;
    GridPane grid;
  
    // Initialize components
    public void initiate() { // Corrected method name
        titleLabel = new Label("Register");
        titleLabel.setFont(new Font("Arial", 24));

        usernameLabel = new Label("Username");
        usernameField = new TextField();
        usernameField.setPromptText("Enter your username");

        emailLabel = new Label("Email");
        emailField = new TextField();
        emailField.setPromptText("Enter your email");

        passwordLabel = new Label("Password");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        confirmPasswordLabel = new Label("Confirm Password");
        confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm your password");

        phoneLabel = new Label("Phone Number");
        phoneField = new TextField();
        phoneField.setPromptText("Enter your phone number");

        genderLabel = new Label("Gender");
        genderGroup = new ToggleGroup();
        maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(genderGroup);

        registerButton = new Button("Register");
        registerButton.setOnAction(e-> {
        	validateinput();
        });

        description = new Text("Already have an account? Login here!");
        description.setFill(Color.BLUE);
        description.setOnMouseClicked(e -> {
        	 System.out.println("Redirecting to registration page...");
        });

        errorText = new Text();
        errorText.setFill(Color.RED);
    }	

    public void addComponent() { // Corrected method name
        grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Add components to GridPane
        grid.add(titleLabel, 0, 0, 2, 1);
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(passwordLabel, 0, 3);
        grid.add(passwordField, 1, 3);
        grid.add(confirmPasswordLabel, 0, 4);
        grid.add(confirmPasswordField, 1, 4);
        grid.add(phoneLabel, 0, 5);
        grid.add(phoneField, 1, 5);
        grid.add(genderLabel, 0, 6);
        grid.add(maleRadio, 1, 6);
        grid.add(femaleRadio, 1, 7);
        grid.add(registerButton, 1, 8);
        grid.add(description, 1, 9);
        grid.add(errorText, 1, 10);

        border = new BorderPane();
        border.setCenter(grid);
        GridPane.setHalignment(registerButton, HPos.CENTER);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        scene = new Scene(border, 400, 300);
    }

    private  String validateinput() {
		String username = usernameField.getText();
		String email = emailField.getText();
		String password = passwordField.getText();
		String confirmpassword = confirmPasswordField.getText();
		String phonenumber = phoneField.getText();
		
//		if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phonenumber.isEmpty()) {
//			System.out.println("all failed required");
//		}else if (username.length() < 5 || username.length() >30) {
//			System.out.println("username must be between 5 and 30");
//		}else if (!email.endsWith("@gmail.com")) {
//			 return "Email must end with @gmail.com.";
//		}else if (password.length() < 8|| password.length() > 15 || !password.matches(".*[A-Za-z].*") || !password.matches(".*\\d.*")) {
//			/*
//			 * Ekspresi !password.matches(".*[A-Za-z].*") || !password.matches(".*\\d.*")
//			 *  digunakan untuk memvalidasi bahwa sebuah kata sandi
//			 *  alphanumeric, artinya mengandung setidaknya satu huruf dan 
//			 *  setidaknya satu angka. Berikut adalah penjelasan setiap bagiannya:
//
//password.matches(".*[A-Za-z].*"):
//
//Ini memeriksa apakah string password mengandung setidaknya satu huruf (baik huruf besar atau kecil).
//.* sebelum dan sesudah [A-Za-z] berarti bisa ada karakter apa pun (termasuk tidak ada) sebelum atau setelah huruf.
//[A-Za-z] adalah kelas karakter yang mencocokkan huruf apa pun dari A hingga Z (huruf besar) atau a hingga z (huruf kecil).
//password.matches(".*\\d.*"):
//
//Ini memeriksa apakah string password mengandung setidaknya satu angka.
//\\d adalah pola ekspresi reguler yang mencocokkan angka apa pun (0-9).
//Operator ! (tidak):
//
//!password.matches(".*[A-Za-z].*") memeriksa apakah kata sandi tidak mengandung huruf apa pun.
//!password.matches(".*\\d.*") memeriksa apakah kata sandi tidak mengandung angka apa pun.
//Operator || (atau):
//
//Ini menggabungkan kedua pemeriksaan tersebut. Jika salah satu kondisi true 
//(artinya jika kata sandi tidak mengandung huruf atau tidak mengandung angka), seluruh ekspresi menjadi true,
// yang menunjukkan bahwa kata sandi tidak alphanumeric.
//			 */
//		}else if (!password.equals(confirmpassword) ) {
//			 return "Passwords do not match.";
//		}else if (phonenumber.length() <5 || password.length() >15 ||!phonenumber.startsWith("+62")) {
//			return "Phone number must be between 9 and 13 digits and start with 62.";
//		}
//		return "";
		 if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmpassword.isEmpty() || phonenumber.isEmpty()) {
		        show(Alert.AlertType.ERROR, "Registration Error", "All fields are required.");
		    } else if (username.length() < 5 || username.length() > 30) {
		        show(Alert.AlertType.ERROR, "Registration Error", "Username must be between 5 and 30 characters.");
		    } else if (!email.endsWith("@gmail.com")) {
		        show(Alert.AlertType.ERROR, "Registration Error", "Email must end with @gmail.com.");
		    } else if (password.length() < 8 || password.length() > 15) {
		        show(Alert.AlertType.ERROR, "Registration Error", "Password must be between 8 and 15 characters.");
		    } else if (!password.matches(".*[A-Za-z].*") || !password.matches(".*\\d.*")) {
		        show(Alert.AlertType.ERROR, "Registration Error", "Password must contain both letters and numbers.");
		    } else if (!password.equals(confirmpassword)) {
		        show(Alert.AlertType.ERROR, "Registration Error", "Passwords do not match.");
		    } else if (phonenumber.length() < 9 || phonenumber.length() > 13 || !phonenumber.startsWith("62")) {
		        show(Alert.AlertType.ERROR, "Registration Error", "Phone number must start with 62 and be 9 to 13 characters long.");
		    } else {
		        // If all validations pass
		        return null; // Returning null to indicate no validation errors
		    }
		return null;}
    
    public void eventregister() {
    	  String validationMessage = validateinput();
          if (validationMessage.isEmpty()) {
              errorText.setText("Registration successful! Redirecting to login page...");
              // Implement actual registration logic and redirection here.
          } else {
              errorText.setText(validationMessage);
          }
      }
	
    public void show(Alert.AlertType alerrttype ,String title,String messenger) {
  		Alert alertn = new Alert(alerrttype);
  		alertn.setTitle(title);
  		alertn.setContentText(messenger);
  		  alertn.setHeaderText(null);
  		alertn.showAndWait();
  	}
    @Override
    public void start(Stage primaryStage) throws Exception {
        initiate(); 
        addComponent();
        primaryStage.setTitle("Kings Hair Cut");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
