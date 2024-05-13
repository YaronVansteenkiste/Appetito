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



const counterElement = document.querySelector('.counter');

document.querySelector('.btn.btn-outline-primary.rounded-circle.ms-2').addEventListener('click', function() {
    counterElement.textContent = parseInt(counterElement.textContent) + 1;

    document.querySelectorAll('[id^="quantity"]').forEach(function(quantityElement) {
        var originalQuantity = quantityElement.dataset.originalQuantity;
        quantityElement.textContent = originalQuantity * parseInt(counterElement.textContent);
    });
});

document.querySelectorAll('.btn.btn-outline-primary.rounded-circle.ms-2')[1].addEventListener('click', function() {
    if (parseInt(counterElement.textContent) > 0) {
        counterElement.textContent = parseInt(counterElement.textContent) - 1;

        document.querySelectorAll('[id^="quantity"]').forEach(function(quantityElement) {
            var originalQuantity = quantityElement.dataset.originalQuantity;
            quantityElement.textContent = originalQuantity * parseInt(counterElement.textContent);
        });
    }
});

document.querySelectorAll('[id^="quantity"]').forEach(function(quantityElement) {
    quantityElement.dataset.originalQuantity = parseInt(quantityElement.textContent);
});