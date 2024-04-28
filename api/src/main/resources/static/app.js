var main_id = document.querySelector("main").id;
console.log(main_id)
var navmenu = document.getElementsByClassName("nav")[0]
console.log(navmenu)
var naventity = navmenu.getElementsByTagName("a");
console.log(naventity)
var menuelem;

switch(main_id) {
    case 'index':
        menuelem = naventity[0];
        break;
    case 'menu':
        menuelem = naventity[1];
        break;
    case 'about_us':
        menuelem = naventity[2];
        break;
    case 'booking':
        menuelem = naventity[3];
        break;
    default:
        menuelem = naventity[0];
}
console.log(menuelem)
naventity.innerHTML = naventity[0].innerHTML;
menuelem.classList.add("active");

$(document).ready(function() {
    $(".hidebox p").hide();
});
$(".hidebox h2").click(function () {
    $(this).next("p").hide("slow");
    return false;
}).dblclick(function () {
    $(this).next("p").show("slow");
    return false;
});

// $('.hidebox h2').click(function() {
//     var boxText = $('.hidebox p').is(":visible") ? "Show me" : "Hide me";
//     $(".hidebox h2").suffix(boxText);
//     $('.hidebox p').slideToggle(250);
//     return false;
// });