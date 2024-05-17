function addBev() {
    var container = document.getElementById("drinkContainer");

    var div = document.createElement("div");
    div.className = "row mb-3";

    var labelCol = document.createElement("label");
    labelCol.className = "col-sm-4 col-form-label";
    labelCol.textContent = "Beverage Name";

    var inputCol1 = document.createElement("div");
    inputCol1.className = "col-sm-4";
    var input1 = document.createElement("input");
    input1.className = "form-control";
    input1.setAttribute("type", "text");
    input1.setAttribute("name", "beverages");

    var inputCol2 = document.createElement("div");
    inputCol2.className = "col-sm-4";
    var input2 = document.createElement("input");
    input2.className = "form-control";
    input2.setAttribute("type", "file");
    input2.setAttribute("accept", "image/*");
    input2.setAttribute("name", "beverageImages");

    inputCol1.appendChild(input1);
    inputCol2.appendChild(input2);

    div.appendChild(labelCol);
    div.appendChild(inputCol1);
    div.appendChild(inputCol2);

    container.appendChild(div);
}
