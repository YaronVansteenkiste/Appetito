document.getElementById('categorySelect').addEventListener('change', function() {
    let newCategoryInput = document.getElementById('newCategoryInput');
    if (this.value === 'Andere') {
        newCategoryInput.style.display = 'block';
        newCategoryInput.required = true;
    } else {
        newCategoryInput.style.display = 'none';
        newCategoryInput.required = false;
    }
});


document.getElementById('categorySelect').addEventListener('submit', function(event) {
    let newCategory = document.getElementById('newCategoryInput').value;
    let existingCategories = Array.from(document.getElementById('categorySelect').options).map(option => option.value);

    if (existingCategories.includes(newCategory)) {
        alert('This category already exists.');
        event.preventDefault();
    }
});
