

function login()
{
    var u = document.getElementById("txtUser").value;
    var p = document.getElementById("txtPassword").value;
    
    if(u === "" || p === ""){
        Swal.fire("Intenta de nuevo", 'Todos los campos deben contener información', "warning");
    }

    var data = {"usuario": u, "contrasenia": p};
    $.ajax(
            {
                "url": "api/log/in",
                "type": "POST",
                "data": data,
                "async": true
            }).done(
            function (data)
            {
                if (data.idUsuario == 0)
                {
                    Swal.fire("Acceso denegado", "Datos de acceso incorrectos", "error");
                } else if (data.idUsuario != 0)
                {
                    alert("Iniciaste sesión con éxito");
                    window.location = "menu.html";
                }
            }
    );
    
}


function registro(){
    window.location = "registro.html";
}

function registrar(){
    var usuario = document.getElementById("txtUserRegistro").value;
    var password = document.getElementById("txtPasswordRegistro").value;
    
    if(usuario === "" || password === ""){
        Swal.fire("Intenta de nuevo", 'Todos los campos deben contener información', "warning");
    }
    else{
        
    var user = {"usuario": usuario, "contrasenia": password};
           
    var data = {"u":JSON.stringify(user)};
        $.ajax(
            {
                "url": "api/log/registrar",
                "type": "GET",
                "async": true,
                "data": data
            }
            ).done(
                    function (data)
            {
                if(data.result != null)
                {
                    Swal.fire({
                                icon: 'success',
                                title: 'Registro exitoso',
                                text: data.result,
                                confirmButtonText: 'Regresar'
                              }).then((result) => {
                        if (result.isConfirmed) {
                          window.location = "index.html";  
                          
                        }
                      })
                }
                else if(data.error != null)
                {
                    Swal.fire("Error", data.error, "error")
                }
                
            }
                );
    
    }
}
