package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.*;

import utils.ISerializer;
import utils.OperatingSystemUtility;

import java.io.*;
import java.util.*;

import models.Tablet;



//TODO - ensure that this class implements iSerializer
public class TechnologyDeviceAPI implements ISerializer{
    //TODO - create 2 fields
    private List<Technology> technologyList;
    private File file;


    //TODO - create constructor
    public TechnologyDeviceAPI(File file){
        this.technologyList = new ArrayList<>();
    }



    //TODO - CRUD Methods
     public boolean addTechnologyDevice(Technology technology){
         for (Technology existingTech : technologyList) {
             if (existingTech.getId().equals(technology.getId())) {
                 return false;
             }
         }
         technologyList.add(technology);
         return true;
     }
    public Technology deleteTechnologyByIndex(int index){
        if (isValidIndex(index)){
            return technologyList.remove(index - 1);
        }else return null;
    }
    public boolean updateTablet(String id, Tablet updatedDetails){
        int index = -1;
        for (Technology technology : technologyList){
            index ++;
            if (technology.getId().equals(id)){
                if (technology instanceof Tablet){
                technologyList.set(index,updatedDetails);
                return true;
                }else return false;
            }
        }return false;
    }
    public boolean updateSmartWatch(String id, SmartWatch updatedDetails){
        int index = -1;
        for (Technology technology : technologyList){
            index ++;
            if (technology.getId().equals(id)){
                if (technology instanceof SmartWatch){
                    technologyList.set(index,updatedDetails);
                    return true;
                }else return false;
            }
        }return false;
    }
    public boolean updateSmartBand(String id, SmartBand updatedDetails){
        int index = -1;
        for (Technology technology : technologyList){
            index ++;
            if (technology.getId().equals(id)){
                if (technology instanceof SmartBand){
                    technologyList.set(index,updatedDetails);
                    return true;
                }else return false;
            }
        }return false;
    }


    //TODO - Number methods
    public int numberOfTechnologyByChosenManufacture(String manufacturerName){
        int count = 0;
        for (Technology technology : technologyList){
            if (manufacturerName.equals(technology.getModelName())){
                count++;
            }
        }
        return count;
    }
    public int numberOfTechnologyDevices(){
        return technologyList.size();
    }
    public int numberOfTablets(){
        int num = 0;
        for (Technology technology : technologyList){
            if (technology instanceof Tablet){
                num++;
            }
        }
        return num;
    }
    public int numberOfSmartBands(){
        int num = 0;
        for (Technology technology : technologyList){
            if (technology instanceof SmartBand){
                num++;
            }
        }
        return num;
    }
    public int numberOfSmartWatch(){
        int num = 0;
        for (Technology technology : technologyList){
            if (technology instanceof SmartWatch){
                num++;
            }
        }
        return num;
    }
    public int numberOfTechnologyByChosenManufacturer(Manufacturer manufacturer){
        int num = 0;
        for (Technology technology : technologyList){
            if (technology.getManufacturer().equals(manufacturer)){
                num++;
            }
        }
        return num;
    }

    // TODO Read/list methods
    public String listAllTechnologyDevices(){
        String tec = "";
        if (technologyList.size() != 0){
            for (Technology technology : technologyList){
                tec += technologyList.indexOf(technology) + ": " + technology + "\n";
            }
        }
        if (tec.isEmpty()){
            return "No Technology Devices";
        }
        return tec;
    }
    public String listAllSmartBands(){
        String tec = "";
        for (Technology technology : technologyList){
            if (technology instanceof SmartBand){
                tec += technologyList.indexOf(technology) + ": " + technology + "\n";
            }
        }
        if (tec.isEmpty()){
            return "“No Smart Bands";
        }
        return tec;
    }
    public String listAllSmartWatches(){
        String tec = "";
        for (Technology technology : technologyList){
            if (technology instanceof SmartWatch){
                tec += technologyList.indexOf(technology) + ": " + technology + "\n";
            }
        }
        if (tec.isEmpty()){
            return "No Smart Watches";
        }

        return tec;
    }
    public String listAllTablets(){
        String tec = "";
        for (Technology technology : technologyList){
            if (technology instanceof Tablet){
                tec += technologyList.indexOf(technology) + ": " + technology + "\n";
            }
        }
        if (tec.isEmpty()){
            return "No Tablet";
        }

        return tec;
    }
    public String listAllTechnologyAbovePrice(double price){
        String tec = "";
        for (Technology technology : technologyList){
            if (technology.getPrice() >= price){
                tec += technology + "\n";
            }
        }
        if (tec.isEmpty()){
            return "No technology more expensive than " + price;
        }

        return tec;
    }
    public String listAllTechnologyBelowPrice(double price){
        String tec = "";
        for (Technology technology : technologyList){
            if (technology.getPrice() <= price){
                tec += technology + "\n";
            }
        }
        if (tec.isEmpty()) {
            return "No technology cheaper than " + price;
        }
        return tec;

    }
    public String listAllTechDevicesByChosenManufacturer(Manufacturer manufacturer){
        String tec = "";
        for (Technology technology : technologyList){
            if (technology.getManufacturer().equals(manufacturer)){
                tec += technology + "\n";
            }
        }
        if (tec.isEmpty()){
            return "No technology manufactured by " + manufacturer;
        }
        return tec;
    }
    public String listAllTabletsByOperatingSystem(String OS) {
        if (!OperatingSystemUtility.isValidOperatingSystem(OS)) {
            return "Invalid Operating System";
        }
        String tec = "";
        for (Technology technology : technologyList) {
            if (technology instanceof Tablet) {
                if (Tablet.getOperatingSystem().equalsIgnoreCase(OS)) {
                    tec += technology + "\n";
                }
            }
        }
        if (tec.isEmpty()) {
            return "No tablet with the operating system " + OS;
        }
        return tec;
    }


