var img = document.querySelector("#img");
var icone = document.getElementsByClassName("imagem");
var coll = document.getElementsByClassName("collapsible");
var img = document.getElementById('img');
var i;

for (i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click", function() {
        var icone = this.children[0];
        var content = this.nextElementSibling;
        if (content.style.display === "block") {
            $(content).slideUp('slow');
            $(icone).attr('src', './assets/img/plus.png');
        } else {
            $(icone).attr('src', './assets/img/minus-line.png');
            $(content).slideDown('slow');
        }
    });
}