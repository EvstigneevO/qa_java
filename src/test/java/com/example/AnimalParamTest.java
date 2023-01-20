package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class AnimalParamTest {
    Animal animal;
    private String animalKind;
    private List<String> expectedFood;

    public AnimalParamTest(String animalKind, List<String> expectedFood) {
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

    @Before
    public void init() {
        animal = new Animal();
    }

    @Test
    public void getFoodTest() {
        List<String> actual;
        try {
            actual = animal.getFood(animalKind);
            assertEquals("Неверный список пищи для животного: " + animalKind, expectedFood, actual);
        } catch (Exception e) {
            actual = List.of(e.getMessage());
            assertEquals("Неверный текст Exception", expectedFood, actual);
        }
    }


}
