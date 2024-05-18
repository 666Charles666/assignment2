package controllers;

import models.*;

import utils.ISerializer;
import utils.OperatingSystemUtility;

import utils.Utilities;

import java.io.*;
import java.util.*;
import controllers.ManufacturerAPI;



//TODO - ensure that this class implements iSerializer
public class TechnologyDeviceAPI implements ISerializer{
    //TODO - create 2 fields
    private List<Technology> technologyList;
    private File file;


    //TODO - create constructor
    public TechnologyDeviceAPI(){
        this.technologyList = new ArrayList<>();
    }



    //TODO - CRUD Methods
     public boolean addTechnologyDevice(Technology technology){
        return technologyList.add(technology);
     }
    public Technology deleteTechnologyByIndex(int index){
        if (isValidIndex(index)){
            return technologyList.remove(index - 1);
        }else return null;
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

    // TODO Read/list methods
    public String listAllTechnologyDevices(){
        String tec = "";
        if (technologyList.size() != 0){
            for (Technology technology : technologyList){
                tec += technologyList.indexOf(technology) + ": " + technology + "\n";
            }
            return tec;
        }return "No Technology Devices";
    }
    public String listAllSmartBands(){
        String tec = "";
        for (Technology technology : technologyList){
            if (technology instanceof SmartBand){
                tec += technologyList.indexOf(technology) + ": " + technology + "\n";
            }return tec;
        }return "“No Smart Bands";
    }
    public String listAllSmartWatches(){
        String tec = "";
        for (Technology technology : technologyList){
            if (technology instanceof SmartWatch){
                tec += technologyList.indexOf(technology) + ": " + technology + "\n";
            }return tec;
        }return "No Smart Watches";
    }
    public String listAllTablets(){
        String tec = "";
        for (Technology technology : technologyList){
            if (technology instanceof Tablet){
                tec += technologyList.indexOf(technology) + ": " + technology + "\n";
            }return tec;
        }return "No Tablet";
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

    //TODO Top 5 methods





    // TODO Persistence methods


    @Override
    public void save() throws Exception {

    }

    @Override
    public void load() throws Exception {

    }
    public String fileName(){

    }
}
