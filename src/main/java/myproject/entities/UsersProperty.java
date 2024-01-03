package myproject.entities;

public class UsersProperty {
    public String propertyType;
    public double price;
    public String location;
    public int bathrooms;
    public int bedrooms;
    public boolean garage;
    public int floor;

    public UsersProperty(String propertyType, double price, String location,
                         int bathrooms, int bedrooms, boolean garage, int floor) {
        this.propertyType = propertyType;
        this.price = price;
        this.location = location;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.garage = garage;
        this.floor = floor;
    }

}
