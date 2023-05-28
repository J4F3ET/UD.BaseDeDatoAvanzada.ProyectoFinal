
const form = document.getElementById('DatosAgencia');

form.addEventListener('submit', (e) => {
    e.preventDefault();

    let nombre_agencia = document.getElementById('nombre_agencia').value;
    let rnt_agencia = document.getElementById('rnt_agencia').value; 
    let municipio = document.getElementById('municipio').value; 
    let correo_electronico = document.getElementById('correo_electronico').value;
    let password = document.getElementById('password').value;
    let alias = document.getElementById('alias').value;
    let direccion = document.getElementById('direccion').value;
    let telefono = document.getElementById('telefono').value;


    // Puedes hacer lo que necesites con los datos recopilados, como enviarlos a través de una solicitud HTTP o procesarlos en el lado del cliente.
    let Agencia = {
        nombre_agencia : nombre_agencia,
        rnt_agencia : rnt_agencia,
        municipio:municipio,
        correo_electronico:correo_electronico,
        password:password,
        alias:alias,
        direccion:direccion,
        telefono:telefono};
    let AgenciaJSON = JSON.stringify(Agencia);    

    fetch('proceda a meter su URL ',{
        method: 'POST',
        body : AgenciaJSON
    })
    // Redireccionar al formulario de reserva
   
    window.location.href = 'ReservaNueva.html';
});
