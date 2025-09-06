import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    // create the worker instances first and get the ids right before running the tests
    Worker worker = new Worker("00000001", "John", "Smith", "Software Engineer", 1980, 100.00);
    Worker worker2 = new Worker("00000002", "Pete", "Jones", "Grocery Bagger", 2008, 10.00);

    @Test
    void payRegularTest() {
        assertEquals(4000, worker.calculateWeeklyPay(40.0));
    }

    @Test
    void payOvertimeTest() {
        assertEquals(430, worker2.calculateWeeklyPay(42.0));
    }

    @Test
    void testToString()
    {
        assertEquals("00000001: Software Engineer John Smith (1980) $100.0 hourly", worker.toString());
    }

    @Test
    void testToCSV()
    {
        assertEquals("00000001,John,Smith,Software Engineer,1980,100.0", worker.toCSV());
    }

    @Test
    void testToJSON()
    {
        assertEquals("{\"ID\":\"00000001\",\"FirstName\":\"John\",\"LastName\":\"Smith\",\"Title\":\"Software Engineer\",\"YOB\":1980\",\"HourlyPayRate\":100.0}", worker.toJSON());
    }

    @Test
    void testToXML()
    {
        assertEquals("<Person><ID>00000001</ID><FirstName>John</FirstName><LastName>Smith</LastName><Title>Software Engineer</Title><YOB>1980</YOB><HourlyPayRate>100.0</HourlyPayRate></Person>", worker.toXML());
    }
}