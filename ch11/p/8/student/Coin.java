import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
   A coin with a monetary value.
*/
public class Coin
{
   private double value;
   private String name;

   /**
      Constructs a default coin. Use the read method to fill in the value and name.
   */
   public Coin()
   {
      value = 0;
      name = "";
   }

   /**
      Constructs a coin.
      @param aValue the monetary value of the coin
      @param aName the name of the coin
   */
   public Coin(double aValue, String aName) 
   { 
      value = aValue; 
      name = aName;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public double getValue() 
   {
      return value;
   }

   /**
      Gets the coin name.
      @return the name
   */
   public String getName() 
   {
      return name;
   }

   /**
      Reads a coin value and name.
      @param in the Scanner
   */
   public void read(Scanner in) throws IOException
   {
      . . .
   }
   
   /**
      Reads a file with coin values.
      @param filename the file name
      @return an array of coins in the file
   */
   public static ArrayList<Coin> readFile(String filename) throws IOException
   {
      . . .
   }
}