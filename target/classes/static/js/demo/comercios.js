$(document).ready(function () {
    
 $.ajax({
     type: "POST",
     url: "control/lista/getComercio.php",
     data: "peticion: cargar_comercio",
     dataType: "JSON",
     success: function (response) {

        response.lista.forEach(tipoCom => {

            $('#tipoCliente').append(

                `<div class='col-4'>
                <input class='form-check-input' type='checkbox' value='${tipoCom.tipo_comercio}' id='com_${tipoCom.tipo_comercio}'>
                <label class='form-check-label' for='com_${tipoCom.tipo_comercio}'>
                    ${tipoCom.nombre}
                </label>
                </div>`
            
            );

            });
        }
    });
});