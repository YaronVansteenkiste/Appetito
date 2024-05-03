function increaseCounter(id) {
    const counter = document.getElementById("counter" + id);
    counter.textContent = parseInt(counter.textContent) + 1;
    calculateTotal(id);
}

function decreaseCounter(id) {
    const counter = document.getElementById("counter" + id);
    const currentCount = parseInt(counter.textContent);
    if (currentCount > 0) {
        counter.textContent = currentCount - 1;
    }
    calculateTotal(id);
}

function calculateTotal(id) {
    const counter = document.getElementById("counter" + id);
    const priceElement = document.getElementById("price" + id);
    const totalElement = document.getElementById("total" + id)

    const quantity = parseInt(counter.innerText);
    const price = parseFloat(priceElement.innerText.replace('€ ', ''));

    const total = quantity * price;

    totalElement.innerHTML = "<strong>" + "€ " + total.toFixed(2) + "</strong>";
}


function addErrand() {
    const errand = document.getElementById("errand").value;
    const errandList = document.getElementById("errandList");
    const newErrand = document.createElement("li");
    newErrand.textContent = errand;
    errandList.appendChild(newErrand);
}

const ingredients = document.getElementsByClassName("ingredient");

arrIngredients = Array.from(ingredients);

arrIngredients.forEach((ingredient, index) => {
    ingredient.onclick = function () {
        const ingredientList = document.getElementById("ingredientList");
        const newIngredient = document.createElement("div");
        newIngredient.className = "row mt-2";

        const nameCol = document.createElement("div");
        nameCol.className = "col mx-2";
        const name = document.createElement("h6");
        name.textContent = ingredient.textContent;
        nameCol.appendChild(name);
        newIngredient.appendChild(nameCol);

        const priceCol = document.createElement("div");
        priceCol.className = "col";
        const price = document.createElement("h6");
        price.id = "price" + (index + 1);
        price.textContent = "€ " + (index + 1).toFixed(2);
        priceCol.appendChild(price);
        newIngredient.appendChild(priceCol);

        const counterCol = document.createElement("div");
        counterCol.className = "col";
        const counterRow = document.createElement("div");
        counterRow.className = "row";
        const counterDiv = document.createElement("div");
        counterDiv.className = "col-md-1 d-flex justify-content-between align-items-center";
        const increaseButton = document.createElement("button");
        increaseButton.className = "btn btn-outline-primary rounded-circle ms-2";
        increaseButton.type = "button";
        increaseButton.textContent = "+";
        increaseButton.onclick = function () {
            increaseCounter(index + 1);
        }
        const counter = document.createElement("p");
        counter.id = "counter" + (index + 1);
        counter.className = "counter mx-2";
        counter.textContent = "1";
        const decreaseButton = document.createElement("button");
        decreaseButton.className = "btn btn-outline-primary rounded-circle ms-2";
        decreaseButton.type = "button";
        decreaseButton.textContent = "-";
        decreaseButton.onclick = function () {
            decreaseCounter(index + 1);
        }
        counterDiv.appendChild(increaseButton);
        counterDiv.appendChild(counter);
        counterDiv.appendChild(decreaseButton);
        counterRow.appendChild(counterDiv);
        counterCol.appendChild(counterRow);
        newIngredient.appendChild(counterCol);

        const totalCol = document.createElement("div");
        totalCol.className = "col";
        const total = document.createElement("h6");
        total.id = "total" + (index + 1);
        total.innerHTML = '<strong>&euro;' + ((index + 1)).toFixed(2) + '</strong>';
        totalCol.appendChild(total);
        newIngredient.appendChild(totalCol);

        ingredientList.appendChild(newIngredient);
    }
})