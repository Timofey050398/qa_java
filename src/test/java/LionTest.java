import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.example.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionTest {

    private Lion lion;
    private Feline felineMock;

    private String sex;
    private boolean expectedHasMane;

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
    }

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    // Параметры для теста
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }
    @Test
    public void testInvalidSex() {
        try {
            new Lion("Invalid", felineMock);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }


    @Test
    public void testGetKittens() {
        try {
            when(felineMock.getKittens()).thenReturn(3);
            lion = new Lion(sex, felineMock);
            assertEquals(3, lion.getKittens());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        lion = new Lion(sex, felineMock);
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
