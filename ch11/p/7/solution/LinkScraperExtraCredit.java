import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;

/**
   This program reads all data from a web page and prints all 
   hyperlinks of the form <a href="link">link text</a> and all valid 
   hyperlinks for those links.  Note it does not follow relative URLs, 
   only absolute.
*/
public class LinkScraperExtraCredit
{
   /**
      This method scans input searching for hyperlinks.  It returns the 
      first complete hyperlink it finds.  If the end of input is 
      encountered it returns null.
      @param in the scanner to read from
      @return the next hyperlink encountered or null if end of input is 
      encountered
   */
   public static String nextHyperlink(Scanner in)
   {
      in.useDelimiter("<a href=\"");
      if (in.hasNext())
      {
         String before = in.next();
         in.useDelimiter("\">");
         if (in.hasNext())
         {
            String link = in.next();
            in.useDelimiter("</a>");
            String linkText = in.next();
            return link + linkText + "</a>";
         }
      }
      return null;
   }

   /**
      This method scans input searching for hyperlinks.  It returns the first
      complete url it finds.  If the end of input is encountered it
      returns null.
      @param in the scanner to read from
      @return the next url encountered or null if end of input is encountered
   */
   public static String nextURL(Scanner in)
   {
      in.useDelimiter("<a href=\"");
      if (in.hasNext())
      {
         String before = in.next();
         in.useDelimiter("\">");
         if (in.hasNext())
         {
            String link = in.next();
            in.useDelimiter("</a>");
            String linkText = in.next();
            return link.substring(9);
         }
      }
      return null;
   }

   /**
      Scrapes the scanner input for valid URLs.
      @param in the scanner
      @return an array list of all valid URLs.
   */
   public static ArrayList<String> getURLs(Scanner in)
   {
      ArrayList<String> urls = new ArrayList<String>();
      String link = nextURL(in);
      while (link != null)
      {
         urls.add(link);
         link = nextURL(in);
      }
      return urls;
   }

   /**
      Prints all valid hyperlinks given a url.
      @param url the url to visit
   */
   public static void printAllHyperlinks(String url)
   {
      URL locator;
      try
      {
         locator = new URL(url);
         try (Scanner in = new Scanner(locator.openStream()))
         {
            String link = nextHyperlink(in);
            while (link != null)
            {
               System.out.println(link);
               link = nextHyperlink(in);
            }
         }
         catch (IOException e)
         {
            System.out.println("IO Exception!");
         }
      } 
      catch (MalformedURLException e)
      {
         System.out.println("Invalid URL.");
      } 
   }

   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      System.out.println("Enter the url to scan: ");
      String url = console.nextLine();
   
      URL locator;
      try
      {
         locator = new URL(url);
         try (Scanner in = new Scanner(locator.openStream()))
         {
            ArrayList<String> urls = getURLs(in);
            urls.add(url);
            for (String x : urls)
            {
               printAllHyperlinks(x);
            }
         }
         catch (IOException e)
         {
            System.out.println("IO Exception!");
         }
      } 
      catch (MalformedURLException e)
      {
         System.out.println("Invalid URL.");
      }   
   }
}
