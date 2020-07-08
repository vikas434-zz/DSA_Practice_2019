import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestJunit {

    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }

    @Test
    public void checkAssertTrue(){
        assertTrue("It should always be true", false);
    }

    @Test(expected = Exception.class)
    public void testThrowException() throws Exception {
        int a = 0;
        try {
            int x = 5/a;
            System.out.println("X is "+x);
        } catch (Exception e) {
            throw new NoSuchFieldException("Test");
        }
    }

    @Test
    public void basicTest() {

    }
}
