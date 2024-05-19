function addBev() {
    let textContainer = document.getElementById("drinkTextContainer");
    let imageContainer = document.getElementById("drinkImageContainer");

    let textInput = document.createElement("input");
    textInput.className = "form-control mb-3";
    textInput.setAttribute("type", "text");
    textInput.setAttribute("name", "beverageNames[]");

    let imageInput = document.createElement("input");
    imageInput.className = "form-control mb-3";
    imageInput.setAttribute("type", "file");
    imageInput.setAttribute("accept", "image/*");
    imageInput.setAttribute("name", "beverageImages[]");

    textContainer.appendChild(textInput);
    imageContainer.appendChild(imageInput);
}
