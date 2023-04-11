package br.com.iuri.restaurantadvisorapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public final class Dress {

    private String zipCode;
    private String neighborhood;
    private String street;
    private Integer number;
}