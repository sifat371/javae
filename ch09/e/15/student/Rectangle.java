//HIDE
/**
   Replacement for java.awt.Rectangle for this
   particular problem. Makes sure that students
   do not use setSize() or setLocation() to
   complete this problem, when they are supposed
   to invoke the superclass construtor.
*/
public class Rectangle extends java.awt.Rectangle
{
   public Rectangle() { super(); }
   public Rectangle(int x, int y, int w, int h) { super(x, y, w, h); }
   public void setLocation(int x, int y) {
      System.out.println("X Cannot use setLocation for this problem.");
   }
   public void setSize(int w, int h) {
      System.out.println("X Cannot use setSize for this problem.");
   }
}
