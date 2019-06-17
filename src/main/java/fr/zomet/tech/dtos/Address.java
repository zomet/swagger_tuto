package fr.zomet.tech.dtos;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel(value = "Address")
public class Address {

    @Min(1)
    @Max(100)
    public int number;

    @Size(min = 5, max = 255)
    public String streetName;

    @Pattern(regexp = "[0-9]{5}")
    public String postalCode;


    public static Address create() {
        Address address = new Address();
        address.number = 1;
        address.streetName = "rue mac carthy";
        address.postalCode = "77210";
        return address;
    }

}
