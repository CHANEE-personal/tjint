$(document).ready(function() {
    var link =  document.location.pathname;
    if (link == "/business/brandList.do") {
        $("[href='/business/brandList.do']").parent("li").attr("class", "on");
        $("[href='" + link + "'][class='depth2']").css("text-decoration", "underline");
        return;
    } else if (link == "/business/categoryList.do" || link == "/business/snsList.do") {
        $("[href='/business/brandList.do']").parent("li").attr("class", "on");
        $("[href='" + link + "']").css("text-decoration", "underline");
        $("[class='depth2']").css("text-decoration", "none");
        return;
    }

    var menu = $(".localMenu").children("li").children("a");
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
    var result = "";
    for (i = 1; i < url.length - 1; i++) {
        result += url[i] + "/";
    }
    return result;
}

function active(menu) {
    $(menu).parent("li").attr("class", "on");
}
