document.getElementById('dishForm').addEventListener('submit', function(e) {
    const prepTimeInput = document.getElementById('prepTime');
    const prepTime = prepTimeInput.value;
    alert(prepTime.split(':').length);
    if (prepTime.split(':').length === 2) {
        prepTimeInput.value = prepTime + ':00';
    }
});