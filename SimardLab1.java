package simard.lab.pkg1;

import java.util.Scanner;
import java.io.*;
import java.io.PrintWriter; 


public class SimardLab1 {

    public static void main(String[] args) throws IOException{
        //***********************************Variables**************************
        char choice;
     
        File tFile;
        Scanner tFileSC;
        PrintWriter tFilePW;
        Tank regular;
        Tank premium;
        
        tFile = new File ("tFile.txt");
        tFileSC = new Scanner (tFile);
        
        regular = new Tank(tFileSC);
        premium = new Tank(tFileSC);
        
        tFileSC.close();
        
        tFilePW = new PrintWriter (tFile);
        
        choice = 'y';
        while (choice != 'Q'){
            //***********************************Get Choice*********************
            choice = GetChoice();
            
            //***********************************Perform Choice*****************
            PerformChoice(regular, premium, choice); 
                
        }
        
        //***********************************Save Info**************************
        //tFilePW.println(regular.GetGallons()); //To confirm the printwriter works in main. (Had an error giving me issues for the class)
        regular.SaveInfo(tFilePW);
        premium.SaveInfo(tFilePW);
        tFilePW.close();
    }
    
    public static char GetChoice (){
        Scanner kbd = new Scanner(System.in);
        char choice;
        
        System.out.println("Please enter your choice as listed below or enter Q (case sensitive) to end the program.");
        System.out.println("R = Return Tank Status");
        System.out.println("A = Add Gas");
        System.out.println("P = Set Price");
        System.out.println("U = Update Gallons");
        System.out.println("S = Sell");
        
        choice = kbd.nextLine().charAt(0);
        
        return choice;
    }
    
    public static void PerformChoice (Tank regular, Tank premium, char choice){
        //*******************************Return Tank Status*************
        if(choice == 'R' || choice == 'r')
            ReturnTankStatus (regular, premium);
        //*******************************Add Gas************************
        else if (choice == 'A'|| choice == 'a')
            AddGas (regular, premium);
        //*******************************Set Price**********************
        else if (choice =='P'|| choice == 'p')
            SetPrice (regular, premium);
        //*******************************Update Gallons*****************
        else if (choice == 'U'|| choice == 'u')
            UpdateGallons (regular, premium);
        //*******************************Sell***************************
        else if (choice == 'S'|| choice == 's')
            Sell (regular, premium);
        else
            System.out.println("Please re-enter your choice or enter Q (case sensitive) to terminate the program.");
    }
    
    public static void ReturnTankStatus (Tank regular, Tank premium){
        System.out.println("The price of regular gas per gallon is: " + regular.GetPrice());
        System.out.println("The number of regular gallons is: " + regular.GetGallons());
            
        System.out.println("The price of premium gas per gallon is: " + premium.GetPrice());
        System.out.println("The number of premium gallons is: " + regular.GetGallons());   
    }
    
    public static void AddGas (Tank regular, Tank premium){
        char gas;
        double amount;
        
        Scanner kbd = new Scanner(System.in);
        gas = 'x';
        
        while (gas != 'r' && gas != 'p'){
        System.out.println("Please enter the type of gas (regular (r) premium (p)) to be added: ");
        gas = kbd.nextLine().charAt(0);
        }
        
        System.out.println("Please enter the amount of gas to be added: ");
        amount = kbd.nextDouble();
        
        //System.out.println("Regular before  " + regular.GetGallons()); //Validation gallons is getting updated.
        //System.out.println("Premium before  " + premium.GetGallons()); //Validation gallons is getting updated.
        if (gas == 'r' || gas == 'R')
            regular.AddGal(amount);
        else if (gas == 'p' || gas == 'P')
            premium.AddGal(amount);
        //System.out.println("Regular after  " + regular.GetGallons()); //Validation gallons is getting updated.
        //System.out.println("Premium after  " + premium.GetGallons()); //Validation gallons is getting updated.
        
    }
    
    public static void SetPrice (Tank regular, Tank premium){
        char gas;
        double price;
        
        Scanner kbd = new Scanner(System.in);
        gas = 'x';
        
        while (gas != 'r' && gas != 'p' && gas != 'R' && gas != 'P'){
        System.out.println("Please enter the type of gas (regular (r) premium (p)) to have their price altered: ");
        gas = kbd.nextLine().charAt(0);
        }
        
        System.out.println("Please enter the new price per gallon: ");
        price = kbd.nextDouble();
        
        //System.out.println("Regular before  " + regular.GetPrice()); //Validation price is getting updated.
        //System.out.println("Premium before  " + premium.GetPrice()); //Validation price is getting updated.
        if (gas == 'r' || gas == 'R')
            regular.SetPrice(price);
        else if (gas == 'p' || gas == 'P')
            premium.SetPrice(price);
        //System.out.println("Regular after  " + regular.GetPrice()); //Validation price is getting updated.
        //System.out.println("Premium after  " + premium.GetPrice()); //Validation price is getting updated.
        
    }
    
    public static void UpdateGallons (Tank regular, Tank premium){
        char gas;
        double amount;
        
        Scanner kbd = new Scanner(System.in);
        gas = 'x';
        
        while (gas != 'r' && gas != 'p'){
        System.out.println("Please enter the type of gas (regular (r) premium (p)) to be updated: ");
        gas = kbd.nextLine().charAt(0);
        }
        
        System.out.println("Please enter the number of gallons stored: ");
        amount = kbd.nextDouble();
        
        //System.out.println("Regular before  " + regular.GetGallons()); //Validation gallons is getting updated.
        //System.out.println("Premium before  " + premium.GetGallons()); //Validation gallons is getting updated.
        if (gas == 'r' || gas == 'R')
            regular.SetGallons(amount);
        else if (gas == 'p' || gas == 'P')
            premium.SetGallons(amount);
        //System.out.println("Regular after  " + regular.GetGallons()); //Validation gallons is getting updated.
        //System.out.println("Premium after  " + premium.GetGallons()); //Validation gallons is getting updated.
        
    }
    
    public static void Sell (Tank regular, Tank premium){
        char gas;
        double amount, totalCost;
        
        Scanner kbd = new Scanner(System.in);
        gas = 'x';
        
        while (gas != 'r' && gas != 'p'){
        System.out.println("Please enter the type of gas (regular (r) premium (p)) to be sold: ");
        gas = kbd.nextLine().charAt(0);
        }
        
        System.out.println("Please enter the amount of gas to be sold: ");
        amount = kbd.nextDouble();
        
        System.out.println("Gallons Requested: " + amount);
        
        //System.out.println("Regular before  " + regular.GetGallons()); //Validation gallons is getting updated.
        //System.out.println("Premium before  " + premium.GetGallons()); //Validation gallons is getting updated.
        if (gas == 'r' || gas == 'R'){
            regular.UpdateGals(amount);
            System.out.println("Amount Dispensed: " + regular.UpdateGals(amount));
            totalCost = regular.GetPrice() * regular.UpdateGals(amount);
            System.out.println("Total Sale Cost: " + totalCost);
        }
        else if (gas == 'p' || gas == 'P'){
            premium.UpdateGals(amount);
            System.out.println("Amount Dispensed: " + premium.UpdateGals(amount));
            totalCost = premium.GetPrice() * premium.UpdateGals(amount);
            System.out.println("Total Sale Cost: " + totalCost);
        }
        //System.out.println("Regular after  " + regular.GetGallons()); //Validation gallons is getting updated.
        //System.out.println("Premium after  " + premium.GetGallons()); //Validation gallons is getting updated.
    }
}