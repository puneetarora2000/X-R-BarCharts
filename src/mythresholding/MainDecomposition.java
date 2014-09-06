/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mythresholding;

import org.jfree.data.category.CategoryDataset;

import java.io.File;
import java.io.IOException;

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
    
    
    
    
    
    public static void main(String args[]){
    
        
    double M1[] = {0.303829477,1.07920712,0.318094481,0.466676915,0.299853777,0.307387873,0.245339712,0.183291552,0.121243391}; //metric 
    double M2[] = {0.59089479,0.359953002,0.51039326,0.794390237,0.221918584,0.404455421,0.374103903,0.343752386,0.313400868}; //metric
    double M3[] = {0.900296927,1.816515615,2.363672092,0.380729866,0.192801875,0.275570519,0.009507066,0.294584652,0.579662237}; //metric 
    double M4[] = {0.064019197,0.426439669,1.070453707,0.267885148,0.680339858,0.824053556,0.931462236,1.038870916,1.146279596}; //metric
    double M5[] = {1.653840445,0.689125671,1.209675207,0.223879262,0.121190773,0.279621454,0.632676029,0.985730605,1.33878518}; //metric 
    
    double[] limits1 = FindLimits("StabilityMetric M1", M1);
     
      
    }
    
    
    
    private static  CategoryDataset  createDataset(double limits1[],double limits2[],double limits3[],double limits4[],double limits5[]) {

    // row keys...
    String series1 = "StabilityMetric1";
    String series2 = "StabilityMetric2";
    String series3 = "StabilityMetric3";
    String series4 = "StabilityMetric4";
    String series5 = "StabilityMetric5";

    // column keys...
    String category1 = "StabilityMetric 1";
    String category2 = "StabilityMetric 2";
    String category3 = "StabilityMetric 3";
    String category4 = "StabilityMetric 4";
    String category5 = "StabilityMetric 5";
    
     

    // create the dataset...
         
        
        
          
    
    return null;

}

     
     
    
    
    
    
    
    
}
