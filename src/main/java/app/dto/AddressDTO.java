package app.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AddressDTO {

private String city;
private String streetName;
private String buildingNumber;
private String apartmentNumber;
private String postCode;

    public AddressDTO(String city, String streetName, String buildingNumber, String apartmentNumber, String postCode) {
        this.city = city;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public AddressDTO() {
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }


}
