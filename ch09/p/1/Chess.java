
/**
 * Illustrate class construction and inheritance
 */

/**
 * Store information about an employee
 */
class Employee
{

    private String name;
    private double baseSalary;

    /**
     * Set the name of an Employee
     *
     * @param newName the name to be set
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Set the salary for an Employee
     *
     * @param newSalary the salary to be set
     */
    public void setBaseSalary(double newSalary)
    {
        baseSalary = newSalary;
    }

    /**
     * @return the name of the Employee
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the salary of the Employee
     */
    public double getSalary()
    {
        return baseSalary;
    }
}

/**
 * Manager extends Employee by allowing for bonus
 */
class Manager extends Employee
{

    private double bonus;

    /**
     * Create Manager
     *
     * @param newName the manager's name
     * @param newSalary the base salary of the manager
     * @param newBonus the expected bonus of the manager
     */
    public Manager(String newName, double newSalary, double newBonus)
    {
        setName(newName);
        setBaseSalary(newSalary);
        bonus = newBonus;
    }

    /**
     * @return the expected bonus of the manager
     */
    public double getBonus()
    {
        return bonus;
    }

    /**
     * Set the bonus for the manager
     *
     * @param bonus the amount of the bonus
     */
    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }

}

public class Chess
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Create an employee
        System.out.println("This program illustrated inheritance by creating an Employee class");
        System.out.println("and a specialized Manager class\n");
        Employee employee = new Employee();
        employee.setName("James Garfield");
        employee.setBaseSalary(23000.00);
        Manager manager = new Manager("Mary Wilson", 25000, 3000);
        // Oops a bigger bonus!
        manager.setBonus(3500);
        System.out.printf("Employee %s makes $%.2f.\n", employee.getName(), employee.getSalary());
        System.out.printf("Manager %s makes $%.2f and a bonus of $%.2f.\n",
                manager.getName(), manager.getSalary(), manager.getBonus());

    }

}

