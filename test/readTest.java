package test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import src.fileoperations.*;

public class readTest extends Read {
    @Test
    public void testCSVReadLine(){
        String[] test1Ans = {"mohamed","ahmed","011235"};
        String[] test1 = readCSVLine("mohamed,ahmed,011235");
        assertArrayEquals(test1Ans, test1);

        String[] test2Ans = null;
        String[] test2 = readCSVLine("");
        assertEquals(test2Ans, test2);

        String[] test3Ans = {"mohamed","Giza, October, Hosary","011235"};
        String[] test3 = readCSVLine("mohamed,\"Giza, October, Hosary\",011235");
        assertArrayEquals(test3Ans, test3);

        String[] test4Ans = {"mohamed","Giza, October, Hosary, 152","011235","12.9 test"};
        String[] test4 = readCSVLine("mohamed,\"Giza, October, Hosary, 152\",011235,12.9 test");
        assertArrayEquals(test4Ans, test4);
    }
    
}
