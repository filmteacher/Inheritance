import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args)
    {

//1. Create 3 workers and 3 salaryWorker instances and add them to an ArrayList<Worker>.
// Pick reasonable hourly rates for the workers and reasonable salary rates for the salaryWorkers.
// Of course all workers have names, ids, and YOBs.
        ArrayList<Person> Workers = new ArrayList<>();

        Worker worker = new Worker("00000001", "Marty", "Philbert", "Secretary", 1990, 20.00);
        Worker worker2 = new Worker("00000002", "Pete", "Jones", "Grocery Bagger", 2008, 10.00);
        Worker worker3 = new Worker("00000003", "Alix", "Meager", "K-12 Teacher", 2000, 25.00);

        SalaryWorker salaryWorker = new SalaryWorker("00000004", "Jane", "Doe", "Sales Manager", 1985, 120.00, 1000000.00);
        SalaryWorker salaryWorker2 = new SalaryWorker("00000005", "John", "Smith", "Software Engineer", 1980, 90.00, 700000.00);
        SalaryWorker salaryWorker3 = new SalaryWorker("00000006", "Phil", "Berger", "Professor", 1975, 40.00, 100000.00);

        Workers.add(worker);
        Workers.add(worker2);
        Workers.add(worker3);
        Workers.add(salaryWorker);
        Workers.add(salaryWorker2);
        Workers.add(salaryWorker3);

//2. Write a loop that simulates 3 weekly pay periods.
// Week 1 is a 40-hour week.
// For week 2 assume it is crunch time and everyone worked 50 hours.
// Week 3 is back to normal with 40 hours.
// Generate a display showing the weekly pay for each of the workers for each week in a reasonable tabular format.
        for (int i = 1; i <= 3; i++)
        {
            System.out.println("Week " + i + " Pay");
            System.out.println("------");
            for (int j = 0; j < Workers.size(); j++)
            {
                double pay = 0;
                Object employee = Workers.get(j);

                if (i == 1)
                {
                    if (employee instanceof Worker)
                    {
                        pay=((Worker) employee).calculateWeeklyPay(40.0);
                    }
                    else {
                        pay=((SalaryWorker) employee).calculateWeeklyPay(40.0);
                    }
                }
                else if (i == 2)
                {
                    if (employee instanceof Worker)
                    {
                        pay=((Worker) employee).calculateWeeklyPay(50.0);
                    }
                    else {
                        pay=((SalaryWorker) employee).calculateWeeklyPay(50.0);
                    }
                }
                else if (i == 3)
                {
                    if (employee instanceof Worker)
                    {
                        pay=((Worker) employee).calculateWeeklyPay(40.0);
                    }
                    else {
                        pay=((SalaryWorker) employee).calculateWeeklyPay(40.0);
                    }
                }

                System.out.printf("%-17s:\t $%.2f%n", ((Person) employee).fullName(), pay);
            }
            System.out.println();
        }
    }
}