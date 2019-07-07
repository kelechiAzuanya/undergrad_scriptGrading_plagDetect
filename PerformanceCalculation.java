/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartGrader.scriptGrading;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartBuilder;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesMarker;
import com.xeiam.xchart.StyleManager;
import com.xeiam.xchart.XChartPanel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author LabaPc
 */
public class PerformanceCalculation {

    public Map<String, Integer> StudentScores;
    int MaxScore;
    int MinScore;
    Double AverageScore;
    String PliagiarismStatus;

    public PerformanceCalculation() {
        StudentScores = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            String kk = "a" + i;
            StudentScores.put(kk, i);
        }
    }

    public Double PlagiarismPercent() {
        int Count=0;
        Double tempH=0.0;
        Double percentPlag=0.0;
        for (Map.Entry<String, Integer> entry : StudentScores.entrySet()) {
         
            Double value = 1.0*entry.getValue();
            tempH=(1-value);
            percentPlag+=tempH;
        }
        
        return percentPlag;
    }

    public void displayScoresOnTable(JTable table) {

        //table = new JTable(rowData, columnNames);
    }

    public Double Averagescore() {
        int tempScore = 0;
        for (Map.Entry<String, Integer> entry : StudentScores.entrySet()) {
            Integer value = entry.getValue();
            tempScore += value;
        }
        AverageScore = 1.0 * (tempScore / StudentScores.size());
        return AverageScore;
    }

    public int MaxScore() {
        Collection<Integer> values = StudentScores.values();
        Integer[] Scores = values.toArray(new Integer[values.size()]);
        MaxScore = (int) Collections.max(Arrays.asList(Scores));

        return MaxScore;
    }

    public int MinScore() {
        Collection<Integer> values = StudentScores.values();
        Integer[] Scores = values.toArray(new Integer[values.size()]);
        MinScore = (int) Collections.min(Arrays.asList(Scores));
        return MinScore;
    }

    public void plotPerformanceChart(JPanel jPanelChart) {
        Chart chart = new ChartBuilder().chartType(StyleManager.ChartType.Bar).width(800).height(400).title("Student Performance Chart").xAxisTitle("Student Reg no")
                .yAxisTitle("Student Scores").build();

        chart.getStyleManager().setLegendPosition(StyleManager.LegendPosition.InsideNE);
        chart.getStyleManager().setBarWidthPercentage(0.3);
        chart.getStyleManager().setYAxisMax(100);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleFont(new Font("Century Gothic", Font.PLAIN, 14));
        // add series
        ArrayList<String> xValue = new ArrayList<String>();
        xValue.addAll(StudentScores.keySet());
        ArrayList<Integer> yValue = new ArrayList<Integer>();
        yValue.addAll(StudentScores.values());
        Series series = chart.addSeries("Plagiarism Scores", xValue, yValue);
        series.setMarker(SeriesMarker.NONE);
        XChartPanel xchartPanel = new XChartPanel(chart);
        jPanelChart.removeAll();
        jPanelChart.add(xchartPanel);
        jPanelChart.revalidate();
    }

}
