function addIngredient() {
    const container = document.getElementById('ingredientsContainer');
    const index = container.children.length;

    const ingredientRow = document.createElement('div');
    ingredientRow.className = 'ingredient-row';

    ingredientRow.innerHTML = `
    <div class="row mb-3 m-2">
        <input type="hidden" name="ingredients[${index}].id" value=""/>
        <div class="col-sm-3">
            <label class="col-form-label">Name</label>
            <input class="form-control" type="text" name="ingredients[${index}].name"/>
        </div>
        <div class="col-sm-3">
            <label class="col-form-label">Quantity</label>
            <input class="form-control" type="number" name="ingredients[${index}].quantity"/>
        </div>
        <div class="col-sm-3">
            <label class="col-form-label">Unit</label>
            <input class="form-control" type="text" name="ingredients[${index}].unit"/>
        </div>
        <div class="col-sm-3">
            <button type="button" class="btn btn-danger" onclick="deleteIngredient(this)">Delete</button>
        </div>
    </div>
    `;

    container.appendChild(ingredientRow);
}

function deleteIngredient(button) {
    const row = button.closest('.ingredient-row');
    row.parentNode.removeChild(row);
}