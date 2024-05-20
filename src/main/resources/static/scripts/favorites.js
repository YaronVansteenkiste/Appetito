document.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll('.heart').forEach(function(heart) {
        heart.addEventListener('click', function() {
            const statusText = heart.nextElementSibling;
            const dishId = heart.getAttribute('data-dish-id');
            const chefId = 1;
            const action = heart.classList.contains('text-danger') ? 'remove' : 'add';

            const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');

            fetch('/add-favorite', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'X-CSRF-TOKEN': csrfToken
                },
                body: JSON.stringify({
                    favoriteDishesId: dishId,
                    chefId: chefId,
                    action: action
                })
            })
                .then(response => response.text())
                .then(data => {
                    if (action === 'add') {
                        heart.classList.remove('text-dark');
                        heart.classList.add('text-danger');
                        heart.innerHTML = '&#x2764;&#xFE0F;';
                        statusText.textContent = 'Verwijderen';
                    } else {
                        heart.classList.remove('text-danger');
                        heart.classList.add('text-dark');
                        heart.innerHTML = '&#x1F5A4;';
                        statusText.textContent = 'Toevoegen';
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });
    });
});



