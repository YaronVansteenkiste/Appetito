document.addEventListener('DOMContentLoaded', function() {
    let selectField = document.getElementById('dietPreferencesSelect');
    let otherField = document.getElementById('otherField');

    selectField.addEventListener('change', function() {
        otherField.disabled = this.value !== 'Andere';
    });
});

