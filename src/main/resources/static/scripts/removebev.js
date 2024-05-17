function removeBev() {
    var container = document.getElementById("drinkContainer");
    var beverageCount = container.getElementsByTagName("input").length;

    if (beverageCount <= 1) {
        alert("You must have at least one beverage.");
        return;
    }

    container.removeChild(container.lastElementChild);
}
