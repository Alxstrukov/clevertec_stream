package by.clevertec.comparators;

import by.clevertec.model.Person;

import java.util.Comparator;

public class PersonComparatorByRecruitmentGroup implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getRecruitmentGroup() - person2.getRecruitmentGroup();
    }
}
