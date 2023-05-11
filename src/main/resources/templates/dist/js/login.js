const container_select = document.querySelector('.primera-vista')
const btn_cliente = document.querySelector('.btn_cliente');
const btn_agencia = document.querySelector('.btn_agencia');

const container_form = document.querySelector('.form'); // Div contenedor del formulario
const form_login = document.querySelector('#form-login'); // Etiqueta como tal de formulario
const form_login_data = document.querySelector('[data-login-form]'); //Cuerpo del formulario

const Toast = Swal.mixin({
	toast: true,
	showConfirmButton: false,
	timer: 2000,
	timerProgressBar: true,
	didOpen: (toast) => {
		toast.addEventListener("mouseenter", Swal.stopTimer);
		toast.addEventListener("mouseleave", Swal.resumeTimer);
	},
});

btn_cliente.addEventListener('click', () => {
    container_select.classList.add('invisible');

    const info = `
    <input type="text" placeholder="Municipio..." required data-form-municipio>
    <input type="text" placeholder="Nombre de agencia..." required data-form-nombre-agencia>
    `
    form_login.innerHTML += info;

    container_form.classList.remove('invisible');
});

btn_agencia.addEventListener('click', () => {
    container_select.classList.add('invisible');

    const info = `
        <input type="text" placeholder="Id..." required data-form-id>
        <input type="text" placeholder="Categoria..." required data-form-categoria>
    `
    form_login.innerHTML += info;

    container_form.classList.remove('invisible');
});
