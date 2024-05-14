document.querySelectorAll('.delete-ingredient').forEach(function(button) {
    button.addEventListener('click', function() {
        const ingredientId = this.dataset.ingredientId;
        fetch('/groceries/ingredients/' + ingredientId, {
            method: 'DELETE',
            headers: {
                'X-CSRF-TOKEN': document.querySelector('meta[name="_csrf"]').getAttribute('content')
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                this.parentElement.parentElement.remove();

                const sizeElement = document.getElementById('totalGroceries');
                sizeElement.innerText =  parseInt(sizeElement.textContent) - 1;
            })
            .catch(error => {
                console.error('There has been a problem with your fetch operation:', error);
            });
    });
});


function addPersons() {
    const personsEl = document.getElementById('persons');
    let amountPersons = parseInt(personsEl.textContent);

    amountPersons += 1;
    const quantities = document.querySelectorAll('.quantity')
    quantities.forEach(quantity => {
        console.log(quantity.getAttribute('data-quantity'));
        let quantityData = quantity.getAttribute('data-quantity');

        if (quantityData == 0) {
            quantity.innerText = '';
        } else {
            quantity.innerText = (quantityData * (amountPersons)).toFixed(1);
        }
    })
    personsEl.innerText = amountPersons;
}

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