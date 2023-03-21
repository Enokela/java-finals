//product type
enum Type{
    tuna,
    salt,
    eggs,
    bread
}

//Product class
 class Product {

    //variables
    private String name, brand;
    private double price, discountRate;
    private Type type;

    //constructor
    public Product(String name, String brand, double price, double discountRate, Type type) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.discountRate = discountRate;
        this.type = type;
    }


    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    //method to get discounted price
    public double discountedPrice() {

        return this.price*(100 - this.discountRate);

    }


    //toString method
    @Override
    public String toString() {

        String discountedPrice = "";

        if(discountRate > 0)
            discountedPrice = ", discounted price: " + discountedPrice();

        return "Product [name: " + name + ", brand: " + brand + ", price: " + price + ", discount rate: " + discountRate
                + ", type: " + type + discountedPrice + "]";
    }



}