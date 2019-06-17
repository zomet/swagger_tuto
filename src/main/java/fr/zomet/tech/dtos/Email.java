package fr.zomet.tech.dtos;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("EMAIL")
public class Email extends ContactMedium {

    public String email;

    public Email() {
        this.type = Type.EMAIL;
    }

    public static Email create() {
        Email emailDto = new Email();
        emailDto.email = "mac.carthy@ctu.org";
        return emailDto;
    }
}
