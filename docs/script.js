// NAVEGAÇÃO ENTRE AS PÁGINAS

function abrirPagina(pagina) {

    console.log("Abrindo:", pagina);

    switch (pagina) {

        case "especies":
            window.location.href = "especies.html";
            break;

        case "trafego":
            window.location.href = "trafego.html";
            break;

        case "revistas":
            window.location.href = "revistas.html";
            break;

        case "cursos":
            window.location.href = "cursos.html";
            break;

        case "cursosRelacionados":
            window.location.href = "cursos-relacionados.html";
            break;

        case "instituicoes":
            window.location.href = "instituicoes.html";
            break;

        default:
            alert("Página não encontrada.");
    }
}


// ESPÉCIES MARINHAS

let filtroEspecieAtual = "todas";


function filtrarEspecies(categoria) {

    filtroEspecieAtual = categoria;

    atualizarEspecies();
}


function atualizarEspecies() {

    const campoPesquisa =
        document.getElementById("pesquisaEspecie");

    const especies =
        document.querySelectorAll(".especie");

    const contador =
        document.getElementById("contadorEspecies");


    if (!campoPesquisa || !contador) {
        return;
    }


    const pesquisa =
        campoPesquisa.value
            .toLowerCase()
            .trim();


    let encontrados = 0;


    especies.forEach(function (especie) {

        const texto =
            especie.innerText.toLowerCase();

        const categoria =
            especie.dataset.categoria;


        const correspondePesquisa =
            texto.includes(pesquisa);


        const correspondeCategoria =
            filtroEspecieAtual === "todas" ||
            categoria === filtroEspecieAtual;


        if (
            correspondePesquisa &&
            correspondeCategoria
        ) {

            especie.classList.remove("oculta");

            encontrados++;

        } else {

            especie.classList.add("oculta");
        }

    });


    contador.textContent =
        encontrados + " espécie(s) encontrada(s)";
}


// PESQUISA AUTOMÁTICA - ESPÉCIES

document.addEventListener(
    "DOMContentLoaded",
    function () {

        const campoPesquisa =
            document.getElementById("pesquisaEspecie");


        if (campoPesquisa) {

            campoPesquisa.addEventListener(
                "input",
                atualizarEspecies
            );

            atualizarEspecies();
        }

    }
);


// MENU PRINCIPAL - OCEANO HUB

document.addEventListener(
    "DOMContentLoaded",
    function () {

        const botaoMenu =
            document.getElementById("botaoMenu");

        const opcoesMenu =
            document.getElementById("opcoesMenu");


        if (botaoMenu && opcoesMenu) {

            botaoMenu.addEventListener(
                "click",
                function () {

                    opcoesMenu.classList.toggle(
                        "aberto"
                    );

                }
            );

        }

    }
);


// PESQUISA WoRMS

function pesquisarWoRMS() {

    const campo =
        document.getElementById("campoWoRMS");

    const mensagem =
        document.getElementById("mensagemWoRMS");


    if (!campo || !mensagem) {
        return;
    }


    const nome =
        campo.value.trim();


    if (nome === "") {

        mensagem.textContent =
            "Digite o nome de uma espécie para pesquisar.";

        return;
    }


    const consulta =
        encodeURIComponent(nome);


    const endereco =
        "https://www.marinespecies.org/aphia.php?p=taxlist&tName="
        + consulta;


    window.open(
        endereco,
        "_blank"
    );


    mensagem.textContent =
        "A pesquisa foi aberta no site oficial do WoRMS.";
}


// ENTER NA PESQUISA WoRMS

document.addEventListener(
    "DOMContentLoaded",
    function () {

        const campo =
            document.getElementById("campoWoRMS");


        if (campo) {

            campo.addEventListener(
                "keydown",
                function (event) {

                    if (event.key === "Enter") {

                        pesquisarWoRMS();

                    }

                }
            );

        }

    }
);


// MARINETRAFFIC

function abrirMarineTraffic() {

    const link =
        "https://www.marinetraffic.com/en/ais/home/centerx:-12.0/centery:25.0/zoom:4";


    window.open(
        link,
        "_blank"
    );
}


// REVISTAS CIENTÍFICAS

let categoriaRevistaAtual = "Todas";


function filtrarRevistas(categoria) {

    categoriaRevistaAtual = categoria;


    const botoes =
        document.querySelectorAll(
            ".revistas-filtros button"
        );


    botoes.forEach(
        function (botao) {

            botao.classList.remove("ativo");


            if (
                botao.textContent.trim()
                === categoria
            ) {

                botao.classList.add("ativo");

            }

        }
    );


    atualizarRevistas();
}


// VERIFICAR CATEGORIA DA REVISTA

