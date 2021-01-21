import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import java.io.*;
import java.time.LocalDate;

/**
 * <h1>Custom Book Generator</h1>
 * <p>This program creates a GUI for customers to enter information that will be used in creating them a custom book.</p>
 * @author Adam Grimshaw
 * Date: 2020-07-08
 * Course: CSCI 1110 Object Oriented Programming, Southwest Technical College
 */
public class InputScreenInterface extends Application {
	//Global properties used in the methods below. Creates an instance of ZooBook.
	BorderPane mainPane = new BorderPane();
	Text instructions = new Text();
	Button back = new Button("Back");
	Button next = new Button("Next");
	Button finish = new Button("Done");
	HBox buttonBox = new HBox(20);
	TextField inputText = new TextField();
	Label warningLabel = new Label();
	ComboBox<String> dropDown = new ComboBox<>();
	VBox rows = new VBox(20);
	ZooBook customBook = new ZooBook();
	
	/**This method is called by the main method on launch. Sets up the initial screen of the GUI.*/
	@Override
	public void start(Stage primaryStage) {
		
		instructions.setText("Welcome to the book customization tool. Please follow the prompts and enter the requested information. Click \"Next\" to continue.");
		instructions.setWrappingWidth(300);
		instructions.setTextAlignment(TextAlignment.JUSTIFY);
		
		mainPane.setCenter(rows);
		rows.setMaxWidth(300);
		rows.getChildren().addAll(instructions, next);
		rows.setAlignment(Pos.CENTER);
		
		Scene scene1 = new Scene(mainPane, 400, 300);
		primaryStage.setTitle("Book Customization");
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		next.setOnAction(e -> {
			loadFrame2();
		});
	}
	
	/**Loads the second screen of the GUI. Requests information for the child name property.*/
	public void loadFrame2() {
		rows.getChildren().removeAll(next, inputText, instructions, dropDown, buttonBox);
		buttonBox.getChildren().removeAll(back, next);
		instructions.setText("Please enter the name of the child.");
		instructions.setTextAlignment(TextAlignment.CENTER);
		rows.getChildren().addAll(instructions, inputText, warningLabel, buttonBox);
		
		inputText.setMaxWidth(200);	
		buttonBox.getChildren().addAll(back, next);
		buttonBox.setMaxWidth(120);
		next.setDisable(true);
		if(customBook.getChildName().length() > 0) {
			inputText.setText(customBook.getChildName());
			next.setDisable(false);
		};
		
		inputText.setOnKeyTyped(e -> {
			next.setDisable(false);
		});
		back.setDisable(true);
		next.setOnAction(e -> {
			if(inputText.getText().length() > 12) {
				warningLabel.setText("*Please limit name to 12 characters.");
				warningLabel.setTextFill(Color.RED);
			} else {
				warningLabel.setText("");
				customBook.setChildName(inputText.getText());
				loadFrame3();
			}
		});
	}
	
	/**Loads the third screen of the GUI. Requests information for the gender property.*/
	public void loadFrame3() {
		rows.getChildren().removeAll(next, inputText, warningLabel, instructions, dropDown, buttonBox);
		instructions.setText("Select a gender.");
		dropDown.getItems().removeAll("girl", "boy", "brown", "black", "blonde", "red");
		dropDown.getItems().addAll("girl", "boy");
		rows.getChildren().addAll(instructions, dropDown, buttonBox);
		dropDown.setValue(customBook.getGender());
		if(dropDown.getValue() == null) {
			next.setDisable(true);
		}
		back.setDisable(false);
		
		dropDown.setOnAction(e -> {
			next.setDisable(false);
		});
		
		back.setOnAction(e -> {
			loadFrame2();
		});
		
		next.setOnAction(e -> {
			customBook.setGender(dropDown.getValue());
			loadFrame4();
		});
	}
	
	/**Loads the fourth screen of the GUI. Requests information for the hair color property.*/
	public void loadFrame4() {
		rows.getChildren().removeAll(next, inputText, instructions, dropDown, buttonBox);
		instructions.setText("Select hair color.");
		dropDown.getItems().removeAll("girl", "boy", "dark", "medium", "light");
		dropDown.getItems().addAll("brown", "black", "blonde", "red");
		rows.getChildren().addAll(instructions, dropDown, buttonBox);
		dropDown.setValue(customBook.getHairColor());
		if(dropDown.getValue() == null) {
			next.setDisable(true);
		}
		
		dropDown.setOnAction(e -> {
			next.setDisable(false);
		});
		
		back.setOnAction(e -> {
			loadFrame3();
		});
		
		next.setOnAction(e -> {
			customBook.setHairColor(dropDown.getValue());
			loadFrame5();
		});
	}

	/**Loads the fifth screen of the GUI. Requests information for the skin tone property.*/
	public void loadFrame5() {
		rows.getChildren().removeAll(next, inputText, instructions, dropDown, buttonBox);
		instructions.setText("Select a skin tone.");
		dropDown.getItems().removeAll("brown", "black", "blonde", "red", "yes", "no");
		dropDown.getItems().addAll("dark", "medium", "light");
		rows.getChildren().addAll(instructions, dropDown, buttonBox);
		dropDown.setValue(customBook.getSkinTone());
		if(dropDown.getValue() == null) {
			next.setDisable(true);
		}
		
		dropDown.setOnAction(e -> {
			next.setDisable(false);
		});
		
		back.setOnAction(e -> {
			loadFrame4();
		});
		
		next.setOnAction(e -> {
			customBook.setSkinTone(dropDown.getValue());
			loadFrame6();
		});
	}
	
