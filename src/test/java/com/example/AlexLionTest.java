package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlexLionTest {
    AlexLion alexLion;

    @Mock
    Feline feline;

    @Before
    public void init() throws Exception {
        alexLion = new AlexLion(feline);
    }

    @Test
    public void checkAlexFriends() {
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alexLion.getFriends());
    }

    @Test
    public void checkPlaceOfLiving() {
        String expected = "Нью-Йоркский зоопарк";
        assertEquals(expected, alexLion.getPlaceOfLiving());
    }

    @Test
    public void checkAlexKittens() {
        int expected = 0;
        assertEquals(expected, alexLion.getKittens());
    }
}
