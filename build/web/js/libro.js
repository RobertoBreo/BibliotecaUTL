
var libros;
function seleccionarBaseDatos(){
    var idBaseData = document.getElementById("lstDataBase").value;
    return idBaseData;
}

function registrar_modificarLibros(){
    var nombre = document.getElementById("txtNombreLibro").value;
    var descripcion = document.getElementById("txtDescripcion").value;
    var tema = document.getElementById("txtTema").value;
    var id = document.getElementById("txtID").value;
    var idBasedatos = seleccionarBaseDatos();
    
    if(nombre === "" || tema === ""){
        Swal.fire("Intenta de nuevo", 'Todos los campos deben contener información', "warning");
    }
    else{
    if(idBasedatos == 0){
        var libro = {"idLibro": id, "nombreLibro": nombre, "descripcion": descripcion, "tema": tema};
        //alert(JSON.stringify(libro));
        var data = {"libro":JSON.stringify(libro), "dataBase": idBasedatos};     
        if(id > 0){
        //Modificacion
        $.ajax(
            {
                "url": "api/libro/modificar",
                "type": "GET",
                "async": true,
                "data": data
            }
            ).done(
                    function (data)
            {
                if(data.result != null)
                {
                    //Se logro realizar la modificación
                    Swal.fire({
                                icon: 'success',
                                title: 'Modificación exitosa',
                                text: data.result,
                                confirmButtonText: 'Regresar'
                              }).then((result) => {
                        if (result.isConfirmed) {
                          window.location = "menu.html";  
                          
                        }
                      })
                }
                else if(data.error != null)
                {
                    //No se logro la modificación
                    Swal.fire("Error", data.error, "error");
                }
                
            }
            );
        }
        else{
            $.ajax(
            {
                "url": "api/libro/registrar",
                "type": "GET",
                "async": true,
                "data": data
            }
            ).done(
                    function (data)
            {
                if(data.result != null)
                {
                    //Se logro realizar el registro
                    Swal.fire({
                                icon: 'success',
                                title: 'Registro exitoso',
                                text: data.result,
                                confirmButtonText: 'Regresar'
                              }).then((result) => {
                        if (result.isConfirmed) {
                          window.location = "menu.html";  
                          
                        }
                      })
                }
                else if(data.error != null)
                {
                    //No se logro el registro
                    Swal.fire("Error", data.error, "error");
                }
            }
            );
        }
    }
    else if(idBasedatos == 1){
        var libro = {"idLibro": id, "nombreLibro": nombre, "descripcion": descripcion, "tema": tema};
        //alert(JSON.stringify(libro));
        var data = {"libro":JSON.stringify(libro), "dataBase": idBasedatos};     
        if(id > 0){
        //Modificacion
        $.ajax(
            {
                "url": "api/libro/modificarLibro",
                "type": "GET",
                "async": true,
                "data": data
            }
            ).done(
                    function (data)
            {
                if(data.result != null)
                {
                    //Se logro realizar la modificación
                    Swal.fire({
                                icon: 'success',
                                title: 'Modificación exitosa',
                                text: data.result,
                                confirmButtonText: 'Regresar'
                              }).then((result) => {
                        if (result.isConfirmed) {
                          window.location = "menu.html";  
                          
                        }
                      })
                }
                else if(data.error != null)
                {
                    //No se logro la modificación
                    Swal.fire("Error", data.error, "error");
                }
                
            }
            );
        }
        else{
            $.ajax(
            {
                "url": "api/libro/registrarLibro",
                "type": "GET",
                "async": true,
                "data": data
            }
            ).done(
                    function (data)
            {
                if(data.result != null)
                {
                    //Se logro realizar el registro
                    Swal.fire({
                                icon: 'success',
                                title: 'Registro exitoso',
                                text: data.result,
                                confirmButtonText: 'Regresar'
                              }).then((result) => {
                        if (result.isConfirmed) {
                          window.location = "menu.html";  
                          
                        }
                      })
                }
                else if(data.error != null)
                {
                    //No se logro el registro
                    Swal.fire("Error", data.error, "error");
                }
            }
            );
        }
    }
    }    
    
}

