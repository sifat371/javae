import java.io.IOException;
import java.nio.file.Files;
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
       // swap only if the files have different paths and both exists
       if (!p.getParent().equals(q.getParent()) && Files.exists(p) && Files.exists(q))
       {
          String prefix = "tempFile";
          String extension = ".tmp";
          Path tempFile = Files.createTempFile(prefix,extension);
          Path tempDir = Files.createTempDirectory(prefix);
          tempFile = tempDir.resolve(tempFile.getFileName());
          Path tempPath = tempDir.resolve(tempFile);       
          Path path1 = p.getParent().resolve(q.getFileName());
          Path path2 = q.getParent().resolve(p.getFileName());
          Files.copy(p,tempPath);
          Files.delete(p);
          Files.copy(q,path1);
          Files.delete(tempPath);
          Files.copy(q,tempPath);
          Files.delete(q);
          Files.copy(tempPath,path2);
       }
    }      
}
