import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
  This program test the clearDirectory method
 */
public class ClearAllDirectoriesDemo
{
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the directory path -> ");
        Path dir = Paths.get(cin.next());
        try 
        {
            clearAllDirectories(dir);
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }
    }
    
    /**
       This method removes all files and subdirectories from a directory
       @param dir the directory
    */
    public static void clearAllDirectories(Path dir) throws IOException
    {
        //Complete this method
    }
}