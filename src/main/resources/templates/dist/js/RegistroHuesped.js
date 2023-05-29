
        const form = document.getElementById('DatosAcompañantes');

        form.addEventListener('submit', (e) => {
            e.preventDefault();

            let nombre = document.getElementById('nombre').value;
            let identificacion = document.getElementById('identificacion').value;
            let fecha = new Date().toLocaleDateString(); // Obtener la fecha actual
            let edad = document.getElementById('edad').value;
            let tieneMascota = document.getElementById('mascota').value;
            let cantidadPersonas = document.getElementById('cantidad-personas').value;

            let Acompañante = {nombre:nombre, identificacion:identificacion,fecha:fecha,edad:edad,tieneMascota:tieneMascota,cantidadPersonas:cantidadPersonas}; 
            let AcompañanteJSON = JSON.stringify(Acompañante); 

           fetch('URL ',{
            method:'POST',
            body : AcompañanteJSON 
           })

        })
