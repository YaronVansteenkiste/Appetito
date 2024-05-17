document.querySelectorAll('#ratingForm input[type="radio"]').forEach(function(radio) {
    radio.addEventListener('click', function() {
        document.getElementById('ratingForm').submit();
    });
});