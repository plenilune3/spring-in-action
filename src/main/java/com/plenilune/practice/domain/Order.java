package com.plenilune.practice.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.thymeleaf.standard.processor.StandardRemoveTagProcessor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is required")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card Number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CCV")
    private String ccCVV;

    private Date placedAt;

    @ManyToOne
    private User user;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    public void fillUpTheForm(User user) {
        if (getDeliveryName() == null)
            setDeliveryName(user.getFullname());
        if (getDeliveryStreet() == null)
            setDeliveryStreet(user.getStreet());
        if (getDeliveryCity() == null)
            setDeliveryCity(user.getCity());
        if (getDeliveryState() == null)
            setDeliveryState(user.getState());
        if (getDeliveryZip() == null)
            setDeliveryZip(user.getZip());
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}