	/**Loads the sixth screen of the GUI. Requests information for the glasses property.*/
	public void loadFrame6() {
		rows.getChildren().removeAll(next, inputText, instructions, dropDown, buttonBox);
		instructions.setText("Does the child wear glasses?");
		dropDown.getItems().removeAll("dark", "medium", "light", "red", "purple", "green", "yellow");
		dropDown.getItems().addAll("yes", "no");
		rows.getChildren().addAll(instructions, dropDown, buttonBox);
		dropDown.setValue(customBook.hasGlasses());
		if(dropDown.getValue() == null) {
			next.setDisable(true);
		}
		
		dropDown.setOnAction(e -> {
			next.setDisable(false);
		});
		
		back.setOnAction(e -> {
			loadFrame5();
		});
		
		next.setOnAction(e -> {
			customBook.setGlasses(dropDown.getValue());
			loadFrame7();
		});
	}
	
	/**Loads the seventh screen of the GUI. Requests information for the shirt color property.*/
	public void loadFrame7() {
		rows.getChildren().removeAll(next, inputText, instructions, dropDown, buttonBox);
		instructions.setText("Child's favorite color:");
		dropDown.getItems().removeAll("yes", "no", "tiger", "giraffe", "elephant");
		dropDown.getItems().addAll("red", "purple", "green", "yellow");
		rows.getChildren().addAll(instructions, dropDown, buttonBox);
		dropDown.setValue(customBook.getShirtColor());
		if(dropDown.getValue() == null) {
			next.setDisable(true);
		}
		
		dropDown.setOnAction(e -> {
			next.setDisable(false);
		});
		
		back.setOnAction(e -> {
			loadFrame6();
		});
		
		next.setOnAction(e -> {
			customBook.setShirtColor(dropDown.getValue());
			loadFrame8();
		});
	}
	
	/**Loads the eighth screen of the GUI. Requests information for the animal property.*/
	public void loadFrame8() {
		rows.getChildren().removeAll(next, inputText, instructions, dropDown, buttonBox);
		buttonBox.getChildren().remove(finish);
		buttonBox.getChildren().remove(next);
		buttonBox.getChildren().add(next);
		instructions.setText("Child's favorite animal:");
		dropDown.getItems().removeAll("red", "purple", "green", "yellow");
		dropDown.getItems().addAll("tiger", "giraffe", "elephant");
		rows.getChildren().addAll(instructions, dropDown, buttonBox);
		dropDown.setValue(customBook.getAnimal());
		if(dropDown.getValue() == null) {
			next.setDisable(true);
		}
		
		dropDown.setOnAction(e -> {
			next.setDisable(false);
		});
		
		back.setOnAction(e -> {
			loadFrame7();
		});
		
		next.setOnAction(e -> {
			customBook.setAnimal(dropDown.getValue());
			loadFrame9();
		});
	}
	
	/**
	 * Loads the ninth screen of the GUI. Requests information for the child's friend property.
	 * On pressing the Done button, (finish), it takes all properties defined in the instance of
	 * ZooBook, (customBook), and writes them to an external file.*/
	public void loadFrame9() {
		rows.getChildren().removeAll(next, inputText, instructions, dropDown, buttonBox);
		buttonBox.getChildren().remove(next);
		buttonBox.getChildren().add(finish);
		instructions.setText("Name of child's friend:");
		inputText.clear();
		dropDown.getItems().removeAll("tiger", "giraffe", "elephant");
		rows.getChildren().addAll(instructions, inputText, warningLabel, buttonBox);
		finish.setDisable(true);
		
		inputText.setOnKeyTyped(e -> {
			finish.setDisable(false);
		});
		
		back.setOnAction(e -> {
			loadFrame8();
		});
		
		finish.setOnAction(e -> {
			if(inputText.getText().length() > 12) {
				warningLabel.setText("*Please limit name to 12 characters.");
				warningLabel.setTextFill(Color.RED);
			} else {
				customBook.setFriendName(inputText.getText());
				java.time.LocalDate todayDate = LocalDate.now();
				String filename = "/Users/...FilePath.../" + todayDate + "-" + customBook.getChildName() + ".txt";
				try {
					BufferedWriter output = new BufferedWriter(new FileWriter(filename));
					output.write(customBook.getChildName() + "#" + customBook.getGender() + "#" + customBook.getHairColor() + "#" + customBook.getSkinTone() + "#" + customBook.hasGlasses() + "#" + customBook.getShirtColor() + "#" + customBook.getAnimal() + "#" + customBook.getFriendName());
					output.close();
				} catch(IOException ex) {
					System.out.println("I/O exception thrown.");
				}
				loadFrame10();
			}
		});
	}
	
	/**Loads the tenth screen of the GUI. Confirms that all information was submitted successfully.*/
	public void loadFrame10() {
		rows.getChildren().removeAll(next, inputText, warningLabel, instructions, dropDown, buttonBox);
		buttonBox.getChildren().removeAll(back, next);
		instructions.setText("Thank you!\n\nYour customization preferences have been submitted succesfully.");
		rows.getChildren().addAll(instructions);
	}
	
	/**
	 * The main method. Immediately calls the start method. 
	 * @param args Not used.
	 */
	public static void main(String[] args) {
	    Application.launch(args);
	  }
}
