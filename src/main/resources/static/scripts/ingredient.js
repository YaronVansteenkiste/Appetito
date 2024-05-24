let originalQuantitiesForOnePerson = [];

window.addEventListener("load", calcQuantities);

function calcQuantities () {
    const quantities = document.querySelectorAll('.quantity');
    const personsEl = document.getElementById('persons');
    const amountPersons = parseInt(personsEl.textContent);

    quantities.forEach(quantity => {
        let originalQuantity = parseFloat(quantity.getAttribute('data-quantity')/amountPersons);
        originalQuantitiesForOnePerson.push(originalQuantity);
    });
}

function subtractPersons() {
    const personsEl = document.getElementById('persons');
    let amountPersons = parseInt(personsEl.textContent);

    if (amountPersons > 1) {
        amountPersons -= 1;

        const quantities = document.querySelectorAll('.quantity');
        quantities.forEach((quantity, i) => {
            if (originalQuantitiesForOnePerson[i] != 0) {
                let newQuantity = (originalQuantitiesForOnePerson[i] ) * (amountPersons);
                quantity.innerText = newQuantity.toFixed(1);
            }
        });
        personsEl.innerText = amountPersons;
    }
}

function addPersons() {
    const personsEl = document.getElementById('persons');
    let amountPersons = parseInt(personsEl.textContent);

    amountPersons += 1;
    const quantities = document.querySelectorAll('.quantity');
    quantities.forEach((quantity, i) => {
        if (originalQuantitiesForOnePerson[i] != 0) {
            let newQuantity = (originalQuantitiesForOnePerson[i] ) * amountPersons;
            quantity.innerText = newQuantity.toFixed(1);
        }
    });
    personsEl.innerText = amountPersons;
}