//FORBIDDEN ArrayList Don't make a copy of the choice strings
//FORBIDDEN checkAnswer Don't override the checkAnswer method
/**
   A question with multiple choices and multiple
   correct answers possible. All correct answers must be
   chosen for the question to be marked correct.
*/
public class MultiChoiceQuestion extends ChoiceQuestion
{
   private String choiceString = "";
   private int numberOfChoices;

   /**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
   */
   public void addChoice(String choice, boolean correct)
   {
      super.addChoice(choice, correct);
      numberOfChoices++;

      // Convert choices.size() to string
      if (correct) 
      {
         // if this is the first correct answer
         if (choiceString.length() == 0)
            choiceString = "" + numberOfChoices;
         else
         // else separate with space
            choiceString = choiceString + " " + numberOfChoices;
      }
      setAnswer(choiceString);
   }

   public void display()
   {
      // Display the question text
      super.display();

      System.out.println("Enter all correct choices separated by spaces.");
   }
}
