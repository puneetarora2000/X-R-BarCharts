/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mythresholding;

import org.jfree.data.category.CategoryDataset;

import java.io.File;
import java.io.IOException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
 

/*
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
*/

/**
 *
 * @author 
 */
public class MainDecomposition {
    
 public static double[] FindLimits(String StabilityMetricName,double xStabilityMetricRPN[]){
    
     
     MesurementsMatrix mm = new MesurementsMatrix();
    
    double Xbar  = mm.OverAllAverage(xStabilityMetricRPN);
    double XminusXbar = mm.XminusXbar(xStabilityMetricRPN,Xbar);
    double var0 = mm.SquareOfRatioOfNXminusXbar(XminusXbar, xStabilityMetricRPN.length);
    
    System.out.println("Varaince:"+var0);
    
    
    double CentralLimit = Xbar;
    double UpperLimit = mm.CalculateUpperLimitAverage(Xbar, var0); 
    double LowerLimit = mm.CalculateLowerLimitAverage(Xbar, var0); 
 
    
    System.out.println("Central Limit of  :"+StabilityMetricName +   "  is"+CentralLimit);
    System.out.println("Upper Limit of  :"+StabilityMetricName +   "  is" + UpperLimit);
    System.out.println("Lower Limit of  :"+StabilityMetricName +   "  is" + LowerLimit);
    
    double limits[] = {LowerLimit,CentralLimit,UpperLimit};
    
 
    return limits;
 
 }
 
 
 
 private CategoryDataset createDataset() {
        
        // row keys...
        final String series1 = "First Metric";
        final String series2 = "Second Metric";
        final String series3 = "Third Metric";

        // column keys...
        final String category1 = "Metric 1";
        final String category2 = "Metric 2";
        final String category3 = "Metric 3";
        final String category4 = "Metric 4";
        final String category5 = "Metric 5";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(5.0, series1, category4);
        dataset.addValue(5.0, series1, category5);

        dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(6.0, series2, category3);
        dataset.addValue(8.0, series2, category4);
        dataset.addValue(4.0, series2, category5);

        dataset.addValue(4.0, series3, category1);
        dataset.addValue(3.0, series3, category2);
        dataset.addValue(2.0, series3, category3);
        dataset.addValue(3.0, series3, category4);
        dataset.addValue(6.0, series3, category5);
        
        return dataset;
        
    }
    
 
 private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Threshold Limits",         // chart title
            "Metrics",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
 
 
 
    
  
 
 
    
    
    
    public static void main(String args[]){
    
        
    double M1[] = {0.303829477,1.07920712,0.318094481,0.466676915,0.299853777,0.307387873,0.245339712,0.183291552,0.121243391}; //metric 
    double M2[] = {0.59089479,0.359953002,0.51039326,0.794390237,0.221918584,0.404455421,0.374103903,0.343752386,0.313400868}; //metric
    double M3[] = {0.900296927,1.816515615,2.363672092,0.380729866,0.192801875,0.275570519,0.009507066,0.294584652,0.579662237}; //metric 
    double M4[] = {0.064019197,0.426439669,1.070453707,0.267885148,0.680339858,0.824053556,0.931462236,1.038870916,1.146279596}; //metric
    double M5[] = {1.653840445,0.689125671,1.209675207,0.223879262,0.121190773,0.279621454,0.632676029,0.985730605,1.33878518}; //metric 
    
    double[] limits1 = FindLimits("StabilityMetric M1", M1);
     
    
        
    
    
    
      
    }
    
    
    
     

     
     
    
    
    
    
    
    
}
