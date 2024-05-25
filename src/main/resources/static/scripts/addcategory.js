document.addEventListener('DOMContentLoaded', function() {
    let selectField = document.getElementById('dietPreferencesSelect');
    let otherField = document.getElementById('otherField');

    let storedValue = "your_stored_value";

    for (let i = 0; i < selectField.options.length; i++) {
        if (selectField.options[i].value === storedValue) {
            selectField.selectedIndex = i;
            break;
        }
    }

    selectField.addEventListener('change', function() {
        otherField.disabled = this.value !== 'Andere';
    });
});


