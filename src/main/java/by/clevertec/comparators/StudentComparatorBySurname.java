package by.clevertec.comparators;

import by.clevertec.model.Student;

import java.util.Comparator;

public class StudentComparatorBySurname implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getSurname().compareTo(student2.getSurname());
    }
}
