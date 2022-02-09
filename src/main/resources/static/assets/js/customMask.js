$(document).ready(function(){
    $(".real").mask('#.##0,00', {
        reverse: true
        });

        function calculateValue() {
            $('#vd_ga').val().replace(',', '.');
        }

        function convertToCurrency(value) {
        return value.toLocaleString("pt-BR", {
            style: "currency",
            currency: "BRL",
            minimumFractionDigits: 2
        })
        }
});