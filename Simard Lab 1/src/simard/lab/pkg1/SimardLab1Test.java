package simard.lab.pkg1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SimardLab1Test {
    private Tank regular;
    private Tank premium;
    private InputStream originalIn;

    @BeforeEach
    void start() {
        originalIn = System.in;
        //Reset the tanks to some default values
        regular = new Tank(new Scanner("3.50 10.0"));
        premium = new Tank(new Scanner("4.25 20.0"));
    }
    @AfterEach
    void reset() {
        System.setIn(originalIn);
    }

    private void provideInput(String typeOfGas, String gallons) {
        //Create a variable that replicates pressing enter
        String enter = System.lineSeparator();
        //Inputtt
        System.setIn(new ByteArrayInputStream((typeOfGas + enter + gallons + enter).getBytes()));
    }

    @Test
    void performChoice1_1() {
        provideInput("r", "3.78");
        SimardLab1.PerformChoice(regular, premium, 'R');
        assertEquals(3.5, regular.GetPrice(), 0.001);
    }


    @Test
    void performChoice1_2() {
        provideInput("r", "5");
        SimardLab1.PerformChoice(regular, premium, 'A');
        assertEquals(15, regular.GetGallons(), 0.001);
    }


    @Test
    void performChoice1_3() {
        provideInput("r", "3.78");
        SimardLab1.PerformChoice(regular, premium, 'P');
        assertEquals(3.78, regular.GetPrice(), 0.001);
    }

    @Test
    void performChoice1_4() {
        provideInput("r", "100");
        SimardLab1.PerformChoice(regular, premium, 'U');
        assertEquals(100, regular.GetGallons(), 0.001);
    }

    @Test
    void performChoice1_5() {
        provideInput("r", "3.78");
        assertDoesNotThrow(() -> SimardLab1.PerformChoice(regular, premium, 'S'));
        assertEquals(3.50, regular.GetPrice(), 0.001);
    }


    @Test
    void performChoice1_6() {
        assertDoesNotThrow(() -> SimardLab1.PerformChoice(regular, premium, 'Q'));
        assertEquals(10.0, regular.GetGallons(), 0.001);
        assertEquals(3.50, regular.GetPrice(), 0.001);
    }

    @Test
    void performChoice1_a() {
        provideInput("r", "5");
        SimardLab1.PerformChoice(regular, premium, 'a');
        assertEquals(10.0, regular.GetGallons(), 0.001);
    }

    @Test
    void performChoice1_b() {
        assertDoesNotThrow(() -> SimardLab1.PerformChoice(regular, premium, 'c'));
        assertEquals(10.0, regular.GetGallons(), 0.001);
        assertEquals(3.50, regular.GetPrice(), 0.001);
    }

    /*@Test
    void performChoice1_c() {
        assertDoesNotThrow(() -> SimardLab1.PerformChoice(regular, premium, '5'));
        assertEquals(10.0, regular.GetGallons(), 0.001);
        assertEquals(3.50, regular.GetPrice(), 0.001);
    }*/

    @Test
    void performChoice1_d() {
        assertDoesNotThrow(() -> SimardLab1.PerformChoice(regular, premium, 'Q'));
        assertEquals(10.0, regular.GetGallons(), 0.001);
        assertEquals(3.50, regular.GetPrice(), 0.001);
    }

    @Test
    void performChoice1_e() {
        assertDoesNotThrow(() -> SimardLab1.PerformChoice(regular, premium, 'Z'));
        assertEquals(10.0, regular.GetGallons(), 0.001);
        assertEquals(3.50, regular.GetPrice(), 0.001);
    }

    /*@Test
    void performChoice1_c() {
        assertDoesNotThrow(() -> SimardLab1.PerformChoice(regular, premium, ''));
        assertEquals(10.0, regular.GetGallons(), 0.001);
        assertEquals(3.50, regular.GetPrice(), 0.001);
    }*/

    @Test
    void addGas1_1() {
        provideInput("r", "100000");
        SimardLab1.AddGas(regular, premium);
        assertEquals(100000, regular.GetGallons(), 0.001);
    }

    @Test
    void addGas1_2() {
        provideInput("r", "0");
        SimardLab1.AddGas(regular, premium);
        assertEquals(10, regular.GetGallons(), 0.001);
    }

    @Test
    void addGas1_a() {
        provideInput("r", "-15.4");
        SimardLab1.AddGas(regular, premium);
        assertEquals(10.0, regular.GetGallons(), 0.001);
    }

    @Test
    void addGas1_b() {
        provideInput("r", "dog");
        assertDoesNotThrow(() -> SimardLab1.AddGas(regular, premium));
        assertEquals(15.0, regular.GetGallons(), 0.001);
    }

    @Test
    void addGas1_c() {
        provideInput("r", "");
        assertDoesNotThrow(() -> SimardLab1.AddGas(regular, premium));
        assertEquals(10.0, regular.GetGallons(), 0.001);
    }

    @Test
    void addGas1_d() {
        provideInput("r", "100001");
        SimardLab1.AddGas(regular, premium);
        assertEquals(10.0, regular.GetGallons(), 0.001);
    }

    @Test
    void setPrice1_1(){
        provideInput("r", "4.48");
        SimardLab1.SetPrice(regular, premium);
        assertEquals(4.48, regular.GetPrice(), 0.001);
    }

    @Test
    void setPrice1_2(){
        provideInput("r", "0");
        SimardLab1.SetPrice(regular, premium);
        assertEquals(0, regular.GetPrice(), 0.001);
    }

    @Test
    void setPrice1_a(){
        provideInput("r", "-4.4");
        SimardLab1.SetPrice(regular, premium);
        assertEquals(3.50, regular.GetPrice(), 0.001);
    }

    @Test
    void setPrice1_b(){
        provideInput("r", "dog");
        assertDoesNotThrow(() -> SimardLab1.SetPrice(regular, premium));
        assertEquals(3.5, regular.GetPrice(), 0.001);
    }

    @Test
    void setPrice1_c(){
        provideInput("r", "15.5");
        SimardLab1.SetPrice(regular, premium);
        assertEquals(3.5, regular.GetPrice(), 0.001);
    }

    @Test
    void setPrice1_d(){
        provideInput("r", "");
        assertDoesNotThrow(() -> SimardLab1.SetPrice(regular, premium));
        assertEquals(3.5, regular.GetPrice(), 0.001);
    }

    @Test
    void updateGallons1_1() {
        //Our forced input
        provideInput("r", "100000");
        //Standard function call with the class name.
        SimardLab1.UpdateGallons(regular, premium);
        //Input was r 100000, so because it overrides the previous value,
        //we expect the reguler.GetGallons to be 100000
        assertEquals(100000, regular.GetGallons(), 0.001);
    }

    @Test
    void updateGallons1_2(){
        provideInput("r", "0");
        SimardLab1.UpdateGallons(regular, premium);
        assertEquals(0, regular.GetGallons(), 0.001);
    }

    //FAIL. It is storing the negative value.
    @Test
    void updateGallons1_a(){
        provideInput("r", "-15.4");
        SimardLab1.UpdateGallons(regular, premium);
        assertEquals(10, regular.GetGallons(), 0.001);
    }

    @Test
    void updateGallons1_b(){
        provideInput("r", "dog");
        assertDoesNotThrow(() -> SimardLab1.UpdateGallons(regular, premium));
        assertEquals(10, regular.GetGallons(), 0.001);
    }

    @Test
    void updateGallons1_c(){
        provideInput("r", "");
        assertDoesNotThrow(() -> SimardLab1.UpdateGallons(regular, premium));
        assertEquals(10, regular.GetGallons(), 0.001);
    }

    @Test
    void updateGallons1_d(){
        provideInput("r", "100001");
        SimardLab1.UpdateGallons(regular, premium);
        assertEquals(10, regular.GetGallons(), 0.001);
    }



    @Test
    void sell1_2() {
        provideInput("r", "10");
        SimardLab1.Sell(regular, premium);
        assertEquals(0.0, regular.GetGallons(), 0.001);
    }

    @Test
    void updateGals1_1() {
        Tank t = new Tank(new Scanner("4.00 250.0"));
        assertEquals(100.0, t.UpdateGals(100.0), 0.001);
    }
    @Test
    void updateGals1_2() {
        Tank t = new Tank(new Scanner("4.00 250.0"));
        assertEquals(0.0, t.UpdateGals(0.00), 0.001);
    }

    @Test
    void updateGals1_a() {
        Tank t = new Tank(new Scanner("4.00 250.0"));
        assertEquals(250, t.UpdateGals(-12.1), 0.001);
    }
    @Test
    void updateGals1_d() {
        Tank t = new Tank(new Scanner("4.00 250.0"));
        assertEquals(0, t.UpdateGals(101.0), 0.001);
    }

}