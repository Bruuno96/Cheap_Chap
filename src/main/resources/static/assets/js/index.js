function grafico(arrayDado,arraySensor){
	
	let ctx = document.getElementById('chart').getContext('2d');
    let chart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [ 'January',
            'February',
            'March',
            'April',
            'May',
            'June',],
            datasets: [{
                label: "LUX",
                backgroundColor: '#aa78fd',
                borderColor: [
                    '#aa78fd',
                    '#aa78fd',
                    '#aa78fd',
                    '#aa78fd',
                    '#aa78fd',
                    '#aa78fd',
                    '#aa78fd'
                ],
                data: {
                    labels: labels,
                    datasets: [{
                      label: 'My First dataset',
                      backgroundColor: 'rgb(255, 99, 132)',
                      borderColor: 'rgb(255, 99, 132)',
                      data: [0, 10, 5, 2, 20, 30, 45],
                    }]}
            }]
        },

        options: {
            plugins: {
                title: {
                    display: true,
                    text: 'TAXA DE LUMINOSIDADE EM LUX',
                },
                legend: {
                    position: 'bottom'
                }
            },

            animation: {
                duration: 3000,
                easing: 'easeOutBounce'
            },

            layout: {
                padding: {
                    left: 20,
                    right: 20,
                    bottom: 20,
                    top: 20
                }
            },
            scales: {
                x: {
                    grid: {
                        display: true, // nao aparece linha do eixo X
                        borderColor: 'red',
                        drawBorder: false
                    }
                },
                y: {
                    grid: {
                        display: true, // nao aparece linha do eixo X
                        borderColor: 'red',
                        drawBorder: false
                    }
                }
            }
        }
    })
}