package TDD;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

    @Test
    public void testPlainNumberOTherThanThreeAndFive() {
        FizzBuzzConvertor fizzBuzzConvertor = new FizzBuzzConvertor();
        assertThat("2", is(fizzBuzzConvertor.convet(2)));
    }
}
