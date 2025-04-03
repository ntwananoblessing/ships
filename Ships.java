import java.io.*;
import java.util.*;
public class Ships{
    public static void main (String[] args){
      Scanner scanner = new Scanner(System.in); 
      System.out.println("Enter the name of the ship data file:") ;
      String filename = scanner.nextLine();
      int pair = 1;
      //Read file
      try {
          Scanner inpStream = new Scanner(new FileInputStream(filename));
          while (inpStream.hasNextLine()){
            String line = inpStream.nextLine();
            String line2 = inpStream.nextLine();
            String[] ship1 = line.split(" ");
            String[] ship2 = line2.split(" ");

            //create the specified variables

            //ship1
             double a1 = Double.parseDouble(ship1[0]);
             double b1 = Double.parseDouble(ship1[1]);
             double c1 = Double.parseDouble(ship1[2]);
             double x1 = Double.parseDouble(ship1[3]);
             double y1 = Double.parseDouble(ship1[4]);
             //ship2
             double a2 = Double.parseDouble(ship2[0]);
             double b2 = Double.parseDouble(ship2[1]);
             double c2 = Double.parseDouble(ship2[2]);
             double x2 = Double.parseDouble(ship2[3]);
             double y2 = Double.parseDouble(ship2[4]);

             //INTERSECTION
             double xi = (b1*c2 - b2*c1)/(a1*b2 - a2*b1);
             double yi = (a2*c1 - a1*c2)/(a1*b2 - a2*b1);
             //calculations
              double distance1 = Math.sqrt((x1 - xi)*(x1 - xi) + (y1 -yi)*(y1 -yi));
              double distance2 = Math.sqrt((x2 - xi)*(x2 - xi) + (y2 -yi)*(y2 -yi));

            String output = "";
            if (Math.abs(distance1 - distance2)< 0.5 || distance1==distance2){
                output = "Tied";
            }
            
            else if (distance1 < distance2){
                output = "Ship S1 is nearest";

            }
            
            else{
                output= "Ship S2 is nearest";
            }
           System.out.printf("Pair %d: Intersection point: (%.1f, %.1f); Ship S1's distance is %.1f; Ship S2's distance is %.1f; %s.",pair,xi,yi,distance1,distance2,output);
           System.out.println("");
            pair++;
         }
         
      } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
      }
      
    }
}