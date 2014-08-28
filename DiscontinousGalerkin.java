package discontinousgalerkin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DiscontinousGalerkin {
 
    public static void main(String[] args) {
    
        
        System.out.println("******************************");
        System.out.println("Discontinuous Galerkin Solver");
        System.out.println("******************************");
    
// read in the input data file
         //ReadInputFile();
// Initialisation
// Time Marching
// Outputfile         
MyMethods bg = new MyMethods();
bg.print();

    }
    


   public static void ReadInputFile() {
   
       int ParameterData[];
       ParameterData  = new int[4];
       int iNode,iOrder,iRK, iTestCase;
       int kk;
       
       try{
            FileReader fr = new FileReader("Input.par");
            BufferedReader br = new BufferedReader(fr);
            
            String str;
            kk=0;
            // loop until the end of the file
            while((str = br.readLine()) !=  null){
            
            // check if the string is of numeric type    
            boolean TF = isNumeric(str); 
            
            if(TF == true){
             
             int i = Integer.parseInt(str);      
                ParameterData[kk] = i;
                kk = kk +1;
                }
            }
            br.close();
            
            
               // copy the array of parameters to integer  
   iOrder = ParameterData[0];
   iRK = ParameterData[1];
   iNode = ParameterData[2];
   iTestCase = ParameterData[3];
   
// define these integers as constants  
   final int IORDER = iOrder;
   final int IRK = iRK;
   final int INODE = iNode;
   final int ITESTCASE = iTestCase;
       } 
       catch (IOException e){
           System.out.println("Input file not found");
         }
   }
   
   public static boolean isNumeric(String StringIn){  
  try {  
    int d = Integer.parseInt(StringIn);  
  }  
  catch(NumberFormatException nfe){  
    return false;  
  }  
  return true;  
    }
}


