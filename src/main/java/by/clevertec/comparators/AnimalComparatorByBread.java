package by.clevertec.comparators;

import by.clevertec.model.Animal;

import java.util.Comparator;

public class AnimalComparatorByBread implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getBread().compareTo(o2.getBread());
    }
}
