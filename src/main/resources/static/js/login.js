document
    .getElementById("loginForm")
    .addEventListener("submit", async function(event) {

        event.preventDefault();

        const nome = document.getElementById("nome").value;
        const senha = document.getElementById("senha").value;

        const mensagem = document.getElementById("mensagem");

        try {

            const response = await fetch(
                //LINK DA API.
                    "http://localhost:8080/usuarios/login",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        nome: nome,
                        senha: senha
                    })
                }
            );

            const texto = await response.text();

            if (response.ok) {

                mensagem.style.color = "green";
                mensagem.innerHTML = texto;

                // Exemplo de redirecionamento
                // window.location.href = "home.html";

            } else {

                mensagem.style.color = "red";
                mensagem.innerHTML = texto;
            }

        } catch (error) {

            mensagem.style.color = "red";
            mensagem.innerHTML = "Erro ao conectar com o servidor.";

            console.error(error);
        }
    });