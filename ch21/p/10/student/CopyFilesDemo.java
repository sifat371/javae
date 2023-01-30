import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
  This program tests the copyFiles method
 */
public class CopyFilesDemo
{
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the source path -> ");
        Path fromDir = Paths.get(cin.next());
        System.out.print("Enter the destination path -> ");
        Path toDir = Paths.get(cin.next());
        try 
        {
            copyFiles(fromDir,toDir);
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }
    }
    
    /**
      This method copies all files (but none of the directories) from
      one directory to another.
      @param fromDir the source directory
      @param toDir the destination directory
     */
    public static void copyFiles(Path fromDir, Path toDir) throws IOException
    {
        //Complete this method
    }    
}