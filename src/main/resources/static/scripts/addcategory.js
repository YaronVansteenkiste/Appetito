document.getElementById('categorySelect').addEventListener('change', function() {
    let newCategoryInput = document.getElementById('newCategoryInput');
    let newCategoryLabel = document.querySelector('label[for="newCategoryInput"]');

    if (this.value === 'Andere') {
        newCategoryInput.style.display = 'block';
        newCategoryLabel.style.display = 'block';
        newCategoryInput.required = true;
    } else {
        newCategoryInput.style.display = 'none';
        newCategoryLabel.style.display = 'none';
        newCategoryInput.required = false;
    }

});






