function confirmar(contato_id) {
	let resposta = confirm("Confirma a exclusão desse contato?")
	if (resposta === true) {
		window.location.href = "delete?contato_id=" + contato_id
	}
}