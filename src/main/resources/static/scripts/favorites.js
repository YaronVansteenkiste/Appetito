document.addEventListener('DOMContentLoaded', () => {
    const favorites = JSON.parse(sessionStorage.getItem('favorites')) || {};

    document.querySelectorAll('.heart').forEach(function(heart) {
        const dishId = heart.getAttribute('data-dish-id');

        if (favorites[dishId] === 'added') {
            heart.classList.remove('text-dark');
            heart.classList.add('text-danger');
            heart.innerHTML = '&#x2764;&#xFE0F;';
            heart.nextElementSibling.textContent = 'Verwijderen';
        }

        heart.addEventListener('click', function() {
            const statusText = heart.nextElementSibling;
            const chefId = 1;
            const action = heart.classList.contains('text-danger') ? 'remove' : 'add';

            const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');

            fetch('/add-favorite', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    // 'X-CSRF-TOKEN': csrfToken
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
                        favorites[dishId] = 'added';
                    } else {
                        heart.classList.remove('text-danger');
                        heart.classList.add('text-dark');
                        heart.innerHTML = '&#x1F5A4;';
                        statusText.textContent = 'Toevoegen';
                        delete favorites[dishId];
                    }
                    sessionStorage.setItem('favorites', JSON.stringify(favorites));
                })

        });
    });
});
