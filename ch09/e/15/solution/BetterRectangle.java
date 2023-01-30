import java.awt.*;
/**
   The java.awt.Rectangle class of the standard Java library
   does not supply a method to compute the area or perimeter
   of a rectangle. Provide a subclass BetterRectangle of
   the Rectangle class that has getPerimeter and getArea methods.

   Do not add any instance variables.

   In the constructor, DO NOT call the setLocation and setSize
   methods of the Rectangle class but invoke the superclass
   constructor instead.
*/
public class BetterRectangle extends Rectangle
{
   /**
      Constructs a new rectangle whose upper-left corner is specified as x,y)
      and whose width and height are specified by the arguments of the same name.
      @param x the specified X coordinate
      @param y the specified Y coordinate
      @param width the width of the Rectangle
      @param height the height of the Rectangle
   */
   public BetterRectangle(int x, int y, int width, int height)
   {
      super(x, y, width, height);
   }

   /**
      Calculates the perimeter of the rectangle.
      @return the perimeter of the rectangle
   */
   public double getPerimeter()
   {
      return getHeight() * 2 + getWidth() * 2;
   }

   /**
      Calculates the area of the rectangle.
      @return the area of the rectangle
   */
   public double getArea()
   {
      return getHeight() * getWidth();
   }
}
