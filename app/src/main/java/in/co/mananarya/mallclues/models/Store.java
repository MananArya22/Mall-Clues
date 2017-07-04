package in.co.mananarya.mallclues.models;

/**
 * Created by Manan Arya on 7/4/2017.
 */

public class Store {
    private String name;
    private String address;
    private String category;
    private String description;
    private String mallid;
    private String offers;
    private String phonenumber;
    private String region;
    private String storeid;

    public Store(String name, String address, String category, String description, String mallid, String offers, String phonenumber, String region, String storeid) {
        this.name = name;
        this.address = address;
        this.category = category;
        this.description = description;
        this.mallid = mallid;
        this.offers = offers;
        this.phonenumber = phonenumber;
        this.region = region;
        this.storeid = storeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMallid() {
        return mallid;
    }

    public void setMallid(String mallid) {
        this.mallid = mallid;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }
}
