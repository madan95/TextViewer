
package Model;

import java.util.ArrayList;

/**
 *Handles data objects 
 * create instance of arraylist team and matches
 * store team and matches header
 * @author madan limbu
 */
public class MainModel extends Team{
    
private static String[] teamHeader;
private ArrayList<Team> teamList = new ArrayList<>(); 
private static String[] matchesHeader;
private ArrayList<Matches> matches = new ArrayList<>();

    public MainModel(){
    }
    

    /**
     *
     * @param TeamHeader
     */
    public static void setTeamHeader(String[] TeamHeader) {
    MainModel.teamHeader = TeamHeader;
    }

    public static String[] getTeamHeader() {
        return teamHeader;
    }
    
    public void setTeamList(ArrayList<Team> teamList){
        this.teamList =teamList;
    }

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public ArrayList<Matches> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Matches> matches) {
        this.matches = matches;
    }
    
    
     public static void setMatchesHeader(String[] matchesHeader) {
       MainModel.matchesHeader = matchesHeader;
    }

    public String[] getMatchesHeader() {
        return matchesHeader;
    }
    public double getAvgCoaches(){
        double total=0;
            for(int i=0; i < this.getTeamList().size(); i++)
         {
            
            total = total+ this.getTeamList().get(i).getCoachesNumber();
         }
            total = total/this.getTeamList().size();
            return total;
    }
}