function verificarCategoriaRevista(
    revista,
    filtro
) {

    if (filtro === "Todas") {

        return true;
    }


    const categoria =
        revista.categoria.toLowerCase();


    if (filtro === "Brasil") {

        return categoria.includes("brasil");
    }


    if (filtro === "Oceanografia") {

        return (

            categoria.includes("oceanografia") ||

            categoria.includes("oceanos") ||

            categoria.includes("clima")

        );
    }


    if (filtro === "Biologia Marinha") {

        return (

            categoria.includes("biologia") ||

            categoria.includes("ecologia")

        );
    }


    if (filtro === "Oceanografia Física") {

        return categoria.includes(
            "oceanografia física"
        );
    }


    if (filtro === "Pesca") {

        return (

            categoria.includes("pesca") ||

            categoria.includes("aquicultura")

        );
    }


    if (filtro === "Conservação") {

        return (

            categoria.includes("conservação") ||

            categoria.includes("poluição")

        );
    }


    if (filtro === "Geologia Marinha") {

        return categoria.includes(
            "geologia"
        );
    }


    if (filtro === "Engenharia Oceânica") {

        return (

            categoria.includes("engenharia") ||

            categoria.includes("tecnologia")

        );
    }


    return false;
}


// ATUALIZAR REVISTAS

function atualizarRevistas() {

    const area =
        document.getElementById("areaRevistas");

    const pesquisa =
        document.getElementById("pesquisaRevista");

    const contador =
        document.getElementById("contadorRevistas");


    if (!area || !pesquisa || !contador) {
        return;
    }


    area.innerHTML = "";


    const textoPesquisa =
        pesquisa.value
            .toLowerCase()
            .trim();


    const encontradas =
        dadosRevistas.filter(
            function (revista) {

                const nome =
                    revista.nome.toLowerCase();

                const descricao =
                    revista.descricao.toLowerCase();

                const categoria =
                    revista.categoria.toLowerCase();


                const correspondePesquisa =

                    nome.includes(textoPesquisa) ||

                    descricao.includes(textoPesquisa) ||

                    categoria.includes(textoPesquisa);


                const correspondeCategoria =
                    verificarCategoriaRevista(
                        revista,
                        categoriaRevistaAtual
                    );


                return (
                    correspondePesquisa &&
                    correspondeCategoria
                );

            }
        );


    contador.textContent =
        encontradas.length +
        " periódico(s) encontrado(s)";


    if (encontradas.length === 0) {

        const nenhum =
            document.createElement("p");


        nenhum.className =
            "revistas-nenhum";


        nenhum.textContent =
            "Nenhuma revista encontrada.";


        area.appendChild(nenhum);


        return;
    }


    encontradas.forEach(
        function (revista) {

            const card =
                document.createElement("article");


            card.className =
                "revista-card";


            const categoria =
                document.createElement("p");


            categoria.className =
                "revista-categoria";


            categoria.textContent =
                revista.categoria;


            const nome =
                document.createElement("h2");


            nome.className =
                "revista-nome";


            nome.textContent =
                revista.nome;


            const descricao =
                document.createElement("p");


            descricao.className =
                "revista-descricao";


            descricao.textContent =
                revista.descricao;


            const acesso =
                document.createElement("p");


            acesso.className =
                "revista-acesso";


            acesso.textContent =
                revista.acesso;


            const botao =
                document.createElement("button");


            botao.className =
                "revista-botao";


            botao.textContent =
                "Acessar revista";


            botao.addEventListener(
                "click",
                function () {

                    window.open(
                        revista.link,
                        "_blank"
                    );

                }
            );


            card.appendChild(categoria);

            card.appendChild(nome);

            card.appendChild(descricao);

            card.appendChild(acesso);

            card.appendChild(botao);


            area.appendChild(card);

        }
    );
}


// INICIAR TELA DE REVISTAS

document.addEventListener(
    "DOMContentLoaded",
    function () {

        const pesquisa =
            document.getElementById(
                "pesquisaRevista"
            );


        if (!pesquisa) {
            return;
        }


        pesquisa.addEventListener(
            "input",
            atualizarRevistas
        );


        const botoes =
            document.querySelectorAll(
                ".revistas-filtros button"
            );


        botoes.forEach(
            function (botao) {

                if (
                    botao.textContent.trim()
                    === "Todas"
                ) {

                    botao.classList.add(
                        "ativo"
                    );

                }

            }
        );


        atualizarRevistas();

    }
);


// MAPA DO BRASIL - CURSOS DE OCEANOGRAFIA

