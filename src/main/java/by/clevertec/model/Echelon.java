package by.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Echelon {
    String echelonName;
    List<Car> cars = new ArrayList<>();

    public Double getTransportationCosts() {
        double rate = 7.14;
        Integer sumMass = cars.stream().mapToInt(Car::getMass).sum();
        return (sumMass * rate / 1000);
    }
}
