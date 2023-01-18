import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class AnimalGetFoodTest {
    private String animalKind;
    private List<String> expectedFood;

    public AnimalGetFoodTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Object[][] kindAndExpectedFood() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Рыба", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")},
        };
    }

    @Test
    public void getFoodTest() {
        List<String> actual;
        try {
            Animal animal = new Animal();
            actual = animal.getFood(animalKind);
            assertEquals("Неверный список пищи для животного: " + animalKind, expectedFood, actual);
        } catch (Exception e) {
            actual = List.of(e.getMessage());
            assertEquals("Неверный текст Exception", expectedFood, actual);
        }
    }
}
