
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 

import javax.swing.*;

public class SeaPortProgram extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 000000000000;
	private World world = new World();
	JFileChooser chooser = new JFileChooser(".");
	JPanel sortPanel = new JPanel();
	JTabbedPane tabPane = new JTabbedPane();
	JTextArea openTextArea = new JTextArea(20,100);
	JScrollPane scrollPane = new JScrollPane(openTextArea);
	JPanel openPanel =  new JPanel();
	JPanel openSelectPanel = new JPanel();
	JPanel openDisplayPanel = new JPanel();
	JPanel buttonPane = new JPanel();
	JPanel labelPane = new JPanel();
	JButton openFileButton = new JButton ("Open");
	JLabel openChosenFileLabel = new JLabel ("Select a File");
	JLabel openFileLabel = new JLabel("File Name");
	JPanel searchPanel =  new JPanel();
	JPanel searchSelectPanel = new JPanel();
	JLabel searchLabel = new JLabel("Search");
	JPanel searchDisplayPanel = new JPanel();
	JTextArea searchTextArea = new JTextArea(20,40);
	JButton searchButton = new JButton("Search");
	String[] choices = new String[] {"Name", "Index","Skill"};
	String[] sortName = new String[] {"","Port","Dock","Ship", "Queue", "Person", "Job"};
	String[] sortOptions = new String[] {};
	JLabel sortLabel = new JLabel("Sort By:");
	JLabel sortPortLabel = new JLabel("Port By:");
	JLabel sortDockLabel = new JLabel("Dock By:");
	JLabel sorShipLabel = new JLabel("Ship By:");
	JLabel sortQueueLabel = new JLabel("Queue By:");
	JLabel sortPersonLabel = new JLabel("Person By:");
	JLabel sortJobLabel = new JLabel("Job By:");
	JComboBox<String> options = new JComboBox<String>(choices);
	JComboBox<String> sortThing = new JComboBox<String>(sortName);
	JComboBox<String> sortChoice = new JComboBox<String>(sortOptions);
	JButton sortButton = new JButton("Sort");
	JTextField searchTextBox = new JTextField(20); 
	String fileName;

	
	public SeaPortProgram() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
       //sort Panel
       // add(sortPanel,BorderLayout.NORTH);
        
    		//tabs
        add(tabPane);
    		tabPane.add("Open", openPanel);
        tabPane.add("Search", searchPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //open tab
        //top pane - select
        openPanel.add(openSelectPanel, BorderLayout.NORTH);
        openSelectPanel.setLayout(new BoxLayout(openSelectPanel,BoxLayout.PAGE_AXIS));
        openSelectPanel.add(openFileLabel);
        openSelectPanel.add(openFileButton);
        openSelectPanel.add(Box.createRigidArea(new Dimension(0,5)));
        openSelectPanel.add(labelPane);
        labelPane.setLayout(new BoxLayout(labelPane,BoxLayout.LINE_AXIS));
        labelPane.add(sortPortLabel);
        labelPane.add(Box.createRigidArea(new Dimension(35, 0)));
        labelPane.add(sortDockLabel);
        openSelectPanel.add(buttonPane);
        
        buttonPane.setLayout(new BoxLayout(buttonPane,BoxLayout.LINE_AXIS));
        buttonPane.add(sortLabel);
        buttonPane.add(sortThing);
        buttonPane.add(sortChoice);
        buttonPane.add(sortButton);
        sortThing.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
		        String selected = (String) sortThing.getSelectedItem();
		        
		        switch (selected) {
		       
		        	
		        case "Port":
		        	sortChoice.removeAllItems();
		        	sortChoice.addItem("Name");
		        	break;
		        	
		        
		        case "Ship":
		        	sortChoice.removeAllItems();
		        	sortChoice.addItem("Name");
		        	break;
		        	
		        case "Queue":
		        	sortChoice.removeAllItems();
		        	sortChoice.addItem("Name");
		        	sortChoice.addItem("Weight");
		        	sortChoice.addItem("Length");
		        	sortChoice.addItem("Width");
		        	sortChoice.addItem("Draft");
		        	break;
		        	
		        case "Person":
		        	sortChoice.removeAllItems();
		        	sortChoice.addItem("Name");
		        	break;
		        	
		        case "Job":
		        	sortChoice.removeAllItems();
		        	sortChoice.addItem("Name");
		        	break;
		        	
		        	default:
		        		break;
		        }
            }
        });
	
        sortButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            		Object thingObj = sortThing.getSelectedItem();
                Object choiceObj = sortChoice.getSelectedItem();
                 
                String thingString = "" + thingObj;
                String  choiceString = "" + choiceObj;
                
                world.sort(thingString, choiceString);
                printResults();
      
            }
        });   
            
        //bottom pane - display
        openPanel.add(openDisplayPanel, BorderLayout.CENTER);
        openDisplayPanel.add(scrollPane, BorderLayout.CENTER);
        openFileButton.addActionListener(this);
        //bottom pane - text area
        openTextArea.setText("Results");
        openTextArea.setLineWrap(true);
        openTextArea.setEditable(false);
        openTextArea.setWrapStyleWord(true);
        openTextArea.setFont (new java.awt.Font ("Monospaced", java.awt.Font.PLAIN, 12));

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //search tab
        
        searchPanel.add(searchSelectPanel);
        searchPanel.add(searchDisplayPanel);
        searchSelectPanel.add(searchLabel);
        searchSelectPanel.add(options);
        searchSelectPanel.add(searchTextBox);    
        searchSelectPanel.add(searchButton);
        searchDisplayPanel.add(searchTextArea);
        searchButton.addActionListener(this);
        setVisible(true);
	}

	public static void main(String[] args) {
		SeaPortProgram program = new SeaPortProgram();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		
		if (com.equals("Open")) {
	        // invoke the showsSaveDialog function to show the save dialog
	        int save = chooser.showOpenDialog(null);
 
            if (save == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected directory
            		fileName = chooser.getSelectedFile().getAbsolutePath();
            		openChosenFileLabel.setText(fileName);
            		try {
					parseFile(fileName);
					printResults();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            
            // if the user cancelled the operation
            else
                openChosenFileLabel.setText("the user cancelled the operation");
        }
        else if(com.equals("Search")){
        		String searchText = searchTextBox.getText();
        		String searchType = (String) options.getSelectedItem();
        		ArrayList<Thing> results = search(searchText, searchType);
        		
        		// display results in the GUI
        		String strResults = "";
        		for (Thing result : results) {
        			strResults += "\n"+ result.toSimpleString();
        		}
        		searchTextArea.setText(strResults);
        }
	}
	
	private void parseFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		ArrayList<String> listLines = new ArrayList<>();
		
		//create hashmaps shipByIndex and dockByIndex
		HashMap <Integer, SeaPort> portByIndex = new HashMap<Integer, SeaPort>();
		HashMap <Integer, Dock> dockByIndex = new HashMap<Integer, Dock>();
		
		while (scanner.hasNext()) {
		    String line = scanner.nextLine();
		    listLines.add(line);
		}
		//pass both hashmaps into parse line 
		for (String line : listLines) {
			parseLine(line, portByIndex, dockByIndex);
		}
	}
	//populate hashmap
	//add new ports and dock to respective hashmaps
	
	//use the hashmaps instead of getDock and getPort
	private void parseLine(String line, HashMap <Integer, SeaPort> portByIndex, HashMap <Integer, Dock> dockByIndex) {
		//System.out.println("Processing >" + line + "<");

		Scanner scanner = new Scanner(line);
		
		
		if (!scanner.hasNext())
			return;			

		switch (scanner.next()) {
		case "port":
			SeaPort seaPort = new SeaPort(scanner);
			world.addPort(seaPort);
			portByIndex.put(seaPort.getIndex(), seaPort);
			break;
			
		case "dock":
			Dock dock = new Dock(scanner);
			// find the parent port
			SeaPort portForDock = portByIndex.get(dock.getParent());
			//add the dock to the port
			portForDock.addDock(dock);
			dockByIndex.put(dock.getIndex(), dock);
			break;
			
		case "pship":
			//Create a pship
			PassangerShip pass = new PassangerShip(scanner);
			int pParentIndex = pass.getParent();
			SeaPort portForPassShip = portByIndex.get(pParentIndex);
			if(portForPassShip != null) {
				portForPassShip.addShipToQue(pass);
			}
			else {
				// find dock and port
				Dock dockForPassShip = dockByIndex.get(pParentIndex);
				SeaPort portForThisDock = portByIndex.get(dockForPassShip.getParent());
				// add ship to dock and port
				dockForPassShip.setShip(pass);
				portForThisDock.addShip(pass);
			}
			break;

		case "cship":
			//create a cship
			CargoShip cargo = new CargoShip(scanner);
			//find the dock or the port
			int cParentIndex = cargo.getParent();
			SeaPort portForCargoShip = portByIndex.get(cParentIndex);
			if (portForCargoShip != null) {
				portForCargoShip.addShipToQue(cargo);
			}
			else {
				// find dock and port
				Dock dockForCargoShip = dockByIndex.get(cParentIndex);
				SeaPort portForThisDock = portByIndex.get(dockForCargoShip.getParent());
				// add ship to dock and port
				dockForCargoShip.setShip(cargo);
				portForThisDock.addShip(cargo);
			}
						
			break;
		
		case "person":
			Person person = new Person(scanner);
			SeaPort portForPerson = portByIndex.get(person.getParent());
			portForPerson.addPerson(person);
			break;
		
		case "job":
			//optional until project 3
			break;
		
		default:
			// skip
			break;
		}
	}
	
	private void printResults() {
		openTextArea.setText(world.toString());
	}
	
	// text: the text the user entered
	// type: one of "Index", "Name", or "Skill"
	private ArrayList<Thing> search(String text, String type) {
		ArrayList<Thing> empty = new ArrayList<Thing>();

		switch(type) {
		case "Index":
			int index = Integer.parseInt(text);
			return world.searchByIndex(index);
		
		case "Name":
			return world.searchByName(text);
			
		case "Skill":
			return world.searchBySkill(text);
			
		default:
			return empty;
		}
		
	}
	protected void displayAlert(String msg){
        JOptionPane.showMessageDialog(
                null,
                msg,
                "Message",
                JOptionPane.PLAIN_MESSAGE);
	}
}