import java.util.Scanner;

public class MultiChoiceDemo
{
   public static void main(String[] args)
   {
      ChoiceQuestion q = new MultiChoiceQuestion();
      q.setText("Which programming languages use { } for blocks?");
      q.addChoice("Java", true);
      q.addChoice("Python", false);
      q.addChoice("C++", true);
      q.addChoice("Scheme", false);

      presentQuestion(q);

      ChoiceQuestion q2 = new MultiChoiceQuestion();

      q2.setText("Which of these classes implement the Comparable interface?");
      q2.addChoice("java.lang.String", true);
      q2.addChoice("java.util.ArrayList", false);
      q2.addChoice("java.util.Scanner", false);
      q2.addChoice("java.io.File", true);
      
      presentQuestion(q2);
   }

   public static void presentQuestion(Question q)
   {
      q.display();
      System.out.print("Your answer: ");
      Scanner in = new Scanner(System.in);
      String response = in.nextLine();
      System.out.println(q.checkAnswer(response));
   }
}
