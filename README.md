# Custom Children's Book

## Synopsis
This folder contains all files necessary to create a custom children's book. This is my final project for my Object Oriented Programming class at Southwest Tech.

## Motivation
<p>My friend was creating custom books and compositing them all manually. I created this for him so that the process would be automated and he could save time.</p>

## How to Run
This program works in two parts. The first part gathers customization information from the user. This is done through a GUI created using JavaFX. Two java files are necessary to make the GUI run: ZooBook.java and InputScreenInterface.java. ZooBook.java defines a class that stores all the customizable properties for the book. InputScreenInterface.java creates an instance of the ZooBook class and then generates a GUI that prompts the user to enter their customization preferences. These preferences are recorded in an instance of ZooBook and then exported to a .txt file. Before using, the code MUST be updated with a valid path for where the .txt file will be stored.
The second part of the process is to apply the customization preferences to the text and graphics of the book. Each spread of the book is stored as a .tif file. A javascript file is provided that will manipulate the .tif files in Adobe Photoshop CC to reflect the customization preferences. The file is named ApplyCustomizations.jsx. This script should be compatible with most versions of Photoshop CC. Again, the code in this script MUST be updated with a valid path for both location of the .tif files and a location to export .jpg files.

## Code Example
After making selections and entering custom information, the user comes to the final input screen of the GUI. This screen prompts the user to enter a child's name in a text field. Upon completion, the user clicks the "Finish" button, initiating the following lines of code. The program first looks to see if the entered String is under twelve characters. If not, it halts the process and prints a warning. Otherwise, the String is read from the text field and stored in the ZooBook object. A new .txt file is created and named using the current date and the child's name. The customization information is retrieved from the ZooBook object and written to the .txt file where it can later be used to customize the book's layout files. Finally, it calls a method to load a screen confirming that all information has been recorded succesfully.
```
finish.setOnAction(e -> {
			if(inputText.getText().length() > 12) {
				warningLabel.setText("*Please limit name to 12 characters.");
				warningLabel.setTextFill(Color.RED);
			} else {
				customBook.setFriendName(inputText.getText());
				java.time.LocalDate todayDate = LocalDate.now();
				String filename = "/Users/..FilePath.../" + todayDate + "-" + customBook.getChildName() + ".txt";
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
```
  
## Tests
The GUI prompts the user to enter a child's name in a text field. When the user clicks "Next", the setFriendName method is called. It reads the text in the text field and stores it as a String. The getFriendName method is used later to retrieve this String and write it to an output file along with the other custom information.
```
@Test
public void testGetFriendName() {
  ZooBook customBook = new ZooBook();
	String friend = "Jackie";
	customBook.setFriendName(friend);
	String returnName = customBook.getFriendName();
	assertEquals(friend, returnName);
}
```
