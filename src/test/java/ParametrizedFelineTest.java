import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedFelineTest {
    private Feline feline;
    private int inputKittensCount;
    private int expectedKittensCount;
    @Before
    public void setUp(){
        feline = new Feline();
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, 1},
                {2, 2},
                {5, 5}
        });
    }


    public ParametrizedFelineTest(int inputKittensCount, int expectedKittensCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Test
    public void testGetKittensWithParameter() {
        assertEquals(expectedKittensCount, feline.getKittens(inputKittensCount));
    }
}
