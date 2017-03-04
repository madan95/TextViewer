/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import Model.MainModel;
import Model.Matches;
import Model.Team;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *reads file from football_matches and football_matches
 *returns arraylist of team or matches
 * store header and calls mainmodel to store header (setHeader)
 * removes header from arraylist (0)
 * creates and call team and matches constructor with parameter of string(matches or team line)
 * 
 * 
 * @author madan limbu
 */
public class Data {
    public Data(){
        
    }
            
            
    public ArrayList<String> readTextFile(String txtFile){
        ArrayList<String> result = new ArrayList<>();
        try{
        BufferedReader inputFile = new BufferedReader(new FileReader(txtFile));
        while(inputFile.ready()){
            String nextLine = inputFile.readLine();//read line by line and put inputFile to nextLine String
            nextLine = nextLine.trim(); // Removes white spaces from leading and trailing String
            result.add(nextLine); //add every String nextline(team + header) to ArrayList<String> result
        }
        inputFile.close();//close the buffer reader
        }catch(IOException e){
         System.out.println(e );
        }
        return result;//returns ArrayList<String> 
    }
    
    /**
     *
     * @param txtFile
     * @return
     */
    public ArrayList<Team> readTeam(String txtFile){
        ArrayList<Team> teamList = new ArrayList<>();// create teamList to store List of Team
        try{
          
             ArrayList<String> teamAsString = readTextFile(txtFile);//calls readTextFile method with .txt file name(txtFile) as parameter
            String[] teamHeader = teamAsString.get(0).split(","); // gives 5 String array for header(i.e Name, Coaches...), First line or arraylist (0) is headers seperated by ","
            MainModel.setTeamHeader(teamHeader);//passes TeamHeader to MainModel
            teamAsString.remove(0); // removes TeamHeader from ArrayList<String> teamAsString
            
            for(String line: teamAsString){
                Team oneTeam = new Team(line);//Creates Team for each line of data from .txt file, uses String line as constructor data type
                teamList.add(oneTeam);//adds every team to teamList (arraylist)
            }
        }catch(Exception e){
            System.out.println(e) ;
        }
        return teamList;//returns every teamList class that called the method
    }
    
    public ArrayList<Matches> readMatches(String txtFile){
     ArrayList<Matches> matchesList = new ArrayList<>();
     try{
         ArrayList<String> matchesAsString = readTextFile(txtFile);
         String[] matchesHeader = matchesAsString.get(0).split(",");
         MainModel.setMatchesHeader(matchesHeader);
         matchesAsString.remove(0);
         
         for(String line: matchesAsString){
             Matches oneMatch = new Matches(line);
             matchesList.add(oneMatch);
             
         } 
     }catch (Exception e){
         System.out.println(e);
     }
     
     
     return matchesList;
        
    }

    
}