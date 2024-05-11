function toggleButton() {
    const button = document.getElementById('toggleButton');
    const isActive = button.classList.contains('btn-success');
    const dishId = button.getAttribute('data-dish-id');

    if (isActive) {
        button.classList.remove('btn-success');
        button.classList.add('btn-danger');
        button.textContent = 'Inactive';
    } else {
        button.classList.remove('btn-danger');
        button.classList.add('btn-success');
        button.textContent = 'Active';
    }

    fetch(`/toggle/dish/${dishId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ isActive: !isActive })
    });
}