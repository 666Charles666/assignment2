package models;

public class SmartBand extends WearableDevice{
    private boolean heartRateMonitor;
    public SmartBand(String modelName,double price,Manufacturer manufacturer,String id,String material,String size,boolean heartRateMonitor){
        super(modelName,price,manufacturer,id,material,size);
        this.heartRateMonitor = heartRateMonitor;
    }

    public double getInsurancePremium() {
        return (getPrice()*0.7);
    }

    public String connectToInternet() {
        return "Connects to the internet via Companion App"
                ;
    }
    public boolean isHeartRateMonitor(){
        return isHeartRateMonitor();
    }
    public void setHeartRateMonitor(boolean heartRateMonitor){
        this.heartRateMonitor = heartRateMonitor;

    }
    @Override
    public String toString() {
        if (heartRateMonitor){
            return super.toString()+"Includes Heart Rate Monitor"+", InsurancePremium: "+ getInsurancePremium() +", ConnectToInternet: "+ connectToInternet();
        }
        else return super.toString()+"No Heart Rate Monitor includes"+", InsurancePremium: "+ getInsurancePremium() +", ConnectToInternet: "+ connectToInternet();
    }
}
