/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Converter;

/**
 *
 * @author madan limbu
 */
public class Team {
    
 private String name;
 private String[] coaches;
 private String league;
 private int division;
 private boolean fulltime;
 private String[] attributes;

 public Team(){
     
 }
 
    /**
 Create a Team from a line in a data file
     * Example line is name, coaches, league, division, fulltime
     *
     * @param fromData 
     */   
     
    public Team(String fromData){
     //first Convert String that I get from data class to String Array So we can assign string(or other datatype) to right attributes
     //To conveter any type I have created a different class name Conveter that has methods to convert (attributes) data type.
    
     attributes = Converter.getStringAsArray(fromData, ",");
     this.name = attributes[0];
     this.coaches = Converter.getStringAsArray(attributes[1]);
     this.league = attributes[2];
     this.division = Converter.getStringAsInt(attributes[3]);
     this.fulltime = Converter.getStringAsBoolean(attributes[4]);
   
 }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCoaches() {
        return coaches;
    }

    /**
     *
     * @param coaches
     */
    public void setCoaches(String[] coaches) {
        this.coaches = coaches;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public boolean isFulltime() {
        return fulltime;
    }

    public void setFulltime(boolean fulltime) {
        this.fulltime = fulltime;
    }
    
    /**
     *creates and return a string named team with all list of team info
     * because coaches has : between them so we replace all : with , so it look better....... 
     * @return
     */
    public String printList(){
        String team;
        String coachesAsString = attributes[1].replaceAll(":", ", ");//Replaces : with , to Displays coaches seperated by commas 
        team = this.name + "\t\t" +coachesAsString + "\t\t" + this.league + "\t\t" + this.division + "\t\t" + this.fulltime;
        return team;
    }
    public String getCoachesAsString(){
    String coachesAsString = attributes[1].replace(":", ", ");
    return coachesAsString;
    }

    
    public int getCoachesNumber(){
        int count = coaches.length;
        return count;
    }
    
}
