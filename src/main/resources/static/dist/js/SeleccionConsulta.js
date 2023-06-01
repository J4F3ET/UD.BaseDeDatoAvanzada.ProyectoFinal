const submitBtn = document.getElementById('submit-btn');

submitBtn.addEventListener('click', () => {
    const consulta = document.getElementById('consulta').value;
    if (consulta === 'periodo_tiempo') {
        window.location.href = 'Registro_agencias.html'; // Reemplaza 'formulario-agencia.html' con la ruta a tu formulario para agencias
    } else if (consulta === 'sin_20') {
        window.location.href = 'tablaReservaCancelada.html'; // Reemplaza 'formulario-usuario.html' con la ruta a tu formulario para usuarios
    }else if ( consulta == 'con_20'){
        window.location.href = "tablaReservaNoUtilizada.html"; 
    }else if ( consulta == 'llegadas_A_tiempo'){
        window.location.href = "tablaRegistrosATiempo.html";
    }else if(consulta == 'mascotas_menores'){
        window.location.href = "TablaMascotas.html";
    }else if(consulta == 'Servicios_adicionales'){
        window.location.href = "tablaServicios.html";
    }else if(consulta == 'datos_huespedes'){
        window.location.href = "PanelAdministrador.html";
    }
});