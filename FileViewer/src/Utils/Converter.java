/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;

/**
 *Converts data type
 * @author madan limbu
 */
public class Converter {
   

    
    //called by Team to seperate out String to array of String and seperator in team case is ","
    public static String[] getStringAsArray(String fromData, String seperator){
        String[] result = fromData.split(seperator);
        return result;
        
    }
    
    /**
     *
     * @param coaches
     * @return
     */
    public static String[] getStringAsArray(String coaches){
        return getStringAsArray(coaches, ":"); 
        //we use the method getStringAsArray to split coaches String into String array and seperator is  ":" . 
        }
  


    /**
     *Converts String from Team.division to Integer 
     * @param attribute
     * @return
     */
    public static int getStringAsInt(String attribute) {
    int division= Integer.parseInt(attribute);
        return division;
    }
    
    
    public static boolean getStringAsBoolean(String attribute) {
        return attribute.equalsIgnoreCase("yes"); //if attribute is yes then it will return true , anything else it will return false
    }

  /*  not needed atm 
    public static String getArrayAsString(String[] coaches){
        String result =" ";
        for(String s: coaches){
            result += s + s + " ";
        }
        //result = result.trim();
        return result;
    }
*/
     //java 8 uses LocaleDate
    /**
     *
     * @param attribute
     * @return
     */
    /*
    public static LocalDate getStringAsDate(String attribute){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        // uses only date and not time
        LocalDate date = null;
        try{
        date = LocalDate.parse(attribute, format);
                 }catch(Exception e){
            
        }
        return date;
    }*/
    }
