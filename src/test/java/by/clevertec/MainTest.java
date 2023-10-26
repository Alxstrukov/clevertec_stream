package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void task1() {
        List<Animal> expected = List.of(
                new Animal(614, "Snake, buttermilk", 10, "Belarusian", "Bigender"),
                new Animal(649, "European stork", 10, "Danish", "Female"),
                new Animal(712, "Flamingo, chilean", 10, "Somali", "Male"),
                new Animal(713, "Red-breasted cockatoo", 10, "Papiamento", "Female"),
                new Animal(744, "Blue-tongued lizard", 10, "Swati", "Male"),
                new Animal(775, "Wolf spider", 10, "Romanian", "Female"),
                new Animal(857, "Jackal, silver-backed", 10, "Kazakh", "Female")
        );
        List<Animal> actual = Main.task1();

        assertEquals(expected, actual);
    }

    @Test
    void task14() {
        Double expected = 26532.24;
        Double actual = Main.task14();

        assertEquals(expected, actual);
    }

    @Test
    void task15() {
        BigDecimal expected = BigDecimal.valueOf(89183622.6918);
        BigDecimal actual = Main.task15();

        assertEquals(expected, actual);
    }

    @Test
    void task21() {
        HashMap<String, Long> expected = new HashMap<>();
        expected.put("M-1", 5l);
        expected.put("M-3", 3l);
        expected.put("M-2", 4l);
        expected.put("P-2", 2l);
        expected.put("P-1", 7l);
        expected.put("C-1", 4l);
        expected.put("P-4", 1l);
        expected.put("P-3", 3l);
        expected.put("C-3", 9l);
        expected.put("C-2", 11l);
        expected.put("C-4", 1l);
        HashMap<String, Long> actual = Main.task21();

        assertEquals(expected, actual);
    }

    @Test
    void task22() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("ComputerScience", 18);
        expected.put("Chemistry", 18);
        expected.put("Mathematics", 18);
        expected.put("Physics", 18);
        HashMap<String, Integer> actual = Main.task22();

        assertEquals(expected, actual);
    }


}