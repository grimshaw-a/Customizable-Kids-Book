/**
/* Author: Adam Grimshaw 
/* Date: 7/1/20 
/* Course: CSCI 1110 Object Oriented Programming, Southwest Technical College 
/* Description: Customizes pages for a picture book. 
*/

//Reference and open page 1
var page1 = new File('~/Documents/...FilePath.../ZooBook-Page1.tif');
var docRef = app.open(page1);

//Customization information
var textFile = File.openDialog("Open Custom Book File","text(*.txt):*.txt;");
textFile.open('r');
var listString = textFile.read();
textFile.close();
var userInput = listString.split('#');


//Create references to layers that need to be modified
var childAvatar = app.activeDocument.layerSets.getByName('character');
var shirtLayer = childAvatar.layers[4];
var faceLayer = childAvatar.layers[2];
var hairLayer = childAvatar.layers[3];
var glassesLayer = childAvatar.layers[0];

var textGroup = app.activeDocument.layerSets.getByName('textGroup');
var textBox1 = textGroup.layers[0];

//Apply customizations to page
//Gender pronouns
var pronouns = ["She", "she", "Her", "her"];
if(userInput[1] == "boy") {
	pronouns[0] = "He";
	pronouns[1] = "he";
	pronouns[2] = "His";
	pronouns[3] = "his";
}

//Page 1 copy
var page1copy = 'The sun is up and so is ' + userInput[0] + '!\rToday is ' + pronouns[3] + ' birthday,\rand there is so much to do.\r' + pronouns[0] + ' puts on ' + pronouns[3] + ' favorite ' + userInput[5] + ' shirt.';

textBox1.textItem.font = "Courier";
textBox1.textItem.size = 14;
textBox1.textItem.contents = page1copy;

//Face color
if(userInput[3] == "light") {
	faceLayer.adjustColorBalance([0, 0, 0], [80, 40, 0], [70, 40, 10], false);
} else if(userInput[3] == "medium") {
	faceLayer.adjustColorBalance([50, 20, 0], [50, 30, 10], [50, 10, 0], true);
} else {
	faceLayer.adjustColorBalance([-20, -20, -50], [0, -50, -50], [0, 0, 0], false);
}

//Hair color
if(userInput[2] == "black") {
	hairLayer.adjustColorBalance([-100, -100, -100], [0, 0, 0], [-100, -100, -100], false);
} else if(userInput[2] == "brown") {
	hairLayer.adjustColorBalance([0, 0, 0], [-50, -90, -100], [0, 0, 0], false);
} else if(userInput[2] == "blonde") {
	hairLayer.adjustColorBalance([0, 0, 0], [0, 0, -100], [75, 25, -75], true);
} else if(userInput[2] == "red") {
	hairLayer.adjustColorBalance([0, 0, 0], [100, 0, -100], [100, -100, -50], false);
}

//Glasses
if(userInput[4] == "yes") {
	glassesLayer.visible = true;
}

//Shirt color
if(userInput[5] == "red") {
	shirtLayer.adjustColorBalance([60, -30, -20], [90, -40, 10], [90, -30, 0], false);
} else if(userInput[5] == "green") {
	shirtLayer.adjustColorBalance([0, 0, 0], [0, 80, 0], [0, 0, 0], true);
} else if(userInput[5] == "purple") {
	shirtLayer.adjustColorBalance([0, 0, 20], [0, -100, 0], [0, 0, 0], false);
} else if(userInput[5] == "yellow") {
	shirtLayer.adjustColorBalance([25, 10, 0], [25, 0, -75], [100, 0, -100], true);
} 

//Export page 1 to jpeg
saveJpeg(userInput[0] + '-Page-1');
app.activeDocument.close(SaveOptions.DONOTSAVECHANGES);

//Open page 2
var page2 = new File('~/Documents/...FilePath.../ZooBook-Page2.tif');
app.open(page2);

//Set text for page 2
var textGroup2 = app.activeDocument.layerSets.getByName('textGroup');
var textBox2 = textGroup2.layers[0];

var page2copy = 'The first stop is to pick up ' + userInput[7] + '.\rThen they head to the zoo. ' + userInput[0] + ' is excited to see ' + pronouns[3] + ' favorite animal, the ' + userInput[6] + '.';

textBox2.textItem.font = "Courier";
textBox2.textItem.size = 14;
textBox2.textItem.contents = page2copy;

//Set animal picture for page 2
var animalGroup = app.activeDocument.layerSets.getByName('animal');
if(userInput[6] == "tiger") {
	animalGroup.layers[1].visible = true;
} else if(userInput[6] == "elephant") {
	animalGroup.layers[0].visible = true;
} else if(userInput[6] == "giraffe") {
	animalGroup.layers[2].visible = true;
}

//Export jpeg for page 2
saveJpeg(userInput[0] + '-Page-2');
app.activeDocument.close(SaveOptions.DONOTSAVECHANGES);

/*Function to export jpeg*/
function saveJpeg(name) {
	var doc = app.activeDocument;
	var file = new File(doc.path + '/Orders/' + name + '.jpg');
	var opts = new JPEGSaveOptions();
	
	opts.quality = 10;
	doc.saveAs(file, opts, true);
}
