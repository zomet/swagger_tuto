package fr.zomet.tech.dtos;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotNull;

@JsonTypeInfo(include = JsonTypeInfo.As.EXISTING_PROPERTY, use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Telephone.class, name = "TELEPHONE"),
        @JsonSubTypes.Type(value = Email.class, name = "EMAIL")
})
public abstract class ContactMedium {

    @NotNull
    protected ContactMedium.Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {

        TELEPHONE,
        EMAIL
    }
}
