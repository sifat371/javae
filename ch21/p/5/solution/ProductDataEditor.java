import java.io.IOException;
import java.util.Scanner;

/**
   This program edits a random access file of product data.
   
*/
public class ProductDataEditor
{  
   public static void main(String[] args)
         throws IOException
   {  
      Scanner in = new Scanner(System.in);
      ProductData data = new ProductData();
      try
      {  
         data.open("product.dat");
         Product currentProduct = null;
         int currentProductIndex = -1;
         boolean done = false;
         while (!done)
         {  
            System.out.print("A)dd record  F)ind record  Change P)rice  Change Q)uantity  E)xit: ");
            String command = in.next().toUpperCase();
            if (command.equals("A"))
            {
               System.out.print("Name: ");
               in.nextLine(); 
               String name = in.nextLine();
               System.out.print("Price: ");
               double price = in.nextDouble();
               System.out.print("Quantity: ");
               int quantity = in.nextInt();
               currentProductIndex = data.size();
               currentProduct = new Product(name, price, quantity);
               data.write(currentProductIndex, currentProduct);
            }
            else if (command.equals("F"))
            {
               System.out.print("Name: ");
               in.nextLine(); 
               String name = in.nextLine();
               currentProductIndex = data.find(name);
               if (currentProductIndex == -1)
                  System.out.println("no product selected");
               else
               {
                  currentProduct = data.read(currentProductIndex);
                  System.out.println("Price: " + currentProduct.getPrice());
                  System.out.println("Quantity: " + currentProduct.getQuantity());
               }
            }
            else if (command.equals("P"))
            {
               if (currentProductIndex == -1)
                  System.out.println("no product selected");
               else
               {
                  System.out.print("New price: ");
                  double price = in.nextDouble();
                  currentProduct.setPrice(price);
                  data.write(currentProductIndex, currentProduct);
               }
            }
            else if (command.equals("Q"))
            {
               if (currentProductIndex == -1)
                  System.out.println("no product selected");
               else
               {
                  System.out.print("New quantity: ");
                  int quantity = in.nextInt();
                  currentProduct.setQuantity(quantity);
                  data.write(currentProductIndex, currentProduct);
               }
            }
            else if (command.equals("E"))
            {
               done = true;
            }
         }
      }
      finally
      {
         data.close();
      }
   }
}
