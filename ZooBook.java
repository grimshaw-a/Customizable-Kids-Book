/**
 * <h1>Custom Book Generator</h1>
 * <p>This class describes the contents of a zoo themed childrens book. It sets up all the customizable properties of the book.</p>
 * @author Adam Grimshaw
 * Date: 2020-07-08
 * Course: CSCI 1110 Object Oriented Programming, Southwest Technical College
 */
public class ZooBook {
	private String childName = "";
	private String gender;
	private String hairColor;
	private String skinTone;
	private String glasses;
	private String shirtColor;
	private String animal;
	private String friendName;
	
	/**Creates an instance of ZooBook with no properties defined.*/
	public ZooBook() {	
	}
	
	/**
	 * Creates an instance of ZooBook with all properties defined. 
	 * @param name The name of the child starring in the book.
	 * @param gender The gender of the child in the book.
	 * @param hair The hair color of the child in the book.
	 * @param skin The skin color of the child in the book.
	 * @param glasses Yes if the child wears glasses. No if the child does not.
	 * @param shirt The shirt color of the child in the book.
	 * @param animal Which animal will the book feature: Tiger, Elephant, or Giraffe.
	 * @param friend The name of the child's friend.
	 */
	public ZooBook(String name, String gender, String hair, String skin, String glasses, String shirt, String animal, String friend) {
		this.childName = name;
		this.gender = gender;
		this.hairColor = hair;
		this.skinTone = skin;
		this.glasses = glasses;
		this.shirtColor = shirt;
		this.animal = animal;
		this.friendName = friend;
	}
	
	/*Getters and setters for each property.*/
	public String getChildName() {
		return childName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getHairColor() {
		return hairColor;
	}
	
	public String getSkinTone() {
		return skinTone;
	}
	
	public String hasGlasses() {
		return glasses;
	}
	
	public String getShirtColor() {
		return shirtColor;
	}
	
	public String getAnimal() {
		return animal;
	}
	
	public String getFriendName() {
		return friendName;
	}
	
	public void setChildName(String name) {
		this.childName = name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setHairColor(String hair) {
		this.hairColor = hair;
	}
	
	public void setSkinTone(String skin) {
		this.skinTone = skin;
	}
	
	public void setGlasses(String glasses) {
		this.glasses = glasses;
	}
	
	public void setShirtColor(String color) {
		this.shirtColor = color;
	}
	
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	
	public void setFriendName(String name) {
		this.friendName = name;
	}
}
