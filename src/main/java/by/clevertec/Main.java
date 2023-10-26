package by.clevertec;

import by.clevertec.comparators.AnimalComparatorByAge;
import by.clevertec.comparators.AnimalComparatorByBread;
import by.clevertec.comparators.PersonComparatorByRecruitmentGroup;
import by.clevertec.comparators.StudentComparatorBySurname;
import by.clevertec.comparators.UnitComparator;
import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Company;
import by.clevertec.model.Echelon;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.model.Unit;
import by.clevertec.util.Util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
//        task10();
//        task11();
//        task12();
//        task13();
//        task14();
        task15();
//        task16();
//        task17();
//        task18();
//        task19();
//        task20();
//        task21();
//        task22();
    }

    public static List<Animal> task1() {
        List<Animal> animals = Util.getAnimals();
        int minAge = 10, maxAge = 20, skipCount = 14, animalLimit = 7;
        List<Animal> animalList = animals.stream()
                .filter(animal -> animal.getAge() >= minAge && animal.getAge() <= maxAge)
                .sorted(new AnimalComparatorByAge())
                .skip(skipCount)
                .limit(animalLimit)
                .collect(Collectors.toList());
        animalList.forEach(System.out::println);
        return animalList;
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase("Japanese"))
                .peek(animal -> animal.setBread(animal.getBread().toUpperCase()))
                .peek(animal -> {
                    if (animal.getGender().equalsIgnoreCase("Female")) animal.setBread(animal.getBread().toLowerCase());
                })
                .forEach(System.out::println);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        char firstSymbol = 'A';
        int minAge = 30;
        animals.stream()
                .filter(animal -> animal.getAge() > minAge && animal.getOrigin().charAt(0) == firstSymbol)
                .map(animal -> animal.getOrigin())
                .distinct()
                .forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        String genderSelection = "Female";
        long femaleCount = animals.stream()
                .filter(animal -> animal.getGender().equalsIgnoreCase(genderSelection)).count();
        System.out.println(femaleCount);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        int minAge = 20, maxAge = 30;
        String originSelection = "Hungarian";
        boolean isHungarian = animals.stream()
                .filter(animal -> animal.getAge() >= minAge && animal.getAge() <= maxAge)
                .anyMatch(animal -> animal.getOrigin().equalsIgnoreCase(originSelection));
        System.out.println(isHungarian);
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        String genderSelectionFemale = "Female";
        String genderSelectionMale = "male";
        boolean isNormalGender = animals.stream()
                .allMatch(animal -> animal.getGender().equalsIgnoreCase(genderSelectionFemale)
                        && animal.getGender().equalsIgnoreCase(genderSelectionMale));
        System.out.println(isNormalGender);
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        String originSelection = "oceania";
        boolean isOriginOceania = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equalsIgnoreCase(originSelection));
        System.out.println(isOriginOceania);
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        int animalLimit = 100;
        int maxAgeAnimal = animals.stream()
                .sorted(new AnimalComparatorByBread())
                .limit(animalLimit)
                .max(new AnimalComparatorByAge()).get().getAge();
        System.out.println(maxAgeAnimal);
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        int minChars = animals.stream()
                .map(animal -> animal.getBread())
                .map(bread -> bread.toCharArray())
                .min(Comparator.comparing(chars -> chars.length)).get().length;
        System.out.println(minChars);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        long totalAge = animals.stream()
                .map(animal -> animal.getAge())
                .reduce((age1, age2) -> age1 + age2).get();
        System.out.println(totalAge);
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        String originSelection = "Indonesian";
        double averageAge = animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase(originSelection))
                .mapToInt(Animal::getAge)
                .average()
                .getAsDouble();
        System.out.println(averageAge);
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
        int minAge = 18, maxAge = 27, maxPeople = 200;
        String genderSelection = "Male";
        persons.stream()
                .filter(person -> person.getGender().equalsIgnoreCase(genderSelection))
                .filter(person -> Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() >= minAge
                        && Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() <= maxAge)
                .sorted(new PersonComparatorByRecruitmentGroup())
                .limit(maxPeople)
                .forEach(System.out::println);
    }


    public static void task13() {
        List<House> houses = Util.getHouses();
        int evacuationPlacesNumber = 500;

        houses.stream()
                .flatMap(mapToUnit())
                .sorted(new UnitComparator())
                .map(Unit::getPerson)
                .limit(evacuationPlacesNumber)
                .forEach(System.out::println);
    }

    private static Function<House, Stream<Unit>> mapToUnit() {
        return house -> house.getPersonList().stream()
                .map(person -> new Unit()
                        .setBuildingType(house.getBuildingType())
                        .setAge(Period.between(person.getDateOfBirth(), LocalDate.now()).getYears())
                        .setPerson(person));
    }

    public static Double task14() {
        List<Car> cars = Util.getCars();
        Echelon echelon = new Echelon();
        Company company = new Company();

        cars.stream()
                .map(car -> mapToEchelon(echelon, car)
                )
                .collect(Collectors.groupingBy(Echelon::getEchelonName, Collectors.mapping(e -> e.getCars().get(0), Collectors.toList())))
                .forEach((key, value) -> {
                    company.addCarInEchelon(value);
                    double rate = 7.14;
                    System.out.printf("         %s\n", key);
                    System.out.printf("TotalMasses: %d kg\n", value.stream().mapToInt(Car::getMass).sum());
                    System.out.printf("TransportationCosts: %.2f $\n", value.stream().mapToInt(Car::getMass).sum() * rate / 1000);
                    System.out.println("==============================");
                });
        System.out.println("Total income logistic company: " + company.getIncome() + " $");
        return company.getIncome();
    }

    private static Echelon mapToEchelon(Echelon echelon, Car car) {
        if (filterTurkmenistan(car)) {
            echelon.setEchelonName("Turkmenistan");
            echelon.getCars().add(car);
        } else if (filterUzbekistan(car)) {
            echelon.setEchelonName("Uzbekistan");
            echelon.getCars().add(car);
        } else if (filterKazakhstan(car)) {
            echelon.setEchelonName("Kazakhstan");
            echelon.getCars().add(car);
        } else if (filterKyrgyzstan(car)) {
            echelon.setEchelonName("Kyrgyzstan");
            echelon.getCars().add(car);
        } else if (filterRussia(car)) {
            echelon.setEchelonName("Russia");
            echelon.getCars().add(car);
        } else if (filterMongolia(car)) {
            echelon.setEchelonName("Mongolia");
            echelon.getCars().add(car);
        }
        return echelon;
    }


    private static boolean filterTurkmenistan(Car car) {
        return car.getCarMake().equalsIgnoreCase("Jaguar")
                || car.getColor().equalsIgnoreCase("White");
    }

    private static boolean filterUzbekistan(Car car) {
        return car.getMass() < 1500
                && car.getCarMake().equalsIgnoreCase("Bmw")
                || car.getCarMake().equalsIgnoreCase("Lexus")
                || car.getCarMake().equalsIgnoreCase("Chrysler")
                || car.getCarMake().equalsIgnoreCase("Toyota");
    }

    private static boolean filterKazakhstan(Car car) {
        return car.getColor().equalsIgnoreCase("Black") && car.getMass() > 4000
                || car.getCarMake().equalsIgnoreCase("GMC")
                || car.getCarMake().equalsIgnoreCase("Dodge");
    }

    private static boolean filterKyrgyzstan(Car car) {
        return car.getReleaseYear() < 1982 || car.getCarMake().equalsIgnoreCase("Civic")
                || car.getCarMake().equalsIgnoreCase("Cherokee");
    }

    private static boolean filterRussia(Car car) {
        return !car.getColor().equalsIgnoreCase("Yellow") && !car.getColor().equalsIgnoreCase("Red")
                && !car.getColor().equalsIgnoreCase("Blue") && !car.getColor().equalsIgnoreCase("Green")
                || car.getPrice() < 40000;
    }

    private static boolean filterMongolia(Car car) {
        return car.getVin().contains("59");
    }

    public static BigDecimal task15() {
        List<Flower> flowers = Util.getFlowers();
        BigDecimal totalCostOfMaintenanceFlowers = flowers.stream()
                .sorted(sortedFlowerComparator())
                .filter(filterFlowerByCommonName())
                .filter(filterFlowerByVaseMaterial())
                .map(mapToCostMaintenanceOneFlower())
                .reduce(BigDecimal::add)
                .get();
        System.out.printf("TotalCostOfMaintenanceFlowers: %.2f $\n", totalCostOfMaintenanceFlowers);
        return totalCostOfMaintenanceFlowers;
    }

    private static Function<Flower, BigDecimal> mapToCostMaintenanceOneFlower() {
        LocalDate now = LocalDate.now();
        BigDecimal numberOfDaysOnFiveYear = BigDecimal.valueOf(ChronoUnit.DAYS.between(now, now.plusYears(5)));
        return flower -> BigDecimal.valueOf(flower.getWaterConsumptionPerDay())
                .multiply(numberOfDaysOnFiveYear)
                .multiply(BigDecimal.valueOf(1.39)
                        .add(BigDecimal.valueOf(flower.getPrice())));
    }

    private static Predicate<Flower> filterFlowerByCommonName() {
        return flower -> flower.getCommonName().matches("^[^C-S].*");
    }

    private static Predicate<Flower> filterFlowerByVaseMaterial() {
        return flower -> (flower.isShadePreferred()
                && flower.getFlowerVaseMaterial().contains("Steel")
                && flower.getFlowerVaseMaterial().contains("Glass")
                && flower.getFlowerVaseMaterial().contains("Aluminum"));
    }

    private static Comparator<Flower> sortedFlowerComparator() {
        return Comparator.comparing(Flower::getOrigin).reversed()
                .thenComparing(Comparator.comparing(Flower::getPrice).reversed()
                        .thenComparing(Comparator.comparing(Flower::getWaterConsumptionPerDay).reversed()));
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        students.stream()
                .filter(student -> student.getAge() <= 19)
                .sorted(new StudentComparatorBySurname())
                .map(student -> student.getSurname() + " = " + student.getAge())
                .forEach(System.out::println);
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(System.out::println);
    }


    public static void task19() {
        List<Examination> examinations = Util.getExaminations();
        List<Student> students = Util.getStudents();
        int minRating = 4;
        String group = "C-3";
        students.stream()
                .filter(student -> student.getGroup().equals(group))
                .filter(student -> {
                    for (Examination exam : examinations) {
                        if (exam.getExam3() > minRating && exam.getStudentId() == student.getId()) return true;
                    }
                    return false;
                })
                .forEach(System.out::println);

    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingDouble(
                        student -> examinations.stream()
                                .filter(examination -> examination.getStudentId() == student.getId())
                                .mapToDouble(Examination::getExam1)
                                .findFirst()
                                .orElse(0.0)
                )))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .stream().collect(Collectors.toSet())
                .forEach(stringDoubleEntry ->
                        System.out.printf("%s=%.2f", stringDoubleEntry.getKey(), stringDoubleEntry.getValue()));
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()))
                .forEach((key, value) -> System.out.printf("%s = %s\n", key, value));
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.minBy(Comparator.comparing(Student::getAge))))
                .forEach((key, value) -> System.out.printf("%s = %s\n", key, value.get().getAge()));

    }
}
