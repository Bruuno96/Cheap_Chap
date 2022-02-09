var select = document.getElementById('masc-tickets');
var value1 = select.options[select.selectedIndex].value;
var valueTicket1 = document.getElementById('valor-masc').getAttribute('value');
var totalMasculino = valueTicket1 * value1


var select = document.getElementById('fem-tickets');
var value2 = select.options[select.selectedIndex].value;
var valueTicket2 = document.getElementById('valor-fem').getAttribute('value');
var totalFeminino2 = valueTicket2 * value2

var select = document.getElementById('meia-tickets');
var value3 = select.options[select.selectedIndex].value;
var valueTicket3 = document.getElementById('valor-meia').getAttribute('value');
var totalMeia3 = valueTicket3 * value3

var total = totalMeia3 + totalFeminino2 + totalMasculino
let convert = parseFloat(total)

document.querySelector('#price').innerHTML += `R$ ${convert}`;