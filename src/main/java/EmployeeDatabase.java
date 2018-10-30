import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements a database of employees.
 * <p>
 * This class models some functions of an employee database. We have two classes: EmployeeDatabase
 * and Employee. You only need to finish functions in this class, however you would have to refer to
 * the functions in the other class as well. And, of course, fix the checkstyle errors.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/10/">Lab 10 Description</a>
 */
public class EmployeeDatabase {

    /**
     * List of employees.
     */
    public List<Employee> employees;

    /**
     * Constructor which initializes the employees list.
     * <p>
     * We suggest that you investigate the ArrayList class, which is one of the more useful built-in
     * data structures in Java.
     */
    public EmployeeDatabase() {
        employees = new ArrayList<Employee>();
    }

    /**
     * Returns the manager for the given employee.
     *
     * @param employee
     * @return
     */
    Employee findManager(final Employee employee) {
        Employee manager = null;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName() == employee.getManager()) {
                manager = employees.get(i);
                break;
            }
        }
        return manager;
    }

    /**
     * Count the number of managers above this employee.
     * <p>
     * Consider both a recursive and an iterative solution to this problem.
     *
     * @param employee name of the employee
     * @return int
     */
    public static int count = 0;
    public int countManagersAbove(final Employee employee) {
        /*
         * Implement this function
         */
        if (employee.getManager().equals("")) {
            return count;
        }
        count++;
        return countManagersAbove(findManager(employee));
    }

    /**
     * Count the number of employees under this manager.
     * <p>
     * Consider both a recursive and an iterative solution to this problem.
     *
     * @param employee name of the employee
     * @return int
     */
    public static int count1 = 0;
    public int countEmployeesUnder(final Employee employee) {
        /*
         * Implement this function
         */
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getManager().equals(employee.getName())) {
                count1++;
                Employee person = employees.get(i);
                countEmployeesUnder(person);
            }
        }
        return count1;

    }

    /**
     * Main method for testing.
     * <p>
     * You should understand, but do not need to modify, this function.
     *
     * @param unused unused input arguments
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(final String[] unused) {

        EmployeeDatabase database = new EmployeeDatabase();

        Employee betty = new Employee("Betty", "Sam");
        database.employees.add(betty);
        Employee bob = new Employee("Bob", "Sally");
        database.employees.add(bob);
        Employee dilbert = new Employee("Dilbert", "Nathan");
        database.employees.add(dilbert);
        Employee joseph = new Employee("Joseph", "Sally");
        database.employees.add(joseph);
        Employee nathan = new Employee("Nathan", "Veronica");
        database.employees.add(nathan);
        Employee sally = new Employee("Sally", "Veronica");
        database.employees.add(sally);
        Employee sam = new Employee("Sam", "Joseph");
        database.employees.add(sam);
        Employee susan = new Employee("Susan", "Bob");
        database.employees.add(susan);
        Employee veronica = new Employee("Veronica", "");
        database.employees.add(veronica);

        System.out.println("Welcome to the employee database\n\n");

        // Count employees under
        int answer = database.countEmployeesUnder(sally);
        System.out.println("Sally has " + Integer.toString(answer) + " employees under her.\n");
        EmployeeDatabase.count1 = 0;

        answer = database.countEmployeesUnder(nathan);
        System.out.println("Nathan has " + Integer.toString(answer) + " employees under him.\n");
        EmployeeDatabase.count1 = 0;

        answer = database.countEmployeesUnder(betty);
        System.out.println("Betty has " + Integer.toString(answer) + " employees under her.\n");
        EmployeeDatabase.count1 = 0;

        answer = database.countEmployeesUnder(veronica);
        System.out.println("Veronica has " + Integer.toString(answer) + " employees under her.\n");
        EmployeeDatabase.count1 = 0;

        // Count managers above
        answer = database.countManagersAbove(sally);
        System.out.println("Sally has " + Integer.toString(answer) + " managers above her.\n");
        EmployeeDatabase.count = 0;

        answer = database.countManagersAbove(veronica);
        System.out.println("Veronica has " + Integer.toString(answer) + " managers above her.\n");
        EmployeeDatabase.count = 0;

        answer = database.countManagersAbove(bob);
        System.out.println("Bob has " + Integer.toString(answer) + " managers above him.\n");
        EmployeeDatabase.count = 0;

        answer = database.countManagersAbove(betty);
        System.out.println("Betty has " + Integer.toString(answer) + " managers above her.\n");
    }
}
