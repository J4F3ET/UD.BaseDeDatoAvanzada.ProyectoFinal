const ReservaNueva = document.getElementById('Responsable_agencia');

Responsable_agencia.addEventListener('submit', (e) => {
    e.preventDefault();

    let fechaIngreso = document.getElementById('identificacion').value;
    let fechaSalida = document.getElementById('categoria').value;
    let cantidadPersonas = document.getElementById('id_usuario').value;

    let Responsable_agencia = {
        identificacion:identificacion,
        categoria:categoria,
        id_usuario:id_usuario
    }; 
    let ReservaJSON = JSON.stringify(Responsable_agencia); 

    console.log(Responsable_agencia); 
    
    fetch('/agencia/guardar', {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
        },
        body: ReservaJSON

        });
        
        window.location.href = 'ReservaNueva.html';
    });