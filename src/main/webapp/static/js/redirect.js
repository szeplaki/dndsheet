const select = document.getElementById('class');
const submitButton = document.getElementById('submit');
document.getElementById('class').addEventListener('change', () => {
    if (select.value === '0') {
        submitButton.disabled = true;
    } else {
        submitButton.disabled = false;
    }
});