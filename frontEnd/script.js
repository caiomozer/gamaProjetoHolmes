// Linha necessária para o sidebar...
//var height = $('#content').height()
//$('#sidebar').height(height)​


// função para validar o login
async function validarLogin() {

    const racf = document.getElementById("email_login").value;
    const senha = document.getElementById("senha_login").value;

    setCookie("racf", racf, 1);

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

}

// funcao para trazer dados do colaborador..
function dadosColaborador() {
    const racf = getCookie("racf");
    const url = `http://localhost:8080//inicio/${racf}`;
    
    const options = {
        method: "GET"
    }

    fetch(url, options)
    .then(function (response) {
        if (response.status == 200) {

            response.json()
                .then(function (json) {
                    document.getElementById("nome").innerHTML = "Colaborador: " + json.nome;
                    document.getElementById("racf").innerHTML = "RACF: " +json.racf;
                    document.getElementById("departamento").innerHTML = "Departamento: " +json.departamento.departamento;
                    document.getElementById("email").innerHTML = "email: " +json.email;
                })
                .catch(function (err) {
                    console.error(err)
                })

        }
    })
    .catch(function (error) {
        console.error(error)
    })
  

}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }

  function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }