package models;

import utils.OperatingSystemUtility;

public class Tablet extends Technology{
    private static String operatingSystem;
    public Tablet(String modelName, double price, Manufacturer
            manufacturer, String id, String processor, int storage, String
                          operatingSystem){
        super(modelName,price,manufacturer,id);
        setOperatingSystem(operatingSystem);
    }
    public void setOperatingSystem(String operatingSystem){
        if (OperatingSystemUtility.isValidOperatingSystem(operatingSystem)){
            this.operatingSystem = operatingSystem;
        }
        else
            this.operatingSystem = "windows";
    }
    public static String getOperatingSystem(){
        return operatingSystem;
    }
    public double getInsurancePremium(){
        return (getPrice()* .01);
    }
    public String connectToInternet(){
        return
                "Connects to the internet via Wi-Fi";

    }
    @Override
    public String toString() {
        return super.toString()+"Operating System: "+operatingSystem+", Insurance Premium: €"+getInsurancePremium();
    }

}
