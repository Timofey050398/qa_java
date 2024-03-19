import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.example.*;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {
    private Alex alex;

    @Mock
    Feline felineMock;
    @Before
            public void setUP(){
        try {
            this.alex = new Alex(felineMock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void shouldReturnZeroKittens(){
            assertEquals(0, alex.getKittens());
    }

    @Test
    public void testGetPlaceOfLiving(){
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
    @Test
    public void testGetFriends(){
        assertEquals(Arrays.asList("Марти", "Глория","Мелман"), alex.getFriends());
    }
    @Test
    public void doesGetFoodDoNotOverride() throws Exception {
        Lion lion = new Lion("Самец",felineMock);
        when(felineMock.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        assertEquals(lion.getFood(), alex.getFood());
    }
    @Test
    public void testAlexAlwaysHasMane() {
        assertTrue(alex.doesHaveMane());
    }
}
