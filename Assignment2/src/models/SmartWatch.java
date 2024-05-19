package models;
import utils.DisplayTypeUtility;
public class SmartWatch extends WearableDevice{
    private String displayType;
    public SmartWatch(String modelName,double price,Manufacturer manufacturer,String id,String material,String size,boolean heartRateMonitor,String displayType){
        super(modelName,price,manufacturer,id,material,size);
        setDisplayType(displayType);
    }
    public void setDisplayType(String displayType) {
        if (DisplayTypeUtility.isValidDisplayType(displayType)) {
            this.displayType = displayType;
        } else
            this.displayType = "LCD";
    }
    public String getDisplayType(){
        return displayType;
    }
    public double getInsurancePremium(){
        return (getPrice()* .06);
    }
    public String connectToInternet(){
        return "Connects to the internet via bluetooth";

    }
    @Override
    public String toString() {
        return super.toString() +"Material: "+getMaterial()+", Size: " + getSize()+ ", DisplayType: "+displayType
                +", InsurancePremium: "+ getInsurancePremium() +", ConnectToInternet: "+ connectToInternet();
    }
}
