/**
   The class represents a roach population that may breed and that
   may be controlled by insecticide.
*/
public class RoachPopulation
{
   private int population;

   /**
      Create an initial roach population with given size.
      @param size initial population
   */
   public RoachPopulation(int size)
   {
      population = size;
   }

   /**
      Simulates a breeding period increasing the population.
   */
   public void doublePopulation()
   {
      population = population * 2;
   }

   /**
      Returns the current population size.
      @return current population size
   */
   public int getPopulation()
   {
      return population;
   }
}
