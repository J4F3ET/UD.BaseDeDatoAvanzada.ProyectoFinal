      // Datos del objeto HotelDTO
      fetch('/api/hoteles')
      .then(response => response.json())
      .then(data => {
        const hotelesTableBody = document.getElementById('hoteles-body');
        console.log(data); 
        data.forEach(hotel => {
          const row = document.createElement('tr');
          row.innerHTML = `
            <td>${hotel.rnt_hotel}</td>
            <td>${hotel.nombre}</td>
            <td>${hotel.direccion}</td>
            <td>${hotel.anio_inauguracion}</td>
            <td>${hotel.categoria}</td>
            <td>${hotel.antiguedad}</td>
            <td>${hotel.telefono}</td>
          `;
          hotelesTableBody.appendChild(row);
        });
      })
      
              // Asignar los valores a las celdas de la tabla
              document.getElementById("rnt_hotel").textContent = hotel.rnt_hotel;
              document.getElementById("nombre").textContent = hotel.nombre;
              document.getElementById("direccion").textContent = hotel.direccion;
              document.getElementById("anio_inauguracion").textContent = hotel.anio_inauguracion;
              document.getElementById("categoria").textContent = hotel.categoria;
              document.getElementById("antiguedad").textContent = hotel.antiguedad;
              document.getElementById("telefono").textContent = hotel.telefono; 
      
              // Crear botón "Reservar"
              var button = document.createElement("button");
              button.innerHTML = "Reservar";
              button.className = "btn-reservar";
      
              // Asignar un identificador único al botón
              button.id = "reservar_" + hotel.rnt_hotel;
      
              // Agregar el botón a la celda correspondiente
              document.getElementById("reservar").appendChild(button);
      
              // Función para manejar el evento de clic en el botón
              button.onclick = function() {
                  var rnt_hotel = this.id.split("_")[1];
                  alert("Reservando hotel con ID: " + rnt_hotel);
                  window.location.href = './TablaHabitaciones.html'
                  // Aquí puedes agregar la lógica para realizar la reserva del hotel correspondiente
              };