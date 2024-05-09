function subtractPersons() {
    const personsEl = document.getElementById('persons');
    let amountPersons = parseInt(personsEl.textContent);

    if (amountPersons > 1) {
        amountPersons -= 1;
        const quantities = document.querySelectorAll('.quantity')
        quantities.forEach(quantity => {
            let quantityData = quantity.getAttribute('data-quantity');
            if (quantityData == 0) {
                quantity.innerText = '';
            } else {
                quantity.innerText = (quantityData * (amountPersons)).toFixed(1);
            }
        })
        personsEl.innerText = amountPersons;
    }
}

function addPersons() {
    const personsEl = document.getElementById('persons');
    let amountPersons = parseInt(personsEl.textContent);

    amountPersons += 1;
    const quantities = document.querySelectorAll('.quantity')
    quantities.forEach(quantity => {
        let quantityData = quantity.getAttribute('data-quantity');

        if (quantityData == 0) {
            quantity.innerText = '';
        } else {
            quantity.innerText = (quantityData * (amountPersons)).toFixed(1);
        }
    })
    personsEl.innerText = amountPersons;
}