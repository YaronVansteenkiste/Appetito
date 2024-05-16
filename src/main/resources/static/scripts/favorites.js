document.querySelectorAll('.heart').forEach(function(heart) {
    heart.addEventListener('click', function() {
        const statusText = heart.nextElementSibling;
        if (heart.classList.contains('text-danger')) {
            heart.classList.remove('text-danger');
            heart.classList.add('text-dark');
            heart.innerHTML = '&#x1F5A4;';
            statusText.textContent = 'Toevoegen';
        } else {
            heart.classList.remove('text-dark');
            heart.classList.add('text-danger');
            heart.innerHTML = '&#x2764;&#xFE0F;';
            statusText.textContent = 'Verwijderen';
        }
    });
});

