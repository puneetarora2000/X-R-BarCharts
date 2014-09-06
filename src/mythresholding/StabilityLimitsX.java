/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mythresholding;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;


/**
 *
 * @author Puneet
 */
public class StabilityLimitsX {
    
 public static double[] FindLimits(String Tasklist,double ProjectRPNScore[]){
    
    MesurementsMatrix mm = new MesurementsMatrix();
    
    double Xbar  = mm.OverAllAverage(ProjectRPNScore);
    double XminusXbar = mm.XminusXbar(ProjectRPNScore,Xbar);
    double var = mm.SquareOfRatioOfNXminusXbar(XminusXbar, ProjectRPNScore.length);
    
    
    double CentralLimit = Xbar;
    double UpperLimit = mm.CalculateUpperLimitAverage(Xbar, var); 
    double LowerLimit = mm.CalculateLowerLimitAverage(Xbar, var); 
   
    System.out.println("Central Limit of  :"+Tasklist +   "  is"+CentralLimit);
    System.out.println("Upper Limit of  :"+Tasklist +   "  is" + UpperLimit);
    System.out.println("Lower Limit of  :"+Tasklist +   "  is" + LowerLimit);
    
    double limits[] = {LowerLimit,CentralLimit,UpperLimit};
    
 
    return limits;
 
 }
    
    
    
    
    
    public static void main(String args[]){
    
//    WorkFlowConstants wc = new WorkFlowConstants();
    
    
      double ProjectRPNSamplesScores1[] = {5.231944042,0.062626058,0.055667106,0.334920972,1.461274695,0.006441537,16.95537421,0.023857331,0.165708716,8.59E-04,2.98E-04,0.096622192};
      double ProjectRPNSamplesScores2[] = {4.06928981,0.041750706,9.54E-05,0.096887853,0.869607553,9.94E-04,9.042866245,1.19E-04,0.001526883,4.77E-05,0.002145034,0.026839739};
      double ProjectRPNSamplesScores3[] = {1.87043161,1.20E-04,3.34E-04,1.435375594,1.753529635,4.77E-04,14.06668083,6.36E-05,9.54E-04,7.97E-05,1.79E-04,0.040369939};
    
      
    double[] limits1 = FindLimits("Project1", ProjectRPNSamplesScores1);
    double[] limits2 = FindLimits("Project2", ProjectRPNSamplesScores2);
    double[] limits3 = FindLimits("Project3", ProjectRPNSamplesScores3);
   
    JFreeChart chart = ChartFactory.createBarChart3D
                     ("Calculation", // Title
                      "Limits",              // X-Axis label
                      "Projects ",// Y-Axis label
                      createDataset(),         // Dataset
                      PlotOrientation.VERTICAL,
                      true,                     // Show legend
                      true,
                      true
                     );
 
        saveChart(chart);
 
    
    
    
    
    }
    
    
    
    private static CategoryDataset createDataset() {
        double[][] data = new double[][]{
        {-11.811377268727915,2.0329661549166667,15.877309578561247},
{-6.087544862165725,1.1793474935833335,8.446239849332391},
{-9.489340177643356,1.5973829090000002,12.684105995643357,} };

        return DatasetUtilities.createCategoryDataset("Project", "A", data);
    }
    
    
    private static  CategoryDataset  createDataset2(double limits1[],double limits2[],double limits3[]) {

    // row keys...
    String series1 = "Project1";
    String series2 = "Project2";
    String series3 = "Project3";

    // column keys...
    String category1 = "Project 1";
    String category2 = "Project 2";
    String category3 = "Project 3";
    
     

    // create the dataset...
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    
    
     
        dataset.addValue(limits1[0], series1, category1);
        dataset.addValue(limits1[1], series1, category2);
        dataset.addValue(limits1[2], series1, category3);
         
        dataset.addValue(limits2[0], series2, category1);
        dataset.addValue(limits2[1], series2, category2);
        dataset.addValue(limits2[2], series2, category3);
     
    
        dataset.addValue(limits3[0], series3, category1);
        dataset.addValue(limits3[1], series3, category2);
        dataset.addValue(limits3[2], series3, category3);
                
     
     
    
    
    
    
    
           
    
    
    
    
    
    
    
    
    
    
    
    return dataset;

}

    public static void saveChart(JFreeChart chart)
    {
        String fileName="C://output//ThresholdChart.jpg";
        try {
        
        ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 800, 600);
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Problem occurred creating chart.");
    }
    }
    
    
    
    
    
    
}
