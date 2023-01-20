package com.example;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {
    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void checkFamily() {
        String expected = "Кошачьи";
        assertEquals(expected, feline.getFamily());
    }

    @Test
    public void checkKittens() {
        int expected = 1;
        assertEquals(expected, feline.getKittens());
    }

    @Test
    public void checkKittensCount() {
        int expected = 5;
        assertEquals(expected, feline.getKittens(5));
    }

    @Test
    public void checkEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }
}
