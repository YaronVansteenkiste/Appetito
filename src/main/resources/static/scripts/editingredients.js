document.addEventListener('DOMContentLoaded', function() {
    window.addIngredient = function() {
        const container = document.getElementById('ingredientsContainer');
        const index = container.querySelectorAll('.ingredient-row').length;

        const ingredientRow = document.createElement('div');
        ingredientRow.className = 'ingredient-row';

        ingredientRow.innerHTML = `
            <div class="row mb-3 m-2">
                <input type="hidden" name="ingredients[${index}].id" value=""/>
                <div class="col-sm-3">
                    <label class="col-form-label">Naam</label>
                    <input class="form-control" type="text" name="ingredients[${index}].name"/>
                </div>
                <div class="col-sm-3">
                    <label class="col-form-label">Hoeveelheid</label>
                    <input class="form-control" type="number" name="ingredients[${index}].quantity"/>
                </div>
                <div class="col-sm-3">
                    <label class="col-form-label">Eenheid</label>
                    <input class="form-control" type="text" name="ingredients[${index}].unit"/>
                </div>
                <div class="col-sm-3 d-flex align-items-end">
                    <button type="button" class="btn btn-danger" onclick="deleteIngredient(this)">Verwijder</button>
                </div>
            </div>
        `;

        container.appendChild(ingredientRow);
    };

    window.deleteIngredient = function(button) {
        const row = button.closest('.ingredient-row');
        row.parentNode.removeChild(row);
    };
});
