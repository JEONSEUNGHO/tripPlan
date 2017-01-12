
// 2.When the user enters in text into the text area and then clicks the create button, 
// create a new card element in the DOM. You decide the height/width of the card.


// Variables for DOM elements
var userInput;
var userInputField = document.getElementById("input-field");
var createButton = document.getElementById("create");
var outputArea = document.getElementById("card-output");

// Creates an Click Function that takes the user input and inputs in into the DOM on a card.
createButton.addEventListener("click", function(event) {
  userInput = document.getElementById("input-field").value;
  outputArea.innerHTML += "<article>" + userInput + "<button id='delete'>Delete</button>" + "</article>"; 
  userInputField.value = "";
});

// Creates a Delete Function that removes the targeted card from the DOM.

outputArea.addEventListener("click", function(event) {
  if (event.target.id === "delete") {
    toDelete = event.target.parentNode;
    outputArea.removeChild(toDelete);
  };
});