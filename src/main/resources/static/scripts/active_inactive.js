function toggleInactive(button) {
    let card = button.closest('.card');
    let isActive = !card.classList.contains('inactive');
    if (isActive) {
        card.innerHTML = '<div class="card-body"><p class="text-muted">Het drank is onbeschikbaar</p></div>';
    }
}