/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mythresholding;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
 
public class MesurementsMatrix {
    
    
    public double CalculateUpperLimitAverage(double mean, double varaince){
       
        double ul = 3+varaince ;
             return ul;
        }
      
     public double CalculateLowerLimitAverage(double mean, double varaince){
         
        double ul = -3+varaince ;
         
        if (ul<0){
        
        ul =0;
        }
        
        return ul;
    }
    
     
     
     public double SquareOfRatioOfNXminusXbar(double XminusXbar,int NoofSamples){
         
         double std =0;
         
           std = Math.sqrt(XminusXbar/NoofSamples);
          return  std ;
     }
     
     
     public double XminusXbar(double xBankRPN[],double Xbar){
     
         double sum = 0;
         double diff = 0;
         
         for(double m :xBankRPN){
            
             diff =   (m-Xbar)*(m-Xbar);
              System.out.println(diff);
             sum = sum+diff;
         
         }
         
         
         System.out.println("The Sum "+sum);
         
         return sum;
     }
     
    
     // for Each TaskList /Obervation
     public double sumofEachSubTaskMetricValue(double ratios[]){
     
         int n = ratios.length;
         double sum = 0;
         
         for(double m :ratios){
            
             sum = sum+m;
         
         }
         
         return sum;
     }
     
     
     
     
    
    
    public double CalculateVaraince(double sumofEachSubTaskMetricValue[],int totalNumberOfObservations){
    
    
        double sum = 0; 
            
        double t ;
        double total =0;
        
        
        
        
        for(double m :sumofEachSubTaskMetricValue){
                total = total+m;
        }
          
                 
            t = total ;     
            double mean = t/totalNumberOfObservations;
            
            double difference ;
            double sumdiff=0;
            
            //x-x bar
            for(double m :sumofEachSubTaskMetricValue){
                difference =  m-mean;
        
               sumdiff = sumdiff+difference; 
            }
            
            double div = sumdiff/mean;
            
            double varn = Math.sqrt(div);
            
            return varn;
    }
    
    
    
    //totalNumberOfObservations = total task list 
    public double CalculateRationalizationFactorA2Factor(double sumofEachSubTaskMetricValue[],int totalNumberOfObservations){
    
        double sum = 0; 
            
        double t ;
        double total =0;
        
        for(double m :sumofEachSubTaskMetricValue){
                total = total+m;
        }
          
                 
            t = total ;     
                 
         
    
        return t/totalNumberOfObservations;
  
                
    
        
    
    }
    
    
    
    
    // Total of Each TaskList 
    
    public double CalculateUpperLimitAverage(double OverAllAverage, double OverAllRange,double A2Factor){
        double ul = 0;
        
        
        ul = OverAllAverage+(OverAllRange*A2Factor);
                       
        return ul;
    }
    
    public double CalculateCentralLimitAverage(double groupAveragesofEachTaskArray[]){
        
        double cl = OverAllAverage(groupAveragesofEachTaskArray);
       
        return  cl;
    }
    
    
    public double CalculateLowerLimitAverage(double OverAllAverage, double OverAllRange,double A2Factor){
        double lc = 0;
        
        
        lc = OverAllAverage-(OverAllRange*A2Factor);
                       
        return lc;
    }
    
    
    public double groupRange(double metrics[]){
       
         List b = Arrays.asList(metrics);
        Object min = Collections.min(b);
        Object max = Collections.max(b);
        
         
        
        
        
       double mind = Double.valueOf(min.toString());
       double maxd = Double.valueOf(max.toString());
       double Range =    maxd -mind;
        return Range;
    }
    
    
    public double groupRangeOverAll(double AllGroupRanges[]){
       
         List b = Arrays.asList(AllGroupRanges);
        Object min = Collections.min(b);
        Object max = Collections.max(b);
        
       double mind = Double.valueOf(min.toString());
       double maxd = Double.valueOf(max.toString());
       
       
        
        
        double Range =    maxd -mind;
                  
         
    
        return Range;
    }
    
    
    
    
    
    public double groupTotal(double metrics[]){
         
        double t ;
        double total =0;
        
        for(double m :metrics){
        
            total = total+m;
        }
          
                 
            t = total ;     
                 
         
    
        return t;
    }
    
    public double OverAllTotal(double allMetricsValues[]){
         
        double t ;
        double total =0;
        
        for(double m :allMetricsValues){
        
            total = total+m;
        }
          
                 
            t = total ;     
                 
         
    
        return t;
    }
    
    
    
    // Average of each TaskList
    
    public double groupAverage(double metrics[]){
         
        double a ;
        
        int n  = metrics.length ;
        double sum =0;
        
        for(double m :metrics){
        
            sum = sum+m;
        }
          
                 
            a = sum/n;     
                 
         
    
        return a;
    }
    
    //Average of all tasklist
    public double OverAllAverage(double groupAveragesofEachTaskArray[]){
    
        double a ;
        
        int n  = groupAveragesofEachTaskArray.length ;
        double sum =0;
        
        for(double m :groupAveragesofEachTaskArray){
        
            sum = sum+m;
        }
          
                 
            a = sum/n;     
                 
         System.out.println("Average Value is "+a);
    
        return a;
    
    }
    
    
    
    
}
