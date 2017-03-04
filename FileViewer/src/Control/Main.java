/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import View.Frame;

/**
 * Test Class calls mainmodel to create team and matches instance
 *print list of teams
 * get input form keyboard
 * compare to matches teamname iteration
 * printst out matching matches. 
 * @author madan limbu
 */
public final class Main{

 /*  
    public void printTeamList(){
        System.out.println("List of Teams : \n\n");
        for (int i=0; i<m.getTeamList().size();i++){
        System.out.println(m.getTeamList().get(i).printList());      
        }
       getInputMatches();
           }
    
   // use this to print list of matches...
    public void printMatchesList(){
    System.out.println("List of Matches : \n\n");
    for(int i=0; i<m.getMatches().size();i++){
     System.out.println(m.getMatches().get(i).printList());
    }
    }
   
    public void getInputMatches(){
        do{
            System.out.println("\t\nType the Team name to find about there matches or type allmatches ");
            System.out.println("type N for national league or type C for conference leaguet o display all matches or type exit to exit:");
            j = new Scanner(System.in);
            String input = j.nextLine();
            System.out.println("----------------------------------------------------------");
            
        if(input.equalsIgnoreCase("allmatches"))
            {
                printMatchesList();
                System.out.println("----------------------------------------------------------");
            }
        
        else if(input.equalsIgnoreCase("n"))
            {
                for(int x = 0; x < m.getTeamList().size(); x++ )
                {
                    if(m.getTeamList().get(x).getLeague().equalsIgnoreCase("National"))
                        {
                            System.out.println(m.getTeamList().get(x).getName() + "::::" + m.getTeamList().get(x).getLeague() );
                        }
                }
                System.out.println("----------------------------------------------------------");
            }
        
                else if(input.equalsIgnoreCase("c"))
            {
                for(int x = 0; x < m.getTeamList().size(); x++ )
                {
                    if(m.getTeamList().get(x).getLeague().equalsIgnoreCase("Conference"))
                        {
                            System.out.println(m.getTeamList().get(x).printList());
                        }
                }
                System.out.println("----------------------------------------------------------");
            }
                    
        else if(input.equalsIgnoreCase("exit"))
        {
            System.exit(0);
        }
        
        else
        {
            for (int i=0; i<m.getMatches().size();i++) 
                {//go through all matches
                    if(m.getMatches().get(i).getTeamname().equalsIgnoreCase(input))
                        { //iteration, if matches teamname is sanme as input , Prints out matching teamname Matches
                            System.out.println(m.getMatches().get(i).printList());
                        } 
                }
            System.out.println("----------------------------------------------------------");
        }
     }while(true);//process repeats until system exit
    }
        
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
       Frame f = new Frame();   
    }

  
   
    
    

   
    
}
