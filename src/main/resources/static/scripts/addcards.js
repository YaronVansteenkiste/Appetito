document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("addCardButton").addEventListener("click", createCard);
});

function createCard() {
    const cardContainer = document.getElementById("cardContainer");

    const newCard = document.createElement("div");
    newCard.className = "col-lg-4 text-center mt-3";
    newCard.innerHTML = `
        <article class="card">
            <div style="position: relative; width: 100%; height: 200px; overflow: hidden;">
                <img src="" class="position-absolute top-0 start-0 w-100 h-100" style="object-fit: cover;" alt="Image Drink">
            </div>
            <div class="card-body">
                <form method="post" action="/modify/editbeverage/" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="beverageName" class="form-label">Beverage Name</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="mb-3">
                        <label for="beverageImage" class="form-label">Beverage Image</label>
                        <input type="file" class="form-control" name="image">
                    </div>
                    <button type="submit" class="btn btn-outline-dark">Save</button>
                    <button type="button" class="btn btn-outline-danger remove-button">Remove</button>
                </form>
            </div>
        </article>
    `;

    cardContainer.appendChild(newCard);
}