function addStep() {
    const table = document.querySelector("table");

    const row = document.createElement("tr");
    const tableBody = document.createElement("tbody");
    row.dataset.id = table.rows.length;

    const descriptionCell = document.createElement("td");

    const hiddenInput = document.createElement("input");
    hiddenInput.type = "hidden";
    hiddenInput.name = "steps[" + table.rows.length + "].id";
    descriptionCell.appendChild(hiddenInput);

    const descriptionInput = document.createElement("input");
    descriptionInput.type = "text";
    descriptionInput.className = "form-control";
    descriptionInput.name = "steps[" + table.rows.length + "].description";
    descriptionCell.appendChild(descriptionInput);

    const imageInput = document.createElement("input");
    imageInput.type = "file";
    imageInput.className = "stepImageInput form-control";
    imageInput.name = "steps[" + table.rows.length + "].imageFile";
    descriptionCell.appendChild(imageInput);

    const imagePreview = document.createElement("img");
    imagePreview.className = "stepImagePreview img-fluid w-25";
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


function deleteStep(id) {
    const rowEl = document.getElementById('step'+id);
    if (rowEl) {
        fetch('/modify/step/' + id, {
            method: 'DELETE',
            headers: {
                'X-CSRF-TOKEN': document.querySelector('meta[name="_csrf"]').getAttribute('content')
            }
        }).then((response) => {
            if (response.ok) {
                rowEl.remove();
            } else {
                alert('Failed to delete step');
            }
        });
    }
}

document.querySelectorAll('.stepImageInput').forEach(function(inputElement) {
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