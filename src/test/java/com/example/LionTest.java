package com.example;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LionTest {
    Lion lion;
    private static final String sex = "Самец";
    @Mock
    Feline feline;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion(sex, feline);
    }

    @Test
    public void createLionWithInvalidGender() {
        String exceptionMessage = "Используйте допустимые значения пола животного - самей или самка";
        String invalidGender = "Небинарный лев";
        try {
            Lion invalidLion = new Lion(invalidGender, feline);
        } catch (Exception e) {
            assertEquals(exceptionMessage, e.getMessage());
        }
    }

    @Test
    public void checkLionsKittens() {
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(expected, lion.getKittens());
    }

    @Test
    public void checkLionsMane() {
        boolean actual = lion.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void checkLionsFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(expected, lion.getFood());
    }
}
