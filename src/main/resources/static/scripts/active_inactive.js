
document.addEventListener('click', function(event) {
    if (event.target && event.target.classList.contains('btn-danger')) {
        toggleInactive(event.target);
    }
});

function toggleInactive(button) {
    let card = button.closest('.card');
    let isActive = !card.classList.contains('inactive');

    if (isActive) {
        let imgSrc = card.querySelector('img').src;
        let name = card.querySelector('#beverageName').value;

        let originalContent = card.innerHTML;

        card.innerHTML = `
            <div style="position: relative; width: 100%; height: 200px; overflow: hidden;">
                <img src="${imgSrc}" class="position-absolute top-0 start-0 w-100 h-100" style="object-fit: cover;" alt="Image Drink">
            </div>
            <div class="card-body">
                <p class="text-muted">${name}</p>
                <p class="text-muted">Drank onbeschikbaar</p>
                <button type="button" class="btn btn-success" onclick="toggleInactive(this)">
                    <i class="fas fa-power-off"></i>
                </button>
            </div>
        `;
        card.classList.add('inactive');
        card.dataset.originalContent = originalContent;
    } else {
        card.innerHTML = card.dataset.originalContent;
        card.classList.remove('inactive');
        delete card.dataset.originalContent;
    }
}