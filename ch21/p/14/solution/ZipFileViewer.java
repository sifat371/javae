import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;

/**
   This program uses a zip file system to open a zip file and show the names and the first ten lines of all
   files in it.
 */
public class ZipFileViewer 
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the full path for the zip file> ");
      Path path = Paths.get(input.next());
      deepZipView(path,"./"+path);              
   }
   /**
      Traverses a path with the same parent and displays the first ten lines of 
      every file.
      @param path a zip file path
      @param parent the parent of the path
    */
   public static void deepZipView(Path path, String parent)
   {
       final int MAX_LINES = 10;
       try(FileSystem zipfs = FileSystems.newFileSystem(path,null);Stream<Path> srcZip = Files.walk(zipfs.getPath("/")))
       {
          List<Path> paths = srcZip.collect(Collectors.toList());
          for (int i=0; i<paths.size(); i++)
          {
              Path p = paths.get(i);
              if (Files.isDirectory(p))
              {
                  //only display the path of the directory
                  System.out.printf("%s%s%n",parent,p);
              }
              else  if (p.toString().endsWith(".zip"))
              {
                  //copy the nested zip file to a temporary file
                  System.out.printf("%s%s%n",parent,p); 
                  String prefix = "tempFile";
                  String extension = ".tmp";
                  Path tempFile = Files.createTempFile(prefix,extension);
                  Path tempDir = Files.createTempDirectory(prefix);
                  tempFile = tempDir.resolve(tempFile.getFileName());
                  Path tempPath = tempDir.resolve(tempFile);    
                  Files.copy(p,tempPath);
                  //recursively create a new file system for the zip file;
                  deepZipView(tempPath,parent+p);   
              }
              else
              {
                  //print the first 10 lines of the regular file
                  System.out.printf("%s%s%n",parent,p);
                  Stream<String> lines = Files.lines(p);
                  List<String> result = lines
                           .limit(MAX_LINES)
                           .collect(Collectors.toList());
                  for (String aLine : result)
                     System.out.println(aLine);
                  System.out.println();
              }
          }
        }
        catch(IOException e)
        {
           System.out.println(e);
        }
    }  
}   

