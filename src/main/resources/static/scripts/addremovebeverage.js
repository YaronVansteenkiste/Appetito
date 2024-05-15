let bevCount = 0;

function addBev() {
    let drinkContainer = document.getElementById('drinkContainer');

    bevCount++;

    let bevContainer = document.createElement('div');
    bevContainer.classList.add('row', 'mb-3');

    let imageInput = document.createElement('div');
    imageInput.classList.add('col-sm-6');
    imageInput.innerHTML = `
        <input class="form-control" type="file" id="bevimage${bevCount}" accept="image/*" name="image${bevCount}">`;

    let drinkInput = document.createElement('div');
    drinkInput.classList.add('col-sm-6');
    drinkInput.innerHTML = `
        <input class="form-control" type="text" name="drinks${bevCount}">`;

    bevContainer.appendChild(imageInput);
    bevContainer.appendChild(drinkInput);

    drinkContainer.appendChild(bevContainer);
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