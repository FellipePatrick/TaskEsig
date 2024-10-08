let todasTarefas = []; // Armazena todas as tarefas carregadas inicialmente

// Função para listar todas as tarefas
function listarTarefas() {
    fetch('/api/tarefas/')
        .then(response => response.json())
        .then(data => {
            todasTarefas = data.content; // Armazena todas as tarefas carregadas
            const tbody = document.querySelector("tbody");
            tbody.innerHTML = "";
            if (Array.isArray(todasTarefas)) {
                todasTarefas.forEach(tarefa => {
                    adicionarTarefaTabela(tarefa);
                });
            } else {
                console.error("A resposta da API não contém uma lista de tarefas:", data);
            }
        })
        .catch(error => console.error("Erro ao buscar tarefas:", error));
}

// Função para adicionar uma tarefa na tabela
function adicionarTarefaTabela(tarefa) {
    const tbody = document.querySelector("tbody");
    const tr = document.createElement("tr");

    tr.innerHTML = `
        <td>${tarefa.id}</td>
        <td>${tarefa.titulo}</td>
        <td>${tarefa.responsavel}</td>
        <td>${tarefa.descricao}</td>
        <td>${tarefa.prioridade}</td>
        <td>${tarefa.deadLine}</td>
        <td>${tarefa.status}</td>
        <td>
            <button class="btn btn-warning btn-sm me-2" data-bs-toggle="modal" data-bs-target="#editModal"
                onclick="setTarefaData(${tarefa.id}, '${tarefa.titulo}', '${tarefa.responsavel}', '${tarefa.descricao}', '${tarefa.prioridade}', '${tarefa.deadLine}', '${tarefa.status}')">
                Editar
            </button>
            <button class="btn btn-danger btn-sm" onclick="excluirTarefa(${tarefa.id})">Excluir</button>
        </td>
    `;

    tbody.appendChild(tr);
}

function filtrarTarefas() {
    const titulo = document.getElementById('filtroTitulo').value.toLowerCase();
    const responsavel = document.getElementById('filtroResponsavel').value.toLowerCase();
    const prioridade = document.getElementById('filtroPrioridade').value.toLowerCase();
    const status = document.getElementById('filtroStatus').value.toLowerCase();

    const tarefasFiltradas = todasTarefas.filter(tarefa => {
        const tituloMatch = tarefa.titulo.toLowerCase().includes(titulo);
        const responsavelMatch = tarefa.responsavel.toLowerCase().includes(responsavel);
        const prioridadeMatch = tarefa.prioridade.toLowerCase().includes(prioridade);

        const statusMatch = tarefa.status.toLowerCase().includes(status);

        // Retorna verdadeiro apenas se todos os critérios forem atendidos
        return tituloMatch && responsavelMatch && prioridadeMatch && statusMatch;
    });

    atualizarTabela(tarefasFiltradas);
}


// Função para atualizar a tabela com as tarefas filtradas
function atualizarTabela(tarefas) {
    const tbody = document.querySelector("tbody");
    tbody.innerHTML = ""; // Limpa a tabela antes de adicionar as tarefas filtradas
    if (tarefas.length === 0) {
        const tr = document.createElement("tr");
        tr.innerHTML = `<td colspan="8" class="text-center">Nenhuma tarefa encontrada.</td>`;
        tbody.appendChild(tr);
    } else {
        tarefas.forEach(tarefa => {
            adicionarTarefaTabela(tarefa);
        });
    }
}

// Função para limpar os campos de filtro e listar todas as tarefas
function limparFiltros() {
    document.getElementById('filtroTitulo').value = '';
    document.getElementById('filtroResponsavel').value = '';
    document.getElementById('filtroPrioridade').value = '';
    document.getElementById('filtroData').value = '';
    document.getElementById('filtroStatus').value = '';
    atualizarTabela(todasTarefas); // Reseta a tabela para mostrar todas as tarefas novamente
}

// Função para cadastrar uma nova tarefa
function cadastrarTarefa(event) {
    event.preventDefault();
    const titulo = document.getElementById('titulo').value;
    const responsavel = document.getElementById('responsavel').value;
    const descricao = document.getElementById('descricao').value;
    const prioridade = document.getElementById('prioridade').value;
    const deadLine = document.getElementById('deadLine').value;
    const status = "CRIADO";

    fetch('/api/tarefas/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ titulo, responsavel, descricao, prioridade, deadLine, status })
    })
        .then(response => response.json())
        .then(() => {
            alert("Tarefa cadastrada com sucesso!");
            window.location.reload();
        });
}

// Função para setar os dados da tarefa nos campos do modal de edição
function setTarefaData(id, titulo, responsavel, descricao, prioridade, deadLine, status) {
    document.getElementById('editId').value = id;
    document.getElementById('editTitulo').value = titulo;
    document.getElementById('editResponsavel').value = responsavel;
    document.getElementById('editDescricao').value = descricao;
    document.getElementById('editPrioridade').value = prioridade;
    document.getElementById('editDeadLine').value = deadLine;
    document.getElementById('editStatus').value = status;
}

// Função para editar uma tarefa existente
function editarTarefa(event) {
    event.preventDefault();
    const id = document.getElementById('editId').value;
    const titulo = document.getElementById('editTitulo').value;
    const responsavel = document.getElementById('editResponsavel').value;
    const descricao = document.getElementById('editDescricao').value;
    const prioridade = document.getElementById('editPrioridade').value;
    const deadLine = document.getElementById('editDeadLine').value;
    const status = document.getElementById('editStatus').value;

    fetch(`/api/tarefas/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ titulo, responsavel, descricao, prioridade, deadLine, status })
    })
        .then(() => {
            alert("Tarefa editada com sucesso!");
            window.location.reload();
        });
}

// Função para excluir uma tarefa
function excluirTarefa(id) {
    fetch(`/api/tarefas/${id}`, {
        method: 'DELETE'
    })
        .then(() => {
            alert("Tarefa excluída com sucesso!");
            window.location.reload();
        });
}

// Chama a função para listar tarefas ao carregar a página
window.onload = listarTarefas;
