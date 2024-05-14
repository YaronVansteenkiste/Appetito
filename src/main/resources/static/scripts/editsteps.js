function addStep() {
    const table = document.querySelector("table");

    const row = document.createElement("tr");
    row.dataset.id = table.rows.length;

    const descriptionCell = document.createElement("td");
    const descriptionInput = document.createElement("input");
    descriptionInput.type = "text";
    descriptionInput.name = "steps[" + table.rows.length + "].description";
    descriptionCell.appendChild(descriptionInput);

    const deleteCell = document.createElement("td");
    const deleteButton = document.createElement("button");
    deleteButton.type = "button";
    deleteButton.textContent = "Delete";
    deleteButton.onclick = function() {
        deleteStep(row.dataset.id);
    };
    deleteCell.appendChild(deleteButton);

    row.appendChild(descriptionCell);
    row.appendChild(deleteCell);

    table.appendChild(row);
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