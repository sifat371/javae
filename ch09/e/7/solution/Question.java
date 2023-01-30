/**
   A question with a text and an answer.
*/
public class Question
{
   private String text;
   private String answer;

   /**
      Constructs a question with a given text and an empty answer.
      @param questionText the text of this question
   */
   public Question(String questionText) 
   {
      text = questionText;
      answer = "";
   }

   /**
      Sets the answer for this question.
      @param correctResponse the answer
   */
   public void setAnswer(String correctResponse)
   {
      answer = correctResponse;
   }

   /**
      Checks a given response for correctness.
      Leading and trailing spaces are ignored, as well as case.
      @param response the response to check
      @return true if the response was correct, false otherwise
   */
   public boolean checkAnswer(String response)
   {      
      return answer.replaceAll("\\s+", "").equalsIgnoreCase(response.replaceAll("\\s+", ""));
   }

   /**
      Displays this question.
   */
   public void display()
   {
      System.out.println(text);
   }
}