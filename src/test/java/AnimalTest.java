
import static org.junit.Assert.*;

import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {

    private String animalKind;
    private List<String> expectedFood;
    private boolean shouldThrowException;

    public AnimalTest(String animalKind, List<String> expectedFood, boolean shouldThrowException) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.shouldThrowException = shouldThrowException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения"), false},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), false},
                {"Неизвестный", null, true}
        });
    }

    @Test
    public void testGetFood() {
        Animal animal = new Animal();
        if (shouldThrowException) {
            try {
                animal.getFood(animalKind);
                fail("Ожидалось исключение, но не было выброшено");
            } catch (Exception e) {
                assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
            }
        } else {
            try {
                List<String> food = animal.getFood(animalKind);
                assertEquals(expectedFood, food);
            } catch (Exception e) {
                fail("Неожиданное исключение: " + e.getMessage());
            }
        }
    }
    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }
}