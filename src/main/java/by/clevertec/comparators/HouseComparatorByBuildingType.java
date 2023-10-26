package by.clevertec.comparators;

import by.clevertec.model.House;

import java.util.Comparator;

public class HouseComparatorByBuildingType implements Comparator<House> {
    @Override
    public int compare(House house1, House house2) {
        String buildingType = "Hospital";
        if (!house1.getBuildingType().equalsIgnoreCase(buildingType)
                && house2.getBuildingType().equalsIgnoreCase(buildingType)) {
            return 1;
        } else {
            if (!house2.getBuildingType().equalsIgnoreCase(buildingType)
                    && house1.getBuildingType().equalsIgnoreCase(buildingType)) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}