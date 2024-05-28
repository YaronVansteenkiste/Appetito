document.getElementById('categorySelect').addEventListener('change', function() {
    if (this.value === 'Andere') {
        document.getElementById('newCategoryInput').style.display = 'block';
    } else {
        document.getElementById('newCategoryInput').style.display = 'none';
    }
});