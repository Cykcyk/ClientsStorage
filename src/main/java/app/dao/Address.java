package app.dao;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "apartment_number", nullable = false)
    private String apartmentNumber;

    @Column(name = "building_number")
    private String buildingNumber;

    @Column(name = "post_code", nullable = false)
    private String postCode;

    @Column(name = "client_id")
    private Long clientId;

    public Address(String city, String streetName, String buildingNumber, String apartmentNumber, String postCode, Long clientId) {
        this.city = city;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.postCode = postCode;
        this.clientId = clientId;
    }

    public Address() {
    }


    Long getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public Long getClientId() {
        return clientId;
    }

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;*/

}
