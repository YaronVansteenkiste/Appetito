document.querySelectorAll('.delete-ingredient').forEach(button => {
    button.addEventListener('click', function() {
        const ingredientId = this.getAttribute('data-ingredient-id');

        fetch(`/groceries/deleteIngredient/${ingredientId}`, {
            method: 'DELETE',
        })
        .then(response => {
            if (response.ok) {
                this.parentElement.parentElement.remove();
            } else {
                console.error('Failed to delete ingredient');
            }
        })
        .catch(error => console.error('Error:', error));
        window.location.reload();
    });
});


function clearAllGroceries() {
    fetch('/groceries/clear', {
        method: 'POST',
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        location.reload();
    })
    .catch(error => console.error('Error:', error));
}