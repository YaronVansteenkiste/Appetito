const form = document.getElementById("removeForm");

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const action = form.getAttribute('action');
    const [dishId, beverageId] = action.match(/\d+/g); // Extract numerical values from the URL

    const response = await fetch(action, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ dishId, beverageId })
    });

    if (response.ok) {
        const beverageCard = form.closest('.card');
        beverageCard.parentNode.removeChild(beverageCard);
    } else {
        console.error('Error removing beverage');
    }
});
