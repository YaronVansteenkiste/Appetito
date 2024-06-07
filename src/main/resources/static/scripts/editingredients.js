function validateForm() {
    const ingredients = document.getElementsByClassName('ingredient-row');
    for (let i = 0; i < ingredients.length; i++) {
        const name = ingredients[i].querySelector('input[type="text"]');
        const quantity = ingredients[i].querySelector('input[type="number"]');
        const unit = ingredients[i].querySelector('input[type="text"]');
        if (name.value == '' || quantity.value == '' || unit.value == '') {
            quantity.value = '0.0';
            return false;
        }
    }
    return true;
}

function addIngredient() {
    const container = document.querySelector('.container-fluid');
    const index = container.children.length;

    const ingredientRow = document.createElement('div');
    ingredientRow.className = 'ingredient-row mb-3';

    ingredientRow.innerHTML = `
    <div class="row mb-3 m-2">
        <input type="hidden" name="ingredients[${index}].id" value=""/>
        <div class="col-sm-3">
            <label class="col-form-label">Naam</label>
            <input class="form-control" type="text" name="ingredients[${index}].name"/>
        </div>
        <div class="col-sm-2">
            <label class="col-form-label">Hoeveelheid</label>
            <input class="form-control" type="number" name="ingredients[${index}].quantity" value="0.0"/>
        </div>
        <div class="col-sm-3">
            <label class="col-form-label">Eenheid (gr, ml,...)</label>
            <input class="form-control" type="text" name="ingredients[${index}].unit" />
        </div>
        <div class="col-sm-3">
            <label class="form-label">Foto</label>
            <input class="form-control" type="file" accept="image/*" name="imageFiles">
        </div>
        <div class="col-sm-3 m-1">
            <button type="button" class="btn btn-danger" onclick="deleteIngredient(this)">Verwijder</button>
        </div>
    </div>
    `;

    container.appendChild(ingredientRow);
}

function deleteIngredient(button) {
    const row = button.closest('.ingredient-row');
    row.parentNode.removeChild(row);
}

function deleteIngredientDb(button, ingredientId) {
    fetch(`/modify/editingredients/delete/${ingredientId}`, {
        method: 'DELETE',
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const row = button.closest('.ingredient-row');
            row.remove();
            window.location.reload();
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
}


