
import static org.junit.Assert.*;

import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @InjectMocks
    private Feline feline;

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> food = feline.eatMeat();
        assertEquals(expectedFood, food);
    }

    @Test
    public void testGetFamily() {
        String expectedFamily = "Кошачьи";
        String family = feline.getFamily();
        assertEquals(expectedFamily, family);
    }

    @Test
    public void testGetKittensWithoutParameter() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetKittensWithParameter() {
        int kittensCount = 5;
        int actualKittens = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actualKittens);
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithUnknownAnimalKind() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестный");
    }
}