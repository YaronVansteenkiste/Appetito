function addTechnique() {
    const table = document.querySelector("table");

    const row = document.createElement("tr");
    const tableBody = document.createElement("tbody");
    row.dataset.id = table.rows.length;

    const descriptionCell = document.createElement("td");

    const hiddenInput = document.createElement("input");
    hiddenInput.type = "hidden";
    hiddenInput.name = "techniques[" + table.rows.length + "].id";
    descriptionCell.appendChild(hiddenInput);

    const nameInput = document.createElement("input");
    nameInput.type = "text";
    nameInput.className = "form-control";
    nameInput.name = "techniques[" + table.rows.length + "].name";
    descriptionCell.appendChild(nameInput);

    const descriptionInput = document.createElement("input");
    descriptionInput.type = "text";
    descriptionInput.className = "form-control";
    descriptionInput.name = "techniques[" + table.rows.length + "].techniqueDescription";
    descriptionCell.appendChild(descriptionInput);

    const imageInput = document.createElement("input");
    imageInput.type = "file";
    imageInput.className = "techniqueImageInput form-control";
    imageInput.name = "techniques[" + table.rows.length + "].imageFile";
    descriptionCell.appendChild(imageInput);

    const imagePreview = document.createElement("img");
    imagePreview.className = "techniqueImagePreview img-fluid w-25";
    descriptionCell.appendChild(imagePreview);

    const deleteCell = document.createElement("td");
    const deleteButton = document.createElement("button");
    deleteButton.type = "button";
    deleteButton.className = "btn btn-outline-danger";
    deleteButton.textContent = "Delete";
    deleteButton.addEventListener('click', function() {
        row.remove();
    });
    deleteCell.appendChild(deleteButton);

    row.appendChild(descriptionCell);
    row.appendChild(deleteCell);

    tableBody.appendChild(row)

    table.appendChild(tableBody);

    imageInput.addEventListener('change', function(e) {
        const file = e.target.files[0];
        if (file) {
            const url = URL.createObjectURL(file);
            imagePreview.src = url;
        }
    });
}

function deleteTechnique(id) {
    const rowEl = document.getElementById('technique'+id);
    if (rowEl) {
        fetch('/modify/technique/' + id, {
            method: 'DELETE',

        }).then((response) => {
            if (response.ok) {
                rowEl.remove();
            } else {
                alert('Failed to delete step');
            }
        });
    }
}

document.querySelectorAll('.techniqueImageInput').forEach(function(inputElement) {
    inputElement.addEventListener('change', function(e) {
        const file = e.target.files[0];
        if (file) {
            const url = URL.createObjectURL(file);
            const imgElement = e.target.parentElement.querySelector('.stepImagePreview');
            if (imgElement) {
                imgElement.src = url;
            }
        }
    });
});