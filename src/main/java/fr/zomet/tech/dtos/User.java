package fr.zomet.tech.dtos;

import javax.validation.constraints.NotNull;

public class User {

    private Long userId;

    private String fullName;

    @NotNull
    private Address address;

    private Email email;

    private Telephone telephone;

    public static User create() {
        User user = new User();
        user.userId = 1L;
        user.fullName = "mac carthy";
        user.address = Address.create();
        user.email = Email.create();
        user.telephone = Telephone.create();
        return user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }
}
