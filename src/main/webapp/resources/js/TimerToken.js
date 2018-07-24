function vio()
{
    var fecha = document.getElementById("fech").value;
    //alert(fecha);
    if (fecha == "No se ha establecido token") 
    {
        document.getElementById("noSetTempToken").innerHTML = "No se ha establecido fecha de vencimiento";
    } else 
    {
        var countDownDate = new Date(fecha).getTime();

        var x = setInterval(function () {

            var now = new Date().getTime();

            var distance = countDownDate - now;

            var days = Math.floor(distance / (1000 * 60 * 60 * 24));
            var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
            var seconds = Math.floor((distance % (1000 * 60)) / 1000);

            document.getElementById("demo").innerHTML = days + "d " + hours + "h "
                    + minutes + "m " + seconds + "s ";


            if (distance < 0) {
                clearInterval(x);
                document.getElementById("demo").innerHTML = "EXPIRED";
            }
        }, 1000);
    }
}

function resetFecha()
{
     document.getElementById("fech").value = "No se ha establecido token";
}