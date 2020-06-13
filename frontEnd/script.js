// Linha necessária para o sidebar...
//var height = $('#content').height()
//$('#sidebar').height(height)​


// função para validar o login
async function validarLogin() {

    console.log("Entrei na funcao!");
    const racf = document.getElementById("email_login").value;
    const senha = document.getElementById("senha_login").value;

    const options = {
        method: "GET"
    }

    //const url = "https://swapi.dev/api/people/" + id + "/";
    const url = `http://localhost:8080/index/validaColaborador?racf=${racf}&senha=${senha}`;
    //http://localhost:8080/pessoas/1

    const response = await fetch(url, options);
    const text = await response.text();
    if (response.status == 200 && text === "true") {
        window.location.replace("http://127.0.0.1:5500/frontEnd/html/inicio.html");
    } else {
        document.getElementById("login_erro").innerHTML = "Usuário não encontrado!";
        
    }

    console.log("final da funçao");

}