    //the following is isValidId can be updated
    //to suit your code
     public boolean isValidId(String id) {
        for (Technology techDev : technologyList) {
            if (techDev.getId().equals(id))
                return false;
        }
            return true;
        }
    public boolean isValidIndex(int index){
        if (index > 0 && index <= technologyList.size() +1 ){
            return true;
        }else return false;
    }


    //TODO get Technology methods
    public Technology getTechnologyByIndex(int index){
        if (isValidIndex(index)){
            return technologyList.get(index - 1);
        }else return null;
    }
    private Technology getTechnologyDeviceById(String id){
        int count = 0;
        for (Technology technology : technologyList){
            if (id.equals(technology.getId())){
                return technologyList.get(count);
            }else count++;
        }return null;
    }

   //TODO - delete methods

    public Technology deleteTechnologyById(String id){
        int count = 0;
        if (isValidId(id)){
            for (Technology technology : technologyList){
                if (id.equals(technology.getId())){
                    technologyList.remove(count);
                    return technologyList.get(count);
                }else count++;
            }return technologyList.get(count);
        }else return null;
    }

    //TODO - sort methods
    public void sortByPriceDescending(){
        for (int i  = 0;i < technologyList.size()-1;i++ ){
            for (int j = 0;j < technologyList.size()-1-i;j++){
                if (technologyList.get(j).getPrice() <= technologyList.get(j+1).getPrice()){
                    Technology a = technologyList.get(j);
                    technologyList.set(j,technologyList.get(j+1));
                    technologyList.set(j+1,a);
                }
            }
        }
    }
    public void sortByPriceAscending(){
        for (int i  = 0;i < technologyList.size()-1;i++ ){
            for (int j = 0;j < technologyList.size()-1-i;j++){
                if (technologyList.get(j).getPrice() >= technologyList.get(j+1).getPrice()){
                    Technology a = technologyList.get(j);
                    technologyList.set(j,technologyList.get(j+1));
                    technologyList.set(j+1,a);
                }
            }
        }
    }
    public void swapTechnology (List<Technology> technologyList, int i, int j){
        Technology a = technologyList.get(i);
        technologyList.set(i,technologyList.get(j));
        technologyList.set(j,a);
    }

    //TODO Top 5 methods
    public List<Technology> topFiveMostExpensiveTechnology(){
        List<Technology> topFive = new ArrayList<>();
        sortByPriceDescending();
        for (int i = 0;i <= 4;i++){
            topFive.add(technologyList.get(i));
        }return topFive;
    }
    public List<Technology> topFiveMostExpensiveSmartWatch(){
        List<Technology> topFiveSW = new ArrayList<>();
        sortByPriceDescending();
        for (Technology technology : technologyList){
            if (technology instanceof SmartWatch){
                if (topFiveSW.size()<5){
                topFiveSW.add(technology);
            }
         }
        }return topFiveSW;
    }
    public List<Technology> topFiveMostExpensiveTablet(){
        List<Technology> topFiveT = new ArrayList<>();
        sortByPriceDescending();
        for (Technology technology : technologyList){
            if (technology instanceof Tablet){
                if (topFiveT.size()<5){
                    topFiveT.add(technology);
                }
            }
        }return topFiveT;
    }




    // TODO Persistence methods


    @Override
    public void save() throws Exception {
        XStream xStream = new XStream(new DomDriver());
        ObjectOutputStream out = xStream.createObjectOutputStream(new FileWriter("technologyDevices"));
        out.writeObject(technologyList);
        out.close();
        file = new File("technologyDevices.xml");
    }

    @Override
    public void load() throws Exception {
        Class<?>[] classes = new Class[]{models.SmartBand.class,models.SmartWatch.class,models.Tablet.class};

        XStream xStream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(classes);

        ObjectInputStream in = xStream.createObjectInputStream (new FileReader(fileName()));
        technologyList = (List<Technology>) in.readObject();
        in.close();

    }
    public String fileName(){
        return file.getName();
    }
}
