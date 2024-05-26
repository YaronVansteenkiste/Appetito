const searchForm = document.getElementById('search');
const keywordInput = document.getElementById('keyword');
const keywordButtonsEl = document.getElementById('keywordButtons');

keywordInput.addEventListener('keyup', function(event) {

    if (keywordInput.value.startsWith(' ') || keywordInput.value.startsWith(',') || keywordInput.value.startsWith('-') || keywordInput.value.startsWith('+')) {
        keywordInput.value = '';
    }

    const lastChar = keywordInput.value.slice(-1);
    const trimmedValue = keywordInput.value.slice(0, -1).trim();


    if ((lastChar === ' ' || lastChar === ',' || lastChar === '-' || lastChar === '+') && trimmedValue !== '' && /^[a-zA-Z]+$/.test(trimmedValue)) {
        const tag = document.createElement('span');
        tag.textContent = trimmedValue + " ";
        tag.className = 'tag btn btn-primary mx-1';
        keywordButtonsEl.appendChild(tag);
        keywordInput.value = '';

        tag.addEventListener('click', function() {
            keywordButtonsEl.removeChild(tag);
        });
    }
})

searchForm.addEventListener('submit', function(event) {
    event.preventDefault();
    const tags = Array.from(keywordButtonsEl.getElementsByClassName('tag'));
    const keywords = tags.map(tag => tag.textContent.trim());
    if (keywordInput.value.trim() !== '' && /^[a-zA-Z]+$/.test(keywordInput.value.trim())) {
        keywords.push(keywordInput.value.trim());
    }
    const keywordParam = keywords.join(',');
    window.location.href = `/dishes/search?keyword=${keywordParam}`;
});