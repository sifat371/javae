import java.awt.Graphics2D;

/**
   Interface for moveable shapes.
*/
public interface MoveableShape
{
   void draw(Graphics2D g2);

   void move(int dx, int dy);
}
