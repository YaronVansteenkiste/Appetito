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