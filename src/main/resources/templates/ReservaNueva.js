
const ReservaNueva = document.getElementById('Reserva');

Reserva.addEventListener('submit', (e) => {
    e.preventDefault();

    let fechaIngreso = document.getElementById('fecha-ingreso').value;
    let fechaSalida = document.getElementById('fecha_salida').value;
    let cantidadPersonas = document.getElementById('cant_personas').value;
    let tipoHabitacion = document.getElementById('tipo_habitacion').value;

    let Reserva = {fechaIngreso:fechaIngreso,fechaSalida:fechaSalida,cantidadPersonas:cantidadPersonas,tipoHabitacion:tipoHabitacion}; 
    let ReservaJSON = JSON.stringify(Reserva); 

    
    fetch('url_del_backend', {
        method: 'POST',
        body: ReservaJSON
        })
        
    })

