window.addEventListener('load', function() {
    const starContainers = document.querySelectorAll('.rating-box');

    if (starContainers.length > 0) {
        starContainers.forEach(container => {
            const rating = Math.round(container.dataset.rating);
            const stars = container.querySelectorAll('.fa-star');

            if (stars.length > 0) {
                console.log('Number of stars: ', stars.length);
                console.log('Rating: ', rating);

                for (let i = 0; i < rating; i++) {
                    stars[i].classList.replace('far', 'fas');
                }
            }
        });
    }
});