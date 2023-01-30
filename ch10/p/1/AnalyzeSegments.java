
import java.util.stream.IntStream;

/**
 * Implement a class called Segment which provides a starting and ending
 * index for a string. Segment should implement the CharSequence interface which
 * provides read-only access to a sequence of characters. Demonstrate that
 * Segment objects are manipulable by methods that accept CharSequence objects
 */

/**
 * Segment implements an indirect reference to string of characteres
 */
class Segment implements CharSequence
{
   
    private String data;// The string referenced
    private int start;  // The starting index within data of the string referenced by this Segmen
    private int end;    // The ending index within data of the string  referenced by this Segment

    /**
     * Create a Segment
     * @param data the data referenced by the Segment
     * @param start the starting point of the data (inclusive)
     * @param end the ending point of the data (exclusive)
     */
    Segment(String data, int start, int end)
    {
        this.data = data;
        this.start = start;
        if (end > data.length())
        {
            end = data.length();
        }
        this.end = end;

    }

    /**
     * 
     * @return the length of the Segment
     */
    @Override
    public int length()
    {
        return end - start;
    }
/**
 * @param pos
 * @return the character at location pos within the Segment
 */
    @Override
    public char charAt(int pos)
    {
        if (pos < 0 || pos > length())
        {
            throw new IndexOutOfBoundsException();
        }
        return data.charAt(start + pos);
    }

    /**
     * @param start the starting position (inclusive) of the sub-sequence
     * @param end the ending position (exclusive) of the sub-sequence
     * @return the sub-sequence starting at start and ending just before end
     */
    @Override
    public CharSequence subSequence(int start, int end)
    {
        if (start < 0 || end > length())
        {
            throw new IndexOutOfBoundsException();
        }
        Segment segment = new Segment(data, this.start + start, this.start + end);
        return segment;
    }

    /**
     * @return the string referenced by the bounds of Segment
     */
    @Override
    public String toString()
    {
        return data.substring(start, end);
    }
}

public class AnalyzeSegments
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println ("This program constructs a book and provides access to it");
        System.out.println ("via Segement's, which reference a portion of the book\n");
        String book = " 0 1 2 3 4 5 6 7 8 910111213141516171819";
        Segment fullbook = new Segment(book, 0, 40);
        System.out.println("Full book" + fullbook);
        Segment segment = new Segment(book, 0, 20);
        System.out.println("First half of book: " + segment);
        segment = new Segment(book, 20, 40);
        System.out.println("Second half of book: " + segment);

        // Using subSequence
        CharSequence firstHalf = fullbook.subSequence(0, 20);
        System.out.println("First half of book: " + firstHalf);
        CharSequence secondHalf = fullbook.subSequence(20, 40);
        System.out.println("Second half of book: " + segment);

        // Checking charAt and length
        System.out.print("First half of book: ");
        for (int i = 0; i < firstHalf.length(); i++)
        {
            System.out.print(firstHalf.charAt(i));
        }
        System.out.println("");
        System.out.print("Second half of book: ");
        for (int i = 0; i < secondHalf.length(); i++)
        {
            System.out.print(secondHalf.charAt(i));
        }
        System.out.println("");

        // Demonstrate that join works with Segments
        System.out.println ("Demonstrating join works");
        System.out.println(String.join("XXXXX", firstHalf, secondHalf));

        System.out.println ("Demonstrating append works");
        // Demonstratie PrintSteam.append works with Segments
        System.out.print(firstHalf);
        System.out.print("-----");
        System.out.println(secondHalf);
    }

}