function cargarDatosLibros(i)
{
    $("#txtID").val(libros[i].idLibro);
    $("#txtNombreLibro").val(libros[i].nombreLibro);
    $("#txtDescripcion").val(libros[i].descripcion);
    $("#txtTema").val(libros[i].tema);
}

function limpiarDatosLibros()
{
    $("#txtID").val("");
    $("#txtNombreLibro").val("");
    $("#txtDescripcion").val("");
    $("#txtTema").val("");
}

function cargarLibros() {
    var estatus = 1;
    var idBasedatos = seleccionarBaseDatos();
    //alert(idBasedatos);
    if(idBasedatos == 0){
        var data = {"estatus": estatus};
        $.ajax(
            {
                "url": "api/libro/getLibro",
                "type": "GET",
                "async": true,
                "data": data
            }
    ).done(
            function (data)
            {
                libros = data;
                var datosTablaT = "";
                for (var i = 0; i < libros.length; i++)
                {
                    datosTablaT += "<tr>";
                    datosTablaT += "<td>" + libros[i].nombreLibro + "</td>";
                    datosTablaT += "<td>" + libros[i].descripcion + "</td>";
                    datosTablaT += "<td>" + libros[i].tema + "</td>";
                    datosTablaT += "<td> <button class='btn btn-danger' onclick='eliminarLibro(" + i + ")'><i class='bi bi-trash-fill'></i></button>\n\
                                         <button class='btn btn-success' style='margin-left:5px' onclick='cargarDatosLibros(" + i + ")'><i class='bi bi-pencil-square'></i></button></td>";
                    datosTablaT += "</tr>";
                }
                $("#tblLibros").html(datosTablaT);
            }
    );
    }
    if(idBasedatos == 1){
        var data = {"estatus": estatus};
        $.ajax(
            {
                "url": "api/libro/getSucursales",
                "type": "GET",
                "async": true,
                "data": data
            }
    ).done(
            function (data)
            {
                libros = data;
                var datosTablaT = "";
                for (var i = 0; i < libros.length; i++)
                {
                    datosTablaT += "<tr>";
                    datosTablaT += "<td>" + libros[i].nombreLibro + "</td>";
                    datosTablaT += "<td>" + libros[i].descripcion + "</td>";
                    datosTablaT += "<td>" + libros[i].tema + "</td>";
                    datosTablaT += "<td> <button class='btn btn-danger' onclick='eliminarLibro(" + i + ")'><i class='bi bi-trash-fill'></i></button>\n\
                                         <button class='btn btn-success' style='margin-left:5px' onclick='cargarDatosLibros(" + i + ")'><i class='bi bi-pencil-square'></i></button></td>";
                    datosTablaT += "</tr>";
                }
                $("#tblLibros").html(datosTablaT);
            }
    );
    }
    
}

function eliminarLibro(i){
    var id = libros[i].idLibro;
    var libro = {"idLibro": id};
    var data = {"libro": JSON.stringify(libro)};
    $.ajax(
            {
                "url": "api/libro/eliminar",
                "type": "GET",
                "async": true,
                "data": data
            }
            ).done(
                    function (data)
            {
                if(data.result != null)
                {
                    //Se logro realizar la eliminacion
                    Swal.fire({
                                icon: 'success',
                                title: 'Eliminación exitosa',
                                text: data.result,
                                confirmButtonText: 'Aceptar'
                              }).then((result) => {
                        if (result.isConfirmed) {
                          window.location = "menu.html";  
                          
                        }
                      })
                }
                else if(data.error != null)
                {
                    //No se logro la eliminación
                    Swal.fire("Error", data.error, "error")
                }
            }
                );
}