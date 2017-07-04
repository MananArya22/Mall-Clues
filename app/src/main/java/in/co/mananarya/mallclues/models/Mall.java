package in.co.mananarya.mallclues.models;

import java.util.ArrayList;

/**
 * Created by Manan Arya on 7/3/2017.
 */

public class Mall {
    private String name;
    private String id;
    private String address;
    private String description;
    private String developer;
    private String guestServices;
    private String location;
    private String phoneNumber;
    private String region;
    private String website;
    private int mallimages;

    public Mall(String name, String id, String address, String description, String developer, String guestServices, String location, String phoneNumber, String region, String website, int mallimages) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.description = description;
        this.developer = developer;
        this.guestServices = guestServices;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.website = website;
        this.mallimages = mallimages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getGuestServices() {
        return guestServices;
    }

    public void setGuestServices(String guestServices) {
        this.guestServices = guestServices;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getMallimages() {
        return mallimages;
    }

    public void setMallimages(int mallimages) {
        this.mallimages = mallimages;
    }
}
