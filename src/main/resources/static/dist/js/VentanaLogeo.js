const VentanaLogeo = document.getElementById('login','Registrar');



login.addEventListener('submit', (e) => {
   e.preventDefault(); 

   let alias = document.getElementById('alias').value; 
   let password = document.getElementById('password').value; 
   
   let Validar = {alias:alias,password:password}; 
   let ValidadJSON = JSON.stringify(Validar);
   

   fetch('URL',{
    method: 'POST',
    body: ValidadJSON 
   })

   console.log("se subieron los datos"); 
});

document.getElementById("Registrar").addEventListener("click", function(){
window.location.href ='./Seleccionador_de_logeo.html';   
    
}); 