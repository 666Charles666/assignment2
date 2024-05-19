package models;

public abstract class ComputingDevice extends Technology{
    private int storage;
    private String processor;
    public ComputingDevice(String modelName,double price,Manufacturer manufacturer,String id,int storage,String processor){
        super(modelName,price,manufacturer,id);
        setStorage(storage);
        setProcessor(processor);
    }
    public void setStorage(int storage){
        if (storage <= 128 && storage >= 8 && storage % 8 ==0){
            this.storage = storage;
        }
    }
    public void setProcessor(String processor) {
        if (processor.length() <= 20) {
            this.processor = processor;
        }
    }
    public int getStorage(){
        return storage;
    }
    public String getProcessor(){
        return processor;
    }
    @Override
    public String toString() {
        return super.toString()+"Processor: "+processor+", Storage: "+storage+"GB";
    }
}
