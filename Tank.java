package simard.lab.pkg1;

import java.util.Scanner;
import java.io.PrintWriter;


public class Tank {
 
    private double gallons;
    private double price;
    
    public Tank (Scanner tFileSC){
        price = tFileSC.nextDouble();
        gallons = tFileSC.nextDouble();
        
    }

    public void SetPrice(double newPrice) {
        price = newPrice;
        
    }
    
    public void SetGallons(double newGallons) {
        gallons = newGallons;
    }
    
    public void AddGal(double galAdded) {
        gallons = gallons + galAdded;
    }
    
    public double UpdateGals(double galSold) {
        double gallonsActuallySold;
        gallonsActuallySold = 0;
        
        if(galSold < gallons)
            gallonsActuallySold = galSold;
        else
            gallonsActuallySold = gallons;
        
        return gallonsActuallySold;
    }
    
    public double GetGallons( ) {
        return gallons;
    }
    
    public double GetPrice( ) {
        return price;
    }
    
    public void SaveInfo (PrintWriter tFilePW) {
        tFilePW.println(price);
        tFilePW.println(gallons);
        
}

}
