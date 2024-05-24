function sendPostRequest(id, active) {

    fetch('/admin/toggle/dish/' + id, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            // [csrfHeader]: csrfToken
        },
        body: 'active=' + active
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        location.reload();
    })
    .catch(error => {
        console.error('There has been a problem with your fetch operation:', error);
    });
}