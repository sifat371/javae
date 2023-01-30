//HIDE
import java.lang.reflect.*;
import java.util.*;
public class BetterRectangleTester
{
   public static void main(String[] args) throws Exception
   {
      Class<?> kls = BetterRectangle.class;
      String methods = Arrays.toString(kls.getDeclaredMethods());
      String constructors = Arrays.toString(kls.getConstructors());

      System.out.println("Testing declarations . . .");
      boolean ctorOK = constructors.contains("public BetterRectangle(int,int,int,int)");
      boolean getPerimeterOK = methods.contains("public double BetterRectangle.getPerimeter()");
      boolean getAreaOK = methods.contains("public double BetterRectangle.getArea()");
      boolean superOK = kls.getSuperclass().toString().contains("Rectangle");

      System.out.println("Created: " + kls);
      System.out.println("Expected: class BetterRectangle");
      System.out.println("Correct superclass: " + superOK);
      System.out.println("Expected: true");
      System.out.println("Constructor correctly declared: " + ctorOK);
      System.out.println("Expected: true");
      System.out.println("getPerimeter declared correctly: " + getPerimeterOK);
      System.out.println("Expected: true");
      System.out.println("getArea declared correctly: " + getAreaOK);
      System.out.println("Expected: true");
      System.out.println("Field count: " + kls.getDeclaredFields().length);
      System.out.println("Expected: 0");
      // Constructor OK, let's test it
      Object o = null;
      if (ctorOK)
      {
         System.out.println("\nTesting constructor . . .");
         o = kls
            .getDeclaredConstructor(int.class, int.class, int.class, int.class)
            .newInstance(2, 3, 15, 17);
         Object actual = kls.getMethod("getX", new Class[]{})
            .invoke(o, new Object[]{});
         System.out.println("Sets x: " + actual);
         System.out.println("Expected: 2.0");
         actual = kls.getMethod("getY", new Class[]{})
            .invoke(o, new Object[]{});
         System.out.println("Sets y: " + actual);
         System.out.println("Expected: 3.0");
         actual = kls.getMethod("getWidth", new Class[]{})
            .invoke(o, new Object[]{});
         System.out.println("Sets width: " + actual);
         System.out.println("Expected: 15.0");
         actual = kls.getMethod("getHeight", new Class[]{})
            .invoke(o, new Object[]{});
         System.out.println("Sets height: " + actual);
         System.out.println("Expected: 17.0");
      }

      // Now, test the methods
      if (o != null)
      {
         System.out.println("\nTesting methods . . .");
         Object actual = kls.getMethod("getArea", new Class[]{})
            .invoke(o, new Object[]{});
         System.out.println("Calling getArea: " + actual);
         System.out.println("Expected: 255.0");
         actual = kls.getMethod("getPerimeter", new Class[]{})
            .invoke(o, new Object[]{});
         System.out.println("Calling getPerimeter: " + actual);
         System.out.println("Expected: 64.0");

      }

   }
}
