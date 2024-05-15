function addBev() {
    let drinkInput = document.createElement('bevs');
    drinkInput.innerHTML = `
        <div class="col-sm-12 mt-2">
            <input class="form-control" type="text" name="drinks">
        </div>`;
    document.getElementById('drinkContainer').appendChild(drinkInput);
}

function removeBev() {
    let drinkContainer = document.getElementById('drinkContainer');
    if (drinkContainer.children.length > 1) {
        drinkContainer.removeChild(drinkContainer.lastChild);
    } else {
        alert("At least one drink input must be present.");
    }
}

document.querySelectorAll('.btn-outline-success, .btn-outline-dark').forEach(function(button) {
    button.addEventListener('click', function(event) {
        event.preventDefault();
    });
});