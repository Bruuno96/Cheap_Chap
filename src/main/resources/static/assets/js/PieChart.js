am5.ready(function() {

    // Create root element
    // https://www.amcharts.com/docs/v5/getting-started/#Root_element
    var root = am5.Root.new("chartdiv3");
    
    // Set themes
    // https://www.amcharts.com/docs/v5/concepts/themes/
    root.setThemes([
      am5themes_Animated.new(root)
    ]);
    
    // Create chart
    // https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
    var chart = root.container.children.push(
      am5percent.PieChart.new(root, {
        endAngle: 270
      })
    );
    
    // Create series
    // https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
    var series = chart.series.push(
      am5percent.PieSeries.new(root, {
        valueField: "value",
        categoryField: "category",
        endAngle: 270
      })
    );
    
    series.states.create("hidden", {
      endAngle: -90
    });
    
    // Set data
    // https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Setting_data
    series.data.setAll([{
      category: "Marketing",
      value: 501.9
    }, {
      category: "Bebidas",
      value: 301.9
    }, {
      category: "Comida",
      value: 201.1
    }, {
      category: "Serviço",
      value: 165.8
    }, {
      category: "Estrutura",
      value: 139.9
    }
]);
    
    series.appear(1000, 100);
    
    }); // end am5.ready()