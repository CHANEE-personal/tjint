$(document).ready(function() {
    var link =  document.location.pathname;
    var menu = $(".localMenu").children('li').children('div').children('ul').children('li').children('a');

    for (var i = 0; i < menu.length ; i++) {
        var menuPath = menu[i].pathname;
        if (menuPath.length > 0) {
            if (menuPath == link) {
                active(menu[i]);
            }
        }
    }
});

function splitUrl(url){
    var result = '';
    for (i = 1; i < url.length - 1; i++) {
        result += url[i] + '/';
    }
    return result;
}

function active(menu) {
    $(menu).parent('li').attr("class", "on");
}
