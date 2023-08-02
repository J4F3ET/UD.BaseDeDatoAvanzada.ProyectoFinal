// Agencia DTO para el login
// AgenciaPK id
// string nombre_agencia
// MunicipioDTO municipio

// MunicipioDTO
// short id
// string nombre

// AgenciaPK
// int rnt
// UsuarioDTO usuario

// UsuarioDTO
// string nombre
// string correo
// string password
// string alias
// string direccion
// List<TelefonoDTO> telefonos

// TelefonoDTO
// TelefonoPK id

// TelefonoPK
// long id
// UsuarioDTO usuario
function registerUser(user, tel) {
	var statusUser = {status: false, user: null, tel: null};
	fetch("/usuario/guardar", {
		method: "POST",
		headers: {"Content-Type": "application/json"},
		body: JSON.stringify(user),
	})
		.then((response) => response.json())
		.then((data) => {
			tel.forEach(
				(t) =>
					(t.id.usuario = {
						id_usuario: data.id_usuario,
						nombre: data.nombre,
						correo: data.correo,
						password: data.password,
						alias: data.alias,
						direccion: data.direccion,
					})
			);
			fetch("/telefono_usuario/guardar", {
				method: "POST",
				headers: {"Content-Type": "application/json"},
				body: JSON.stringify({telefonos: tel}),
			})
				.then(response => response.json())
				.then(data =>{
					console.log(data);
					data[0].id.telefono == 0
						? (statusUser.tel = null)
						: (statusUser.tel = data);
				});
		});
	statusUser.user != null && statusUser.tel != null
		? (statusUser.status = true)
		: (statusUser.status = false);
	return statusUser;
}
function registerAgent(user, agent) {
	var response = registerUser(user.usuario, user.tel);
	if (response.status === false) {
		return (response = {status: false});
	}
	fetch("/api/agencia", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(agent),
	}).then((response1) => {
		response = {response1};
	});
	if (response.response1.status === 200) {
		return (response = {status: true});
	}
	return (response = {status: false});
}
function validarRegistroUsuario() {
	var telefonos = [];
	if (
		document.querySelector("#inputNombre").value === "" ||
		document.querySelector("#inputCorreo").value === "" ||
		document.querySelector("#inputPass").value === "" ||
		document.querySelector("#inputAlias").value === "" ||
		document.querySelector("#inputDireccion").value === "" ||
		document.querySelector("#inputMunicipioUsuario").value === ""
	) {
		alert("No puede haber campos vacios");
		return {statusUser: false};
	}
	let usuario = {
		nombre: document.querySelector("#inputNombre").value,
		correo: document.querySelector("#inputCorreo").value,
		password: document.querySelector("#inputPass").value,
		alias: document.querySelector("#inputAlias").value,
		direccion:
			document.querySelector("#inputDireccion").value +
			" " +
			document.querySelector("#inputMunicipioUsuario").text
	};
	document.querySelectorAll(".telefonoUsuario").forEach((tel) => {
		if (tel.value != "") {
			telefonos.push({id: {telefono: parseInt(tel.value), usuario: null}});
		}
	});
	return {statusUser: true, usuario, telefonos};
}
function validarRegistroAgencia() {
	if (
		(document.querySelector("#inputRnt").value = "") ||
		(document.querySelector("#inputRazonSocial").value = "") ||
		(document.querySelector("#inputMunicipioAgencia").value = "")
	) {
		alert("No puede haber campos vacios");
		return {statusAgent: false};
	}
	let agencia = {
		id: {rnt: document.querySelector("#inputRnt").value, usuario: null},
		nombre_agencia: document.querySelector("#inputRazonSocial").value,
		municipio: {
			id: parseInt(document.querySelector("#inputMunicipioAgencia").value),
			nombre: document.querySelector("#inputMunicipioAgencia").text,
		},
	};
	// BANDERA PARA SABER SI SE REGISTRA UNA AGENCIA O UN EMPLEADO
	console.log(agencia);
	return {statusAgent: true, agencia};
}
document.querySelectorAll(".btnRegEmpleado").forEach((btn) => {
	btn.addEventListener("click", () => {
		var response = validarRegistroUsuario();
		if (response.statusUser === false) {
			return;
		}
		document.querySelector(".btnRegAgen").addEventListener("click", () => {
			let responseA = validarRegistroAgencia();
			if (response.statusAgent === false) {
				return;
			}
		});

	});
});
document.querySelector("#btnEnviarRegU").addEventListener("click", (event) => {
	event.preventDefault();
	let response = validarRegistroUsuario();
	if (response.statusUser === true) {
		registerUser(response.usuario, response.telefonos);
	}
});
document.querySelector("#btnAddPhone").addEventListener("click", (event) => {
	event.defaultPrevented;
	let div = document.querySelector("#btnAddPhone");
	let numImputs = document.querySelectorAll(".telefonoUsuario").length;
	div.parentElement.insertAdjacentHTML(
		"beforebegin",
		'<div class="form-floating mb-2"><input type="number" class="telefonoUsuario form-control" id="' +
			numImputs +
			'inputTelefono" name="inputTelefono[]" placeholder="3197272112"><label for="' +
			numImputs +
			'inputTelefono">Telefono o Celular</label></div>'
	);
});