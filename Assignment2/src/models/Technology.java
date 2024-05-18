package models;

public abstract class Technology {
    private Manufacturer manufacturer;
    private String id = "unknown";
    private  String modelName;
    private double price = 20;

    public Technology(String modelName,double price,Manufacturer manufacturer,String id){
        setModelName(modelName);
        setPrice(price);
        setManufacturer(manufacturer);
        setId(id);
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && id.length() <= 10){
            this.id = id;
        }else {
        this.id = "unknown";
        }
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        if (id != null && modelName.length() <= 30) {
            this.modelName = modelName;
        }else {
        this.modelName = "unknown";
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 20){
        this.price = price;
        }else {
            this.price = 20;
        }
    }
    public abstract double getInsurancePremium();
    public abstract String connectToInternet();
    public String toString(){
        return "Model: " + modelName + ", Price: €" + price + ", Manufacturer Details: " + manufacturer + ", ID: " + id;
    }
}
