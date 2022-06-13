
let btn = document.getElementById('b1');

function loadProducts() {
    fetch('http://localhost:8080/api/products')
        .then(response => response.json())
        .then(products => {
            console.log(products);
        })
}


btn.addEventListener('click', function () {
    loadProducts();
})