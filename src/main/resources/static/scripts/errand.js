function increaseCounter(id) {
    const counter = document.getElementById("counter" + id);
    counter.textContent = parseInt(counter.textContent) + 1;
}

function decreaseCounter(id) {
    const counter = document.getElementById("counter" + id);
    const currentCount = parseInt(counter.textContent);
    if (currentCount > 0) {
        counter.textContent = currentCount - 1;
    }
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

arrIngredients.forEach(ingredient => {
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
        price.textContent = "€ 1,50";
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
        const counter = document.createElement("p");
        counter.className = "counter mx-2";
        counter.textContent = "1";
        const decreaseButton = document.createElement("button");
        decreaseButton.className = "btn btn-outline-primary rounded-circle ms-2";
        decreaseButton.type = "button";
        decreaseButton.textContent = "-";
        counterDiv.appendChild(increaseButton);
        counterDiv.appendChild(counter);
        counterDiv.appendChild(decreaseButton);
        counterRow.appendChild(counterDiv);
        counterCol.appendChild(counterRow);
        newIngredient.appendChild(counterCol);

        const totalCol = document.createElement("div");
        totalCol.className = "col";
        const total = document.createElement("h6");
        total.innerHTML = "<b>Totaal</b>";
        totalCol.appendChild(total);
        newIngredient.appendChild(totalCol);

        ingredientList.appendChild(newIngredient);
    }
})