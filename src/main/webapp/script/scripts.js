"use strict";
console.log("** File ./script/scripts.js start loading... **");


/* GLOBAL */




/* --------------------------------------------------------------- */
/* ----------------  NAV BAR START ------------------------------- */
/* --------------------------------------------------------------- */

var initNavBar = function(){

    var nav = document.getElementsByTagName("nav")[0];
    var ul = nav.getElementsByTagName("ul")[0];

    var lis = ul.children;

    for (var i = 0, len = lis.length; i< len; i++ ){
        var li = lis[i];
        var a = li.getElementsByTagName("a")[0];

        var page = a.getAttribute("data-link-page");

       
        setNavBarItemClick(a, page);
    }
}

var setNavBarItemClick = function(element, page){

    element.onclick = function(){
        document.location.href = page
    }
}

var changePage = function(page){
    document.location.href = page
}
/* --------------------------------------------------------------- */
/* ----------------  NAV BAR END   ------------------------------- */
/* --------------------------------------------------------------- */




function initApp(){
    var page = document.getElementById("page");
    var pageName = page.getAttribute("data-page-name");
    console.log("Sono entrato nella pagina: " + pageName);

    initNavBar();
}



initApp();

/* --------------------------------------------------------------- */
/* ----------------  DIALOG START  ------------------------------- */
/* --------------------------------------------------------------- */



console.log("** File ./script/scripts.js has been loaded **");