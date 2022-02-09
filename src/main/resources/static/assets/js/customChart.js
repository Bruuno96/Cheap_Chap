 // === include 'setup' then 'config' above ===
 const labels = [
    'Janeiro',
    'Fevereiro',
    'Março',
    'Abril',
    'Maio',
    'Junho',
    'Julho',
    'Agosto',
    'Setembro',
    'Outubro',
    'Novembro',
    'Dezembro'
];
const data = {
labels: labels,
datasets: [{
label: 'Faturamento anual',
backgroundColor: 'rgb(47,3,73)',
borderColor: 'rgb(255, 99, 132)',
data: [5800, 10000, 5000, 2000, 2000, 3000, 4500, 4200, 6700, 7800, 9000, 12000],
}],
options:{
responsive:true,
}
};

const config = {
type: 'bar',
data: data,
options: {}
};

const myChart = new Chart(
document.getElementById('myChart'),
config
);

// doug