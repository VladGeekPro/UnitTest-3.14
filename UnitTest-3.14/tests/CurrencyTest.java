package tests;
import  org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CurrencyTest {

    @Test
    public void testDefaultConstructor() {
        Currency currency = new Currency();

        assertNull(currency.getCname1());
        assertNull(currency.getCname2());
        assertNull(currency.getData());
        assertNull(currency.getValue());
        assertNull(currency.getNumber());
    }

    @Test
    public void testParameterizedConstructor() {
        String c1 = "USD";
        String c2 = "EUR";
        String d = "2022-05-08";
        Double v = 1.22;
        Integer n = 100;

        Currency currency = new Currency(c1, c2, d, v, n);

        assertEquals(c1, currency.getCname1());
        assertEquals(c2, currency.getCname2());
        assertEquals(d, currency.getData());
        assertEquals(v, currency.getValue(), 0);
        assertEquals(n, currency.getNumber());
    }

    @Test
    public void testCopyConstructor() {
        String c1 = "USD";
        String c2 = "EUR";
        String d = "2022-05-08";
        Double v = 1.22;
        Integer n = 100;

        Currency original = new Currency(c1, c2, d, v, n);
        Currency copy = new Currency(original);

        assertEquals(original.getCname1(), copy.getCname1());
        assertEquals(original.getCname2(), copy.getCname2());
        assertEquals(original.getData(), copy.getData());
        assertEquals(original.getValue(), copy.getValue(), 0);
        assertEquals(original.getNumber(), copy.getNumber());
    }

    @Test
    public void testDisplayCurrency() {
        Currency currency = new Currency("USD", "EUR", "2022-05-08", 1.22, 100);
    
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    
        currency.displayCurrency();
    
        String[] outputLines = outContent.toString().split("\n");
    
        assertEquals("cname1 : USD", outputLines[0].trim());
        assertEquals("cname2 : EUR", outputLines[1].trim());
        assertEquals("data : 2022-05-08", outputLines[2].trim());
        assertEquals("value : 1.22", outputLines[3].trim());
        assertEquals("number : 100", outputLines[4].trim());
    } 


    

    @Test
    public void testClone() throws CloneNotSupportedException {
        String c1 = "USD";
        String c2 = "EUR";
        String d = "2022-05-08";
        Double v = 1.22;
        Integer n = 100;

        Currency currency = new Currency(c1, c2, d, v, n);
        Currency clonedCurrency = currency.clone();

        assertNotSame(currency, clonedCurrency);
        assertEquals(currency, clonedCurrency);
    }

    @Test
    public void testEquals() {
        String c1 = "USD";
        String c2 = "EUR";
        String d = "2022-05-08";
        Double v = 1.22;
        Integer n = 100;

        Currency currency1 = new Currency(c1, c2, d, v, n);
        Currency currency2 = new Currency(c1, c2, d, v, n);
        Currency currency3 = new Currency("GBP", c2, d, v, n);

        assertTrue(currency1.equals(currency2));
        assertFalse(currency1.equals(currency3));
    }
   
}
