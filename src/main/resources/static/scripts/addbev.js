function addBev() {
    let textContainer = document.getElementById("drinkTextContainer");
    let imageContainer = document.getElementById("drinkImageContainer");

    let textInput = document.createElement("input");
    textInput.className = "form-control mb-3";
    textInput.setAttribute("type", "text");
    textInput.setAttribute("name", "beverageNames[]");

    let imageInput = document.createElement("input");
    imageInput.className = "form-control mb-3";
    imageInput.setAttribute("type", "file");
    imageInput.setAttribute("accept", "image/*");
    imageInput.setAttribute("name", "beverageImages[]");

    textContainer.appendChild(textInput);
    imageContainer.appendChild(imageInput);
}


function addDrink() {
    let cardContainer = document.getElementById("cardContainer").getElementsByClassName("row justify-content-center")[0];

    let card = document.createElement("div");
    card.className = "col-lg-4 text-center mt-3";

    card.innerHTML = `
        <article class="card">
            <div style="position: relative; width: 100%; height: 200px; overflow: hidden;">
                <img src="" class="position-absolute top-0 start-0 w-100 h-100"
                     style="object-fit: cover;" alt="Image Drink">
            </div>
            <div class="card-body">
                <div class="mb-3">
                    <label for="beverageName" class="form-label">Beverage Name</label>
                    <input type="text" class="form-control" name="name" placeholder="Enter beverage name">
                </div>
                <div class="mb-3">
                    <label for="beverageImage" class="form-label">Beverage Image</label>
                    <input type="file" class="form-control" name="imageFiles" accept="image/*">
                </div>
            </div>
            <div class="card-footer">
                <button type="button" class="btn btn-danger" onclick="toggleInactive(this)">
                    <i class="fas fa-trash"></i>
                </button>
            </div>
        </article>
    `;
    cardContainer.appendChild(card);
}


