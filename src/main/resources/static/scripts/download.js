document.getElementById("downloadGroceryList").addEventListener("click", function() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/groceries", true);
    xhr.responseType = "blob"; // Set response type to Blob (binary data)

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            let blob = new Blob([xhr.response], { type: "application/pdf" });
            let url = window.URL.createObjectURL(blob);

            // Create a temporary link element
            let a = document.createElement("a");
            a.href = url;
            a.download = "groceries.pdf"; // Set the filename
            document.body.appendChild(a);

            // Trigger the download
            a.click();

            // Clean up
            window.URL.revokeObjectURL(url);
            document.body.removeChild(a);
        }
    };

    xhr.send();
})