
    const hearts = document.querySelectorAll('.heart');

    hearts.forEach(heart => {
    heart.addEventListener('click', function() {
        if (this.classList.contains('text-dark')) {
            this.classList.remove('text-dark');
            this.classList.add('text-danger');
            this.innerHTML = '&#x2764;&#xFE0F;';
        } else {
            this.classList.remove('text-danger');
            this.classList.add('text-dark');
            this.innerHTML = '&#x1F5A4;';
        }
    });
});
