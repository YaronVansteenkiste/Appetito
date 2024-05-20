function toggleInactive(button) {
    let card = button.closest('.card');
    let isActive = !card.classList.contains('inactive');
    if (isActive) {
        let originalContent = card.innerHTML;

        card.innerHTML = '<div class="card-body"><p class="text-muted">This drink is inactive</p><button type="button" class="btn btn-success" onclick="toggleInactive(this)">Reactivate</button></div>';
        card.classList.add('inactive');

        card.dataset.originalContent = originalContent;
    } else {

        card.innerHTML = card.dataset.originalContent;
        card.classList.remove('inactive');

        delete card.dataset.originalContent;
    }
}