
// Función para mostrar las habitaciones en la tabla
function mostrarHabitaciones() {
    const habitacionesTableBody = document.getElementById('habitaciones-body');
  
    // Realizar la solicitud al backend para obtener los datos de las habitaciones
    fetch('/api/habitaciones')
      .then(response => response.json())
      .then(data => {
        data.forEach(habitacion => {
          const row = crearFilaHabitacion(habitacion);
          habitacionesTableBody.appendChild(row);
        });
      })
      .catch(error => console.error(error));
  }
  
  // Función para seleccionar una habitación
  function seleccionarHabitacion(numero_habitacion) {
    // Realizar la solicitud al backend para guardar la selección de la habitación
    fetch('/api/reserva', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({numero_habitacion })
    })
    console.log(numero_habitacion)
      .then(response => response.json(numero_habitacion))
      .then(data => {
        // Aquí puedes manejar la respuesta del backend después de guardar la selección de la habitación
       console.log(data);
      })
      .catch(error => console.error(error));
  }
  
  // Mostrar las habitaciones al cargar la página
  mostrarHabitaciones();