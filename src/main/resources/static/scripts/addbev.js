function addBev() {
    let textContainer = document.getElementById("drinkTextContainer");
    let imageContainer = document.getElementById("drinkImageContainer");

    let textInput = document.createElement("input");
    textInput.className = "form-control mb-3";
    textInput.setAttribute("type", "text");
    textInput.setAttribute("beverageNames", "drinks");

    let imageInput = document.createElement("input");
    imageInput.className = "form-control mb-3";
    imageInput.setAttribute("type", "file");
    imageInput.setAttribute("accept", "image/*");
    imageInput.setAttribute("beverageImages", "beverageImages");

    textContainer.appendChild(textInput);
    imageContainer.appendChild(imageInput);
}
