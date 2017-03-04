package View;

import Model.MainModel;
import Utils.Data;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.math.MathContext;

/**
 *
 * @author layfon
 */
public final class Frame{
    JFrame f;
    MainModel m = null;
    JScrollPane sp;
    JPanel panel2, jplPanel, panel;
    JTabbedPane tabbedPane;
    /**
     *create jframe with tabs and calls start method to create instance of mainmodel
     */
    public Frame(){
     start(); // calls start method, which will create instance of mainmodel which will contain teamlist instances
     f=new JFrame("Football Team List Application"); //create new JFrame with ok as title
     tab();// calls method that will create jtabbed pane with panel
     f.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("football.png")));
     
    JPanel panel4 = new JPanel(); // new panel to hold buttons
   // panel4.setPreferredSize(new Dimension(400,40));
    JButton n = new JButton("National");
    JButton c = new JButton("Conference");
    JButton t = new JButton("TeamList");
    //implement actionlistener on both button to listen for mouse clicks
    n.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){  
           
           //tabbedPane.setVisible(false);
           tabbedPane.setComponentAt(0, panel2= createInnerPanel2("National")); // when pressed the component at jtabbedpane (first one teamlist =0) contents in panel will be changed to national
           //createInnerPanel2 method is called and it takes national as parameter
           // the return will be jpanel with only national team
        } 
    });
    c.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
         tabbedPane.setComponentAt(0, panel2 =createInnerPanel2("Conference"));
        }
    });
        t.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
         tabbedPane.setComponentAt(0, panel2 =createInnerPanel2("TeamList"));
        }
    });
    
    panel4.add(n);// add button to panel4
    panel4.add(c);
    panel4.add(t);
   
 

   f.add(panel4, BorderLayout.SOUTH); // we use borderlayout and put the panel4 containing jbuttons in south
    
    //Get current monitor screensize
    // this will put the window in center of current monitor screen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // get current monitor dimension
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    //calculate centre of screen/monitor
    int x = (int) ((width-1500)/2);
    int y = (int) ((height-500)/2);
    //set frame in center
    f.setBounds(x, y, 1500, 500);
    f.setVisible(true);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE); //closes the application when JFrame is closed 
    }
    
   public void start(){
    Data d = new Data(); // new instance of Data 
    m = new MainModel();  // new instance of MainModel
    m.setTeamList(d.readTeam("football_teams.txt")); 
// calls mainmodel instance m method setTeamList to create new ARRAYLIST<team> and the argument will be return arraylist from data instance d method readTeam
    m.setMatches(d.readMatches("football_matches.txt"));
     }
   
