package fr.zomet.tech.dtos;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("TELEPHONE")
public class Telephone extends ContactMedium {

    private String number;

    public Telephone() {
        this.type = Type.TELEPHONE;
    }

    public static Telephone create() {
        Telephone telephoneDto = new Telephone();
        telephoneDto.number = "0123456789";
        return telephoneDto;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
