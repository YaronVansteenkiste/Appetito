function addBev() {
    let drinkInput = document.createElement('div');
    drinkInput.classList.add('row', 'mb-3');
    drinkInput.innerHTML = `
        <label class="col-sm-4 col-form-label">Drank(en)</label>
        <div class="col-sm-4">
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