public class SalaryWorker extends Worker
{
    ///Fields:
    private double annualSalary;
    private double pay = 0;

    //The constructor for SalaryWorker should use super() to call the constructor for Worker
    public SalaryWorker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary)
    {
        super(IDNum, firstName, lastName, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    //Overload constructor for SalaryWorker to use the automatically generated IDNum
    public SalaryWorker(String firstName, String lastName, String title, int YOB, double hourlyPayRate)
    {
        super(firstName, lastName, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    //Methods:
    //double calculateWeeklyPay(double hoursWorked)
    //Override calculateWeeklyPay and displayWeeklyPay calculateWeeklyPay returns the pay total. Note that the parameter hoursWorked is not used here but is retained for polymorphism.  Take the annualSalary and divide by 52 to get the weekly pay.
    @Override
    public double calculateWeeklyPay(double hoursWorked)
    {
        pay = annualSalary/52;
        return pay;
    }

    //void displayWeeklyPay(double hoursWorked)
    //displayWeeklyPay should indicate that the weekly pay is a fraction of the yearly salary.
    @Override
    public void displayWeeklyPay(double hoursWorked)
    {
        calculateWeeklyPay(hoursWorked);
        System.out.println("Total pay= $" + calculateWeeklyPay(hoursWorked));
    }

    //Getters and Setters:
    public double getAnnualSalary() {
        return annualSalary;
    }
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    //Override the toString() method to include the annualSalary field
    @Override
    public String toString()
    {
        return super.toString() + " $" + annualSalary + " yearly";
    }

    //You have to overload the toCSV(), toXML(), toJSON() methods to include the new data field
    @Override
    public String toCSV()
    {
        return super.toCSV() + "," + annualSalary;
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
                "\"HourlyPayRate\":" + this.getHourlyPayRate() +
                ",\"AnnualSalary\":" + this.annualSalary +
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
                "<HourlyPayRate>" + this.getHourlyPayRate() + "</HourlyPayRate>" +
                "<AnnualSalary>" + this.annualSalary + "</AnnualSalary>" +
                "</Person>";
    }

    /**
     * Compares this salary worker to another salary worker for equality.
     *
     * @param o the other person to compare to
     * @return true if they are equal, false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SalaryWorker that = (SalaryWorker) o;
        return Double.compare(annualSalary, that.annualSalary) == 0;
    }
}
