
const ReservaNueva = document.getElementById('Reserva');

Reserva.addEventListener('submit', (e) => {
    e.preventDefault();

    let fechaIngreso = document.getElementById('fecha_ingreso').value;
    let fechaSalida = document.getElementById('fecha_salida').value;
    let cantidadPersonas = document.getElementById('cant_personas').value;

    let Reserva = {
        fechaIngreso:fechaIngreso,
        fechaSalida:fechaSalida,
        cantidadPersonas:cantidadPersonas
    }; 
    let ReservaJSON = JSON.stringify(Reserva); 

    console.log(Reserva); 
    
    fetch('/agencia/guardar', {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
        },
        body: ReservaJSON

        });
        
        window.location.href = 'TablaHoteles.html';
    });

