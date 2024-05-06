function increaseCounter(id) {
    const counter = document.getElementById("counter" + id);
    counter.textContent = parseInt(counter.textContent) + 1;
    calculateTotal(id);
    calculateTotalPrice();
    calculateTotalGroceries();

}

function decreaseCounter(id) {
    const counter = document.getElementById("counter" + id);
    const currentCount = parseInt(counter.textContent);
    if (currentCount > 0) {
        counter.textContent = currentCount - 1;
    }
    calculateTotal(id);
    calculateTotalPrice();
    calculateTotalGroceries();

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
    calculateTotalPrice();
    calculateTotalGroceries();


}

const ingredients = document.getElementsByClassName("ingredient");

arrIngredients = Array.from(ingredients);

const addedIngredients = new Set();


arrIngredients.forEach((ingredient, index) => {
    ingredient.onclick = function () {

        if (addedIngredients.has(index)) {
            const alert = document.getElementById("alert");
            alert.classList.remove("d-none");
            setTimeout(function () {
                alert.classList.add("d-none");
            }, 2000);
            return;
        }

        addedIngredients.add(index);

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
        total.classList.add("total");
        totalCol.appendChild(total);
        newIngredient.appendChild(totalCol);

        ingredientList.appendChild(newIngredient);

        const removeButton = document.createElement("button");
        removeButton.className = "btn rounded-circle w-25";
        removeButton.type = "button";
        removeButton.textContent = "X";
        removeButton.onclick = function () {
            newIngredient.remove();
            calculateTotalPrice();
            calculateTotalGroceries();
        }

        newIngredient.appendChild(removeButton);

        calculateTotalPrice();
        calculateTotalGroceries();


    }

})

const articlePrice = document.getElementById("articlePrice");
const articleTip = document.getElementById("articleTip");

articlePrice.onmouseover = function () {
    articleTip.classList.remove("d-none");
    articleTip.classList.add("d-block");
    articlePrice.classList.add("text-primary");
}

articleTip.onmouseleave = function () {
    articleTip.classList.remove("d-block");
    articleTip.classList.add("d-none");
    articlePrice.classList.remove("text-primary");
}


function calculateTotalPrice() {
    let totalPrice = 0;
    document.querySelectorAll('.total').forEach((ingredient) => {
        totalPrice += parseFloat(ingredient.innerText.replace('€', ''));
    });

    document.getElementById('totalPrice').textContent = totalPrice;
}

calculateTotalPrice();

function calculateTotalGroceries() {
    let totalGroceries = 0;
    document.querySelectorAll('.counter').forEach((ingredient) => {
        totalGroceries += parseFloat(ingredient.innerText.replace('€', ''));
    });

    document.getElementById('totalGroceries').textContent = totalGroceries;
}

calculateTotalGroceries();
