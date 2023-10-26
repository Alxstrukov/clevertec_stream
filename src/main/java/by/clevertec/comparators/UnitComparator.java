package by.clevertec.comparators;

import by.clevertec.model.Unit;

import java.util.Comparator;

public class UnitComparator implements Comparator<Unit> {
    int childAge = 18;
    int retirementAge = 60;
    String buildingTypeHospital = "Hospital";

    @Override
    public int compare(Unit unit1, Unit unit2) {
        if (unit1.getBuildingType().equals(buildingTypeHospital) && !unit2.getBuildingType().equals(buildingTypeHospital)) {
            return -1;
        } else if (unit2.getBuildingType().equals(buildingTypeHospital) && !unit1.getBuildingType().equals(buildingTypeHospital)) {
            return 1;
        } else if (unit1.getBuildingType().equals(buildingTypeHospital) && unit2.getBuildingType().equals(buildingTypeHospital)) {
            return 0;
        } else {
            if ((unit1.getAge() <= childAge || unit1.getAge() >= retirementAge)
                    && (unit2.getAge() > childAge || unit2.getAge() < retirementAge)) {
                return 1;
            } else if ((unit2.getAge() <= childAge || unit2.getAge() >= retirementAge)
                    && (unit1.getAge() > childAge || unit1.getAge() < retirementAge)) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
