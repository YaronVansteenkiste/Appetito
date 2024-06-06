document.getElementById('groceryForm').addEventListener('submit', function(e) {
    const persons = document.getElementById('persons').innerText;
    const dishId = this.getAttribute('th:data');
    this.action = this.action + '?persons=' + persons;
});