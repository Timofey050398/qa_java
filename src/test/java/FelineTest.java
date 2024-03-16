import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() throws Exception {
        feline = new Feline();
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, 1},
                {2, 2},
                {5, 5}
        });
    }

    private int inputKittensCount;
    private int expectedKittensCount;

    public FelineTest(int inputKittensCount, int expectedKittensCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Test
    public void testGetKittensWithParameter() {
        assertEquals(expectedKittensCount, feline.getKittens(inputKittensCount));
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline felineSpy = spy(feline);
        List<String> expectedFood = Arrays.asList("мясо");
        when(felineSpy.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = felineSpy.eatMeat();

        assertEquals(expectedFood, actualFood);
    }
}
