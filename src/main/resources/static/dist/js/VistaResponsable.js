
        const form = document.getElementById('DatosUsuario');

        form.addEventListener('submit', (e) => {
            e.preventDefault();

            let nombre = document.getElementById('nombre').value;
            let identificacion = document.getElementById('identificacion').value; 
            let categoria = document.getElementById('categoria').value; 
            let correo = document.getElementById('correo_electronico').value;
            let password = document.getElementById('password').value;
            let alias = document.getElementById('alias').value;
            let direccion = document.getElementById('direccion').value;
            let telefonoCelular = document.getElementById('telefono').value;

            let Usuario={
                nombre : nombre, 
                identificacion : identificacion,
                categoria : categoria,
                correo : correo,
                password : password,
                alias : alias,
                direccion : direccion,
                telefonoCelular : telefonoCelular
            };
            let UsuarioJSON = JSON.stringify(Usuario); 
            console.log(UsuarioJSON);
            // Puedes hacer lo que necesites con los datos recopilados, como enviarlos a través de una
            // solicitud HTTP o procesarlos en el lado del cliente.
<<<<<<<< HEAD:src/main/resources/templates/dist/boostrap/js/VistaResponsable.js
            fetch( 'Rponsable/guardar',{
========
            fetch( '/responsable/guardar',{
>>>>>>>> dc7884486dcac2a6548d73a30ff2bbcfea1135a2:src/main/resources/static/dist/js/VistaResponsable.js
            method: "POST",
            headers:{
                'Content-Type': 'application/json',
            },
                body: UsuarioJSON 
            });

            window.location.href = './ReservaNueva.html'; 
        });
