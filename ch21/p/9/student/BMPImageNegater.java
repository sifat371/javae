import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
   This program negates a 24-bit true-color image.
 */
 //OUT image.bmp
public class BMPImageNegater 
{
    public static void main(String[] args) 
    {
        String fileName;
        if (args.length != 1)
        {
            System.out.println("Usage: java BMPImageNegater BMP24BitTrueColorFile");
        }
        else
        {
            fileName = args[0];            
            try (...) 
            {
               ...
            }          
            catch(FileNotFoundException e)
            {
               System.out.println(e);
            }
            catch(IOException e)
            {
               System.out.println(e);
            }        
        }
    }
    
}


