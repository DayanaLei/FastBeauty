var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
    });
     $("#btn-reserva").attr("onclick","location.href = 'reserva.html?username=" + username+"'");
});
async function getUsuario() {

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
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
