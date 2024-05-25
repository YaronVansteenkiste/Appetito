document.addEventListener('DOMContentLoaded', function() {
    let selectField = document.getElementById('dietPreferencesSelect');
    let otherField = document.getElementById('otherField');

    // Assuming you have the value from the database in a variable named `storedValue`
    let storedValue = "your_stored_value";

    // Iterate over the options and set the selected one
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


