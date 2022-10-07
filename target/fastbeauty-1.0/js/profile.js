var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario();
    getReservas(username);
    $("#reservar-btn").attr("href", `home.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

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


function modificarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let telefono = $("#input-telefono").val();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            username_usuario: username,
            contrasena_usuario: contrasena,
            nombre_usuario: nombre,
            apellido_usuario: apellidos,
            email_usuario: email,
            telefono_usuario: telefono
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username_usuario: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}


function getReservas(username) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletReservaListar",
        data: $.param({
            username_usuario: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarReserva(parsedResult);

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarReserva(reservas) {
    let contenido = "";
    if (reservas.length >= 1) {
        $.each(reservas, function (index, reserva) {
            reserva = JSON.parse(reserva);

            contenido += '<tr><th scope="row">' + reserva.fecha_servicio + '</th>' +
                    '<td>' + reserva.username_usuario+ '</td>' +
                    '<td>' + reserva.nombre_servicio + '</td>';
        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}