//create tabbpane 
   public void tab(){
           //jtabbedpane object takes care of mouse and keyboard events 
     
    tabbedPane = new JTabbedPane(); //create a tabbed pane
    

    panel = createInnerPanel2("TeamList");//creates jpanel to show TEAMLIST table
    tabbedPane.addTab("Teamlist", panel);//adds tab/panel compoonents to tabbedpane 
        //only made for first teamlist tab because the panel on it will be changed by JButton if pressed so to revert it back to orginal we need to change panel content
	tabbedPane.addChangeListener(new ChangeListener() { //listens to tab 
                @Override
		public void stateChanged(ChangeEvent evt) {
		    JTabbedPane tabbedPane = (JTabbedPane)evt.getSource(); //get which tab was pressed/changed to
		    // Get current tab
		    int tab = tabbedPane.getSelectedIndex();
                  if(tab==0){ //if tab is first one
                 panel = createInnerPanel2("TeamList"); // put the orginal teamlist in the panel2 
                 tabbedPane.setComponentAt(0, panel); 
                  }
		}
	    });
    panel2 = createInnerPanel2("National");// Maybe iN FUTURE we can put MATCHES OF TEAM in these  tabs 
    tabbedPane.add("National", panel2);// title and component to be displayed when clicked
    panel2 = createInnerPanel2("Conference");
    tabbedPane.add("Conference",panel2);
     // ******** WE MIGHT NEED THESE EXTRA TABS IN FUTURE *******
  f.setLayout(new BorderLayout());
    f.add(tabbedPane, BorderLayout.CENTER);
    //f.setLayout(new GridLayout(1,1)); //sets layout as grid with 1,1 
    //f.add(tabbedPane); //adds tabbedpane to jframe
    
    
   }

     // method called when creating panel for tabbedpane
   //takes in parameter as national, conference or teamlist
     //takes in parameter as national, conference or teamlist
       private JPanel createInnerPanel2(String nope) {
       jplPanel = new JPanel(); //creates a new panel
       lister(nope); //lister method called which returns scrollpane sp
       jplPanel.add(sp);//scrollpane will be added to panel
        jplPanel.setLayout(new GridLayout(1,1)); // we use grid layout 
       jplPanel.setLayout(new GridLayout(1,1)); // we use grid layout 
     
        return jplPanel;
       }

          
    /**
     *This method will be called when we want to create list of jtable on jplPanel
     * we use text as parameter and the arugument can be National or Conference
     * the parameter is compared with team list and looped through teamlist only 
     * team with national or conference league will be put into jtable
     * 
     * @param text
     * @return
     */
    public JScrollPane lister(String text){
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model); //jtable with parameter of model
    
    model.addColumn("Teamname"); //colum for jtable
    model.addColumn("Coaches");
    model.addColumn("Division");
    model.addColumn("League");
    model.addColumn("Fulltime");
    model.addColumn("Number of Coaches");
    if(text.equalsIgnoreCase("TeamList")){ 
         //create row of team list using loop
            for(int i=0; i<m.getTeamList().size(); i++)
    {
    model.addRow(new Object[]{m.getTeamList().get(i).getName(), m.getTeamList().get(i).getCoachesAsString(), m.getTeamList().get(i).getDivision(), m.getTeamList().get(i).getLeague(), m.getTeamList().get(i).isFulltime(), m.getTeamList().get(i).getCoachesNumber()});
    }
                model.addRow(new Object[]{"Average of coaches", " " , " ", " ", " ", m.getAvgCoaches()});// we are couting average for whole team so we can use method m.getAvgCoaches here
    model.addRow(new Object[]{"Avg Round UP ", " " , " ", " ", " ", Math.ceil(m.getAvgCoaches())});
    }else{
    double totalCoaches =0; // counter total number of coaches who might be national or conference
    double counter =0 ; // count the total number of team 
    double averageCoaches ; 
    //create row of team list using loop
    for(int i=0; i<m.getTeamList().size(); i++)
    {
        if(m.getTeamList().get(i).getLeague().equalsIgnoreCase(text))
        {
            counter = counter +1;
            totalCoaches = totalCoaches + m.getTeamList().get(i).getCoachesNumber(); // get total coaches for national or conference
            
            model.addRow(new Object[]{m.getTeamList().get(i).getName(), m.getTeamList().get(i).getCoachesAsString(), m.getTeamList().get(i).getDivision(), m.getTeamList().get(i).getLeague(), m.getTeamList().get(i).isFulltime(),m.getTeamList().get(i).getCoachesNumber()});
        }
        else{
          //do nothing  
        }
         
    }
 
    averageCoaches = totalCoaches / counter; // calculate total average coaches for national and conference loop 
 
    
    model.addRow(new Object[]{"Average of coaches", " " , " ", " ", " ", averageCoaches});
        model.addRow(new Object[]{"Avg coaches Rounded Up", " " , " ", " ", " ", Math.ceil(averageCoaches)}); // put rounded up average of coaches for natioanl or conference in JTABLE
            }

    table.getColumnModel().getColumn(1).setMinWidth(550); //set the column size of coaches to 550 
      
   sp = new JScrollPane(table); //put the table insde scrollpane so we can scroll
   return sp; //returns scrollpane to caller
          }

}
