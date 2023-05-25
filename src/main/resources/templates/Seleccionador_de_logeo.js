
const submitBtn = document.getElementById('submit-btn');

submitBtn.addEventListener('click', () => {
    const rol = document.getElementById('rol').value;
    if (rol === 'agencia') {
        window.location.href = 'Registro_agencias.html'; // Reemplaza 'formulario-agencia.html' con la ruta a tu formulario para agencias
    } else if (rol === 'usuario') {
        window.location.href = 'VistaResponsable.html'; // Reemplaza 'formulario-usuario.html' con la ruta a tu formulario para usuarios
    }
});