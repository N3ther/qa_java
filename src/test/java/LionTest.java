import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testLionManeForMale() throws Exception {
        Lion lion = new Lion("Самец", felineMock); // Создаем объект Lion вручную
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", felineMock); // Создаем объект Lion вручную
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        Lion lion = new Lion("Неизвестный", felineMock); // Создаем объект Lion вручную
    }

    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock); // Создаем объект Lion вручную
        assertEquals(3, lion.getKittens());
    }
}