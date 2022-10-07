var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {



    fillUsuario();

    $("#btn-reserva").on("click", function (event) {
        event.preventDefault();
        registrarServicio();
        // resto de tu codigo
    });
    $("#btn-profile").attr("onclick", "location.href = 'profile.html?username=" + username + "'");

});

function registrarServicio() {

    let username = $("#input-username").val();
    let servicio = $('input:radio[name=servicio]:checked').val();
    let fecha = $('#input-fecha').val();
    let nombre_servicio;
    switch (servicio){
        case 1:
            nombre_servicio = "manicure";
            break;
        case 2:
            nombre_servicio = "Peluqueria niño";
            break;
        case 3:
            nombre_servicio = "Peluqueria Hombre";
            break;
        case 4:
            nombre_servicio = "Peluqueria Mujer";
            break;
        case 5:
            nombre_servicio = "Spa";
            break;
    }
    

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletServicioReserva",
        data: $.param({
            fecha_servicio: fecha,
            username_usuario: username,
            id_servicio: servicio,
            nombre_servicio: nombre_servicio

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                console.log("Todo salio bien");
                $("#register-error").addClass("d-none");
                $("#register-bueno").removeClass("d-none");
                $("#register-bueno").html("Reserva Realizada");
                $("#btn-reserva").addClass('inactive');
                $("#btn-profile").removeClass("inactive");
            } else {
                console.log("Todo salio mal");
                $("#register-error").removeClass("d-none");
                $("#register-error").html("Error en la reserva");
                $("#register-bueno").addClass("d-none");
            }


        }
    });

}

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username_usuario: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username_usuario);
                $("#input-contrasena").val(parsedResult.contrasena_usuario);
                $("#input-nombre").val(parsedResult.nombre_usuario);
                $("#input-apellidos").val(parsedResult.apellido_usuario);
                $("#input-email").val(parsedResult.email_usuario);
                $("#input-telefono").val(parsedResult.telefono_usuario);
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

