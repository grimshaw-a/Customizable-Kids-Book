import static org.junit.Assert.*;

import org.junit.Test;

public class ZooBookTest {

	@Test
	public void testGetChildName() {
		ZooBook customBook = new ZooBook();
		String childName = "Ralph";
		customBook.setChildName(childName);
		String returnChildName = customBook.getChildName();
		assertEquals(childName, returnChildName);
	}

	@Test
	public void testGetGender() {
		ZooBook customBook = new ZooBook();
		String gender = "girl";
		customBook.setGender(gender);
		String returnGender = customBook.getGender();
		assertEquals(gender, returnGender);
	}

	@Test
	public void testGetHairColor() {
		ZooBook customBook = new ZooBook();
		String hair = "red";
		customBook.setHairColor(hair);
		String returnHair = customBook.getHairColor();
		assertEquals(hair, returnHair);
	}

	@Test
	public void testGetSkinTone() {
		ZooBook customBook = new ZooBook();
		String skin = "dark";
		customBook.setSkinTone(skin);
		String returnSkin = customBook.getSkinTone();
		assertEquals(skin, returnSkin);
	}

	@Test
	public void testHasGlasses() {
		ZooBook customBook = new ZooBook();
		String glasses = "yes";
		customBook.setGlasses(glasses);
		String returnGlasses = customBook.hasGlasses();
		assertEquals(glasses, returnGlasses);
	}

	@Test
	public void testGetShirtColor() {
		ZooBook customBook = new ZooBook();
		String color = "red";
		customBook.setShirtColor(color);
		String returnColor = customBook.getShirtColor();
		assertEquals(color, returnColor);
	}

	@Test
	public void testGetAnimal() {
		ZooBook customBook = new ZooBook();
		String animal = "tiger";
		customBook.setAnimal(animal);
		String returnAnimal = customBook.getAnimal();
		assertEquals(animal, returnAnimal);
	}

	@Test
	public void testGetFriendName() {
		ZooBook customBook = new ZooBook();
		String friend = "Jackie";
		customBook.setFriendName(friend);
		String returnName = customBook.getFriendName();
		assertEquals(friend, returnName);
	}

}
