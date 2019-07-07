/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.GUI;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartBuilder;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesMarker;
import com.xeiam.xchart.StyleManager;
import com.xeiam.xchart.XChartPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author LabaPc
 */
public class plotChart {

    Map<String, Map<String, Double>> CosineValues;
    Map<String, Double> value;
    Map<String, Double> result;
    Map<String, Double> obj;
    Chart Picchart = null;
    JScrollPane jScrollPaneChart;
    public String chartTitle = null;
    Chart chart = new ChartBuilder().chartType(StyleManager.ChartType.Bar).width(800).height(400).title("Plagiarism Chart").xAxisTitle("Scripts")
            .yAxisTitle("Similarity Scores").build();

    public plotChart(Map<String, Map<String, Double>> CosineValue) {
        this.CosineValues = CosineValue;
    }

    private void sortedCosineResult(String fileName) {
        obj = CosineValues.get(fileName);
        //   obj.putAll(CosineValues.get(fileName));

        result = obj.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(result);
    }



    public JPanel renderChart(String fileName, String title) {
        sortedCosineResult(fileName);
        ArrayList<String> xValue = new ArrayList<String>();
        // xValue.addAll(CosineValues.get(fileName).keySet());
        xValue.addAll(result.keySet());
        ArrayList<Double> yValue = new ArrayList<Double>();

        /**
         * Using the fileName sort the set naturally before getting it seperate
         * X and Y value
         */
        yValue.addAll(result.values());
        Series series = null;
        Picchart = chart;
        chartTitle = title;
        chart.getStyleManager().setLegendPosition(StyleManager.LegendPosition.InsideNE);
        chart.getStyleManager().setPlotGridLinesVisible(true);
        //chart.getStyleManager().set
        chart.getStyleManager().setBarWidthPercentage(0.3);
        chart.getStyleManager().setYAxisMax(1.1);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleFont(new Font("Century Gothic", Font.PLAIN, 14));
        // add series
        series = chart.addSeries("Plagiarism Scores", xValue, yValue);

        series.setMarker(SeriesMarker.NONE);
        XChartPanel xchartPanel = new XChartPanel(chart);
        return xchartPanel;

    }

}
