//HIDE
/**
 * Check to see that toString() has been defined for the Question and
 * ChoiceQuestion classes.
 */
public class QuestionTester
{
   public static void main(String[] args) throws Exception
   {
      Question q = new Question("Who was the inventor of Java?");
      Class<?> k = q.getClass();
      String methodString = k.getMethod("toString", new Class<?>[]{}).toString();
      boolean isOverridden = methodString.indexOf("Question.toString") > 0;
      
      System.out.println("toString overridden in Question: " + isOverridden);
      System.out.println("Expected: true");
      
      ChoiceQuestion q2 = new ChoiceQuestion("What's up Doc?");
      k = q2.getClass();
      methodString = k.getMethod("toString", new Class<?>[]{}).toString();
      isOverridden = methodString.indexOf("ChoiceQuestion.toString") > 0;

      System.out.println("toString overridden in ChoiceQuestion: " + isOverridden);
      System.out.println("Expected: true");
   }
}

