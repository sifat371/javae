
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Given a city name, identify all airports within that city by searching
 * https://raw.githubusercontent.com/jpatokal/openflights/master/data/airports.dat
 * It is VERY important that once you download this file that you remove
 * non-ascii characters (ones not in the range 0-127). This can be done by the
 * following bit of Linux code: tr -dc '\0-\177' <airports.dat > air.dat; mv
 * air.dat airports.dat
 */
public class AirportData
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("This program lists all airports in a city");
        File infile = new File("airports.dat");

        Scanner stdin = new Scanner(System.in);
        System.out.print("City (ENTER to stop):");
        while (stdin.hasNextLine())
        {
            String cityName = stdin.nextLine();
            if (cityName.equals(""))
            {
                break;
            }

            // Search for cityName in input file

            Scanner in = new Scanner(infile);
            while (in.hasNextLine())
            {
                String line = in.nextLine();
                /*
                   The format of each line is
                      idnumber,"Airport Name","City Name", ...
                   There are no commas in the the airport of city name fields
                   Below a double quote is used as the delimiter.
                */

                Scanner scanner = new Scanner(line);

                scanner.useDelimiter("\"");
                String idNumber = scanner.next();  // skip id
                String airport = scanner.next();

                String comma = scanner.next();  // Skip comma
                String city = scanner.next();

                if (city.equalsIgnoreCase(cityName))
                {
                    System.out.println(city + ": " + airport);
                }

            }
            in.close();
            System.out.print("City (ENTER to stop):");
        }
    }

} 

