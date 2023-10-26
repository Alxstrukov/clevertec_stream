package by.clevertec.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Company {
    private Echelon echelon;

    {
        echelon = new Echelon();
    }

    public Double getIncome() {
        return echelon.getTransportationCosts();
    }

    public void addCarInEchelon(List<Car> carList) {
        echelon.getCars().addAll(carList);
    }
}
