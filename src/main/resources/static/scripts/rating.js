document.querySelectorAll('#ratingForm input[type="radio"]').forEach(function(radio) {
    radio.addEventListener('click', function() {
        document.getElementById('ratingForm').submit();
    });
});


window.onload = function() {
    const starContainers = document.querySelectorAll('.rating-box');

    starContainers.forEach(container => {
        const rating = Math.round(container.dataset.rating);
        const stars = container.querySelectorAll('.fa-star');

        for (let i = 0; i < rating; i++) {
            stars[i].classList.replace('far', 'fas');
        }
    });
};