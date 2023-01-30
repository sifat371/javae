import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
   Tests a method that swaps two files.
 */
public class FileSwapperDemo 
{
    public static void main(String[] args) 
    {
        try
        {
            Scanner cin = new Scanner(System.in);
            System.out.print("Enter the full path of the first file ->");
            String firstFile = cin.next();
            System.out.print("Enter the full path of the second file ->");
            String secondFile = cin.next();
            swapPaths(Paths.get(firstFile),Paths.get(secondFile));
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    /**
      Swaps the paths of two files.
      @param p a file path
      @param q a file path
    */
    public static void swapPaths(Path p, Path q) throws IOException
    {
       //Complete this method
    }      
}
