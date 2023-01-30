import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
   This program negates a 24-bit true-color image.
 */
//ARGS desert.bmp
public class BMPImageNegater 
{

    /**
     * @param args the command line arguments
     */
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
            try (RandomAccessFile file = new RandomAccessFile(fileName,"rw")) 
            {
                int offset = 10;
                // advance the pointer to the starting position of the first pixel
                file.seek(offset);
                //compute powers of 256
                int power2 = (int)Math.pow(256,2);
                int power3 = (int)Math.pow(256,3);
                // read and calculate the position of the first pixel;
                int firstPix = file.read() + 256*file.read() + power2*file.read() + power3*file.read();
                // advance the pointer to the starting position of the width
                file.seek(18);
                // read and calculate the width of the image
                int width = file.read() + 256*file.read() + power2*file.read() + power3*file.read();
                // read and calculate the height of the image
                int height = file.read() + 256*file.read() + power2*file.read() + power3*file.read();
                //determine the number of padding bytes, if any
                int numPaddingBytes = width % 4;         
                // advance the pointer to the first pixel in the image
                file.seek(firstPix);
                int negRed,negGreen,negBlue;
                for (int row = 0; row < height; row++)
                {                
                    for (int col = 0; col < width; col++)
                    {
                        //read and negate the RGB values of this pixel
                        negRed = 255 - file.read();
                        negGreen = 255 - file.read();
                        negBlue = 255 - file.read();                    
                        // overwrite the pixels with the negated values
                        file.seek(file.getFilePointer()-3);
                        file.write(negRed);
                        file.write(negGreen);
                        file.write(negBlue);
                    }
                    // skip the padding bytes, if any
                    file.seek(file.getFilePointer()+numPaddingBytes);
                }
                file.close();
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


