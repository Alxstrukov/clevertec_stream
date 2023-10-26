package by.clevertec.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Unit {
    private int age;
    private String buildingType;
    private Person person;
}
