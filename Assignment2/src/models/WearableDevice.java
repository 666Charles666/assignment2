package models;

public abstract class WearableDevice extends Technology{
    private String material;
    private String size;
    public WearableDevice(String modelName,double price,Manufacturer manufacturer,String id,String material,String size){
        super(modelName, price, manufacturer, id);
        setMaterial(material);
        setSize(size);

    }
    public void setMaterial(String material){
        if (material.length() <= 20){
            this.material = material;
        }
    }
    public String getMaterial(){
        return material;
    }
    public void setSize(String size){
        if (size.length() <= 10){
            this.size = size;
        }
    }
    public String getSize(){
        return size;
    }


}
