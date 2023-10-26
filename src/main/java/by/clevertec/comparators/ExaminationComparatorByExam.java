package by.clevertec.comparators;

import by.clevertec.model.Examination;

import java.util.Comparator;

public class ExaminationComparatorByExam implements Comparator<Examination> {
    @Override
    public int compare(Examination examination1, Examination examination2) {
        return examination2.getExam1() - examination1.getExam1();
    }
}
