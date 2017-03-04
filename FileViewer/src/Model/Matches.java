/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Converter;
//import java.time.LocalDate;

/**
 *creates matches from line string from football_matches.txt
 * the constructor gets string line of a matches info
 * seperate string matches info to arrays of string by seperator ","
 * uses converter to set attribute in right places with right data type
 * @author madan limbu
 */
public class Matches {
    private String teamname;
    private String result;
    private String date;
    private String opponent;
    private int attendence;

    

    public Matches(String line) {
     String[] attributes = Converter.getStringAsArray(line, ",");
     this.teamname = attributes[0];
     this.result= attributes[1];
     this.date = attributes[2];
     this.opponent = attributes[3];
     this.attendence = Converter.getStringAsInt(attributes[4]);
    }
    
    
    
    
    
    
    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }
    
    //printList used when listing matches called from main
    public String printList(){
        String matches;
        
        matches = this.teamname +"\t" + this.result +"\t"+ this.date +"\t"+ this.opponent +"\t"+this.attendence;
        return matches;
    }
    
    
    
}
