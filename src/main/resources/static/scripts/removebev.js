function removeBev() {
    let textContainer = document.getElementById("drinkTextContainer");
    let imageContainer = document.getElementById("drinkImageContainer");

    let textInputs = textContainer.getElementsByTagName("input");
    let imageInputs = imageContainer.getElementsByTagName("input");

    let beverageCount = textInputs.length;

    if (beverageCount <= 1) {
        alert("You must have at least one beverage.");
        return;
    }

    textContainer.removeChild(textInputs[textInputs.length - 1]);
    imageContainer.removeChild(imageInputs[imageInputs.length - 1]);
}
function deleteBeverage(dishId, beverageId) {
    if (confirm('Ben je zeker dat je dit wilt verwijderen?')) {
        fetch(`/modify/deletebeverage/${dishId}/${beverageId}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert('Failed to delete the beverage');
            }
        }).catch(error => {
            console.error('Error:', error);
            alert('Failed to delete the beverage');
        });
    }
}