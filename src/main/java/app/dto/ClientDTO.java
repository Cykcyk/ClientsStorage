package app.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ClientDTO {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private List<AddressDTO> addresses;

    public ClientDTO(String firstName, String lastName, String emailAddress, String phoneNumber, List<AddressDTO> dtoAddresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.addresses = dtoAddresses;
    }

    public ClientDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<AddressDTO> getAddresses() {
        return this.addresses;
    }
}

