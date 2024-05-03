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