package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;


import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamTest {
    String sex;
    Boolean expected;

    public LionParamTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] sexAndExpectedResults() {
        return new Object[][]{{"Самец", true}, {"Самка", false}};
    }

    @Mock
    Feline feline;

    @Test
    public void successfulCreateInstanceOfLion() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane());

    }
}
