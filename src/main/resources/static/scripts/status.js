document.addEventListener("DOMContentLoaded", function (){
    const status = document.getElementById("status");
    const toggleButton = document.getElementById("toggle-button");

    toggleButton.addEventListener("click",function (){
        if (status.textContent === "Niet Actief"){
            status.textContent = "Actief";
            status.style.color = "green"
        }
        else {
            status.textContent = "Niet Actief";
            status.style.color = "red";
        }
    });
});