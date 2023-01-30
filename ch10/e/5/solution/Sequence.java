public interface Sequence
{
   int next();
   
   /**
		Default method to return an array containing the first n values of a sequence
		@param the number of values to be included
		@return the array containing n sequence values
   */
   default int[] values(int n)
   {
      int[] result = new int[n];
      
      for (int i = 0; i < n; i++)
      {
         result[i] = next();
      }
      return result;
   }
}
