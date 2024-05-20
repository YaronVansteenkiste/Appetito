function removeBev() {
    let textContainer = document.getElementById("drinkTextContainer");
    let imageContainer = document.getElementById("drinkImageContainer");

    let textInputs = textContainer.getElementsByTagName("input");
    let imageInputs = imageContainer.getElementsByTagName("input");

    let beverageCount = textInputs.length;

    textContainer.removeChild(textInputs[textInputs.length - 1]);

    imageContainer.removeChild(imageInputs[imageInputs.length - 1]);
}
