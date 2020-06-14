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
        window.location.replace("http://127.0.0.1:5500/frontEnd/html/profile.html");
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
                    document.getElementById("nome").innerHTML = json.nome;
                    document.getElementById("racf").innerHTML = json.racf;
                    document.getElementById("setor").innerHTML = json.departamento.departamento;
                    setCookie("depto", json.departamento.departamento, 1);
                    document.getElementById("func").innerHTML = json.funcional;
                })
                .catch(function (err) {
                    console.error(err);
                })

        }
    })
    .catch(function (error) {
        console.error(error)
    })
  
    dadosSolicitacao();
}

function dadosSolicitacao() { 
    let table = document.getElementById("tabelaSolicitacao");
    const racf = getCookie("racf");
    const url = `http://localhost:8080//inicio/solicitacao${racf}`;

    const options = {
        method: "GET"
    }

    fetch(url, options)
    .then(function (response) {
        if (response.status == 200) {

            response.json()
                .then(function (json) {
                    console.log(json);
                    for (var obj = 0; obj < json.length; obj++) {
                        let linha = table.insertRow(-1);
                        console.log(json[obj]);
                        linha.insertCell(0).innerHTML = json[obj].data;
                        linha.insertCell(1).innerHTML = json[obj].justificativa;
                        linha.insertCell(2).innerHTML = json[obj].comando;
                        linha.insertCell(3).innerHTML = "De: "+json[obj].antigoDepartamento.departamento+"; Para: "+json[obj].novoDepartamento.departamento+";" ;
                    }
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


// input de solicitacao
function novaSolicitacao() {

    const racf = getCookie("racf");
    const antigoDepartamento = getCookie("depto");
    const novoDepartamentoId = document.getElementById("departamentos").value;
    const justif = document.getElementById("justificativa").value;
    
    let currentTime = new Date();
    let dd = String(currentTime.getDate()).padStart(2,'0');
    let mm = String(currentTime.getMonth() + 1).padStart(2, '0');
    let yyyy = currentTime.getFullYear();

    let data = dd+'-'+mm+'-'+yyyy;

    const url = `http://localhost:8080//novasolicitacao`;

    const options = {
        method: "POST",
        headers: {'Content-Type':'application/json'},
        body: JSON.stringify({colaboradorRacf: racf,
                            novoDepartamentoId: novoDepartamentoId,
                            antigoDepartamento: antigoDepartamento,
                            justificativa: justif,
                            comando: "",
                            data: data})
    }
    

    fetch(url, options)
    .then(function () {
        alert("Solicitação enviada com sucesso");
    })
    .catch(function (error) {
        alert("Erro ao enviar solicitacao.")
        console.error(error);
    })

}




// Cookies ~
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