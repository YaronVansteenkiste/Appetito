package be.thomasmore.appetito.model;

import jakarta.validation.constraints.NotEmpty;

public class BeverageDto {
    @NotEmpty(message = "Naam is vereist")
    private String name;

    public BeverageDto(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
