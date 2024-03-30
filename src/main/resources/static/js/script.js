const url = "http://localhost:8080/anamneseadulto"

function listar() {
    fetch(url)
    .then(response => response.json())
    .then(data => {
        data.forEach(element => {
            
        });
    })
}