async function carregarMapaBrasil() {

    const areaMapa =
        document.getElementById("mapaBrasil");


    // Só executa na página cursos.html

    if (!areaMapa) {
        return;
    }


    try {

        // CARREGAR SVG

        const resposta =
            await fetch("mapa-brasil.svg");


        if (!resposta.ok) {

            throw new Error(
                "Não foi possível carregar o mapa."
            );

        }


        const svgTexto =
            await resposta.text();


        areaMapa.innerHTML =
            svgTexto;


        const svg =
            areaMapa.querySelector("svg");


        if (!svg) {
            return;
        }


        // TAMANHO DO MAPA

        svg.style.width =
            "520px";

        svg.style.height =
            "auto";

        svg.style.maxHeight =
            "560px";


        // ESTADOS DO SVG

        const estados =
            svg.querySelectorAll("a[name]");


        estados.forEach(
            function (estado) {


                // NOME DO ESTADO

                const nomeEstadoOriginal =
                    estado.getAttribute("name");


                const nomeEstado =
                    nomeEstadoOriginal
                        .normalize("NFD")
                        .replace(
                            /[\u0300-\u036f]/g,
                            ""
                        )
                        .toLowerCase();

                // COR PADRÃO

                let cor =
                    "#808080";


                // NORTE

                if ([
                    "acre",
                    "amapa",
                    "amazonas",
                    "para",
                    "rondonia",
                    "roraima",
                    "tocantins"
                ].includes(nomeEstado)) {

                    cor =
                        "#00D94A";

                }


                // NORDESTE

                else if ([
                    "alagoas",
                    "bahia",
                    "ceara",
                    "maranhao",
                    "paraiba",
                    "pernambuco",
                    "piaui",
                    "rio grande do norte",
                    "sergipe"
                ].includes(nomeEstado)) {

                    cor =
                        "#FFA514";

                }


                // CENTRO-OESTE

                else if ([
                    "distrito federal",
                    "goias",
                    "mato grosso",
                    "mato grosso do sul"
                ].includes(nomeEstado)) {

                    cor =
                        "#F4E409";

                }


                // SUDESTE

                else if ([
                    "espirito santo",
                    "minas gerais",
                    "rio de janeiro",
                    "sao paulo"
                ].includes(nomeEstado)) {

                    cor =
                        "#E63817";

                }


                // SUL

                else if ([
                    "parana",
                    "rio grande do sul",
                    "santa catarina"
                ].includes(nomeEstado)) {

                    cor =
                        "#19B9F1";

                }


                // PATHS DO ESTADO

                const caminhos =
                    estado.querySelectorAll(
                        "path"
                    );


                caminhos.forEach(
                    function (caminho) {


                        // Ignorar bolinhas do SVG

                        if (
                            caminho.getAttribute(
                                "class"
                            ) === "circle"
                        ) {

                            return;

                        }


                        // COR

                        caminho.style.fill =
                            cor;


                        // BORDA

                        caminho.style.stroke =
                            "#050505";


                        caminho.style.strokeWidth =
                            "1.5";


                        // CURSOR

                        caminho.style.cursor =
                            "pointer";


                        // TRANSIÇÃO SUAVE

                        caminho.style.transition =
                            "opacity 0.15s ease";

                    }
                );


                // HOVER - ENTRAR NO ESTADO

                estado.addEventListener(
                    "mouseenter",
                    function () {

                        caminhos.forEach(
                            function (caminho) {

                                if (
                                    caminho.getAttribute(
                                        "class"
                                    ) === "circle"
                                ) {

                                    return;

                                }


                                caminho.style.opacity =
                                    "0.70";

                            }
                        );

                    }
                );


                // HOVER - SAIR DO ESTADO

                estado.addEventListener(
                    "mouseleave",
                    function () {

                        caminhos.forEach(
                            function (caminho) {

                                if (
                                    caminho.getAttribute(
                                        "class"
                                    ) === "circle"
                                ) {

                                    return;

                                }


                                caminho.style.opacity =
                                    "1";

                            }
                        );

                    }
                );


                // CLIQUE NO ESTADO

                estado.addEventListener(
                    "click",
                    function (event) {

                        event.preventDefault();


                        if (!nomeEstadoOriginal) {
                            return;
                        }


                        window.location.href =
                            "estado.html?estado=" +
                            encodeURIComponent(
                                nomeEstadoOriginal
                            );

                    }
                );

            }
        );

    }

    catch (erro) {

        console.error(
            "Erro ao carregar mapa:",
            erro
        );


        areaMapa.innerHTML =
            "<p style='color:white;'>Erro ao carregar o mapa do Brasil.</p>";

    }

}


// CARREGAR MAPA QUANDO CURSOS.HTML ABRIR

document.addEventListener(
    "DOMContentLoaded",
    carregarMapaBrasil
);