import java.util.Objects;

public class Worker extends Person
{
    //Fields:
    private double hourlyPayRate;
    private double regularPay = 0;
    private double overtimePay = 0;
    private double pay = 0;

    //The constructor for Worker should use super() to call the constructor for Person and then go on to set the rest of the fields.
    public Worker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate)
    {
        super(IDNum, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    //Overload constructor for Worker to use the automatically generated IDNum
    public Worker(String firstName, String lastName, String title, int YOB, double hourlyPayRate)
    {
        super(firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }


    //Methods:
    //double calculateWeeklyPay(double hoursWorked)
    //calculateWeeklyPay should return the pay total. Hours under 40 are at the HourlyRate, hours above 40 are at time and a half (1.5)
    public double calculateWeeklyPay(double hoursWorked)
    {
        if (hoursWorked <= 40)
        {
            regularPay = hourlyPayRate * hoursWorked;
            overtimePay = 0;
        }
        else
        {
            regularPay = hourlyPayRate * 40;
            overtimePay = 1.5 * (hoursWorked - 40) * hourlyPayRate;
        }
        pay = regularPay + overtimePay;
        return pay;
    }

    //void displayWeeklyPay(double hoursWorked)
    //displayWeeklyPay should print to the console and show the number of hours of regular pay (40) and the total and the number of hours of overtime pay and the total as well as the total combined pay.
    public void displayWeeklyPay(double hoursWorked)
    {
        calculateWeeklyPay(hoursWorked);

        if (hoursWorked <= 40)
        {
            System.out.println(hoursWorked + " hours at regular pay= $" + regularPay);
        }
        else
        {
            System.out.println("40 hours at regular pay= $" + regularPay + "\n");
            System.out.println((hoursWorked - 40) + " hours at overtime pay= $" + overtimePay + "\n");
            System.out.println("Total pay= $" + calculateWeeklyPay(hoursWorked));
        }
    }

    //Getters and Setters:
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }
    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    //Override the toString() method to include the hourlyPayRate field
    @Override
    public String toString()
    {
        return super.toString() + " $" + hourlyPayRate + " hourly";
    }

    //You have to overload the toCSV(), toXML(), toJSON() methods to include the new data field
    @Override
    public String toCSV()
    {
        return super.toCSV() + "," + hourlyPayRate;
    }

    /** Returns a JSON String suitable for writing to a java text file. */
    @Override
    public String toJSON()
    {
        String parentString = super.toJSON();
        return "{" +
                "\"ID\":\"" + this.getIDNum() + "\","+
                "\"FirstName\":\"" + this.getFirstName() + "\","+
                "\"LastName\":\"" + this.getLastName() + "\","+
                "\"Title\":\"" + this.getTitle() + "\","+
                "\"YOB\":" + this.getYOB() + "\","+
                "\"HourlyPayRate\":" + hourlyPayRate +
                "}";
    }

    /** Returns an XML String suitable for writing to a java text file. */
    public String toXML()
    {
        String parentString = super.toXML();
        return "<Person>" +
                "<ID>" + this.getIDNum() + "</ID>" +
                "<FirstName>" + this.getFirstName() + "</FirstName>" +
                "<LastName>" + this.getLastName() + "</LastName>" +
                "<Title>" + this.getTitle() + "</Title>" +
                "<YOB>" + this.getYOB() + "</YOB>" +
                "<HourlyPayRate>" + hourlyPayRate + "</HourlyPayRate>" +
                "</Person>";
    }

    /**
     * Compares this worker to another worker for equality.
     *
     * @param o the other person to compare to
     * @return true if they are equal, false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Double.compare(hourlyPayRate, worker.hourlyPayRate) == 0;
    }
}
