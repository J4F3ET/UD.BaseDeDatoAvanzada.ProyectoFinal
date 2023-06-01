var Registrar = document.getElementById("Registrar"); 
var Consultar = document.getElementById("Consultar");
var Borrar = document.getElementById("Borrar"); 
var Pagos = document.getElementById("Registrar_pago")

Registrar.addEventListener("click",function(){
    window.location.href="RegistroHuespedes.html"
});

Pagos.addEventListener("click", function(){
    window.location.href="RegistrarPagos.html"

});

Consultar.addEventListener("click", function(){
    window.location.href="opcionesDeConsulta.html"
});


Borrar.addEventListener("click", function() {
    window.location.href=""
});