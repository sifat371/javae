//ARGS mary1.txt mary2.txt
/**
   Counts how many words in a file.
*/
public class WordCount extends Thread
{
    public static void main(String argv[])
    {
        for (int i = 0; i < argv.length; i++)
        {
            WordCountRunnable wcr = new WordCountRunnable(argv[i]);
            Thread t = new Thread(wcr);
            t.start();
        }
    }
}
