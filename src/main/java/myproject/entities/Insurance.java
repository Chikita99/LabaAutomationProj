package myproject.entities;

public class Insurance {
    private int price;
    private String areaOfInsurance;
    private String name;
    private boolean discount;

    public Insurance(int price, String areaOfInsurance, String name, boolean discount) {
        this.price = price;
        this.areaOfInsurance = areaOfInsurance;
        this.name = name;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "[Price per m2: $" + price + ", Which States can be insured: " + areaOfInsurance +  " Company Name: " + name + ", Discount: " + (discount ? "Да" : "Нет") + "]";
    }
}
