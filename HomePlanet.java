import java.lang.Math; 
import java.util.*;


public class HomePlanet extends Universe {

	// driver code 
    public static void main(String args[]) 
    { 
        // Generate random number 
        double rand = Math.random(); 
        Random randomno = new Random();
  
        // Output is different everytime this code is executed 
        System.out.println("Random Position:" + rand); 
        System.out.println("Next int value: " + randomno.nextInt(20*30));
    } 
}
