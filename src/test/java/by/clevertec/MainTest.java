package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}