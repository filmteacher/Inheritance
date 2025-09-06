import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest
{
    // create the salary worker instances first and get the ids right before running the tests
    SalaryWorker salaryWorker = new SalaryWorker("00000003", "Jane", "Doe", "Sales Manager", 1985, 120.00, 1000000.00);

    @Test
    void testDisplayWeeklyPay()
    {
        salaryWorker.displayWeeklyPay(40.0);
    }

    @Test
    void testToString()
    {
        assertEquals("00000003: Sales Manager Jane Doe (1985) $120.0 hourly $1000000.0 yearly", salaryWorker.toString());
    }

    @Test
    void testToCSV()
    {
        assertEquals("00000003,Jane,Doe,Sales Manager,1985,120.0,1000000.0", salaryWorker.toCSV());
    }

    @Test
    void testToJSON()
    {
        assertEquals("{\"ID\":\"00000003\",\"FirstName\":\"Jane\",\"LastName\":\"Doe\",\"Title\":\"Sales Manager\",\"YOB\":1985\",\"HourlyPayRate\":120.0,\"AnnualSalary\":1000000.0}", salaryWorker.toJSON());
    }

    @Test
    void testToXML()
    {
        assertEquals("<Person><ID>00000003</ID><FirstName>Jane</FirstName><LastName>Doe</LastName><Title>Sales Manager</Title><YOB>1985</YOB><HourlyPayRate>120.0</HourlyPayRate><AnnualSalary>1000000.0</AnnualSalary></Person>", salaryWorker.toXML());
    }
}