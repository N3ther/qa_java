
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

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
    Lion lion = new Lion("Самец", felineMock);
    assertEquals(3, lion.getKittens());
    }
    @Test
    public void testGetFood() throws Exception {

        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, food);
    }
}