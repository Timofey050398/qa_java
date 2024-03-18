import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.example.*;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;

 @Mock
 Feline felineMock;

    @Test
    public void testInvalidSex() {
        try {
            new Lion("Invalid", felineMock);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }



    @Test
    public void testGetKittens() {
        try {
            when(felineMock.getKittens()).thenReturn(1);
            lion = new Lion("Самец", felineMock);
            assertEquals(1, lion.getKittens());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        lion = new Lion("Самка", felineMock);
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
