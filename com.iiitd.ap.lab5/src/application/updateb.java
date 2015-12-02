package application;
/**
 * Siddharth Singh
 * 2014105
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class updateb {

    @FXML
    private Button updatebtn;

    @FXML
    private Tab addtab1;

    @FXML
    private Tab piechar;

    @FXML
    private TextField budgetvalue;

    @FXML
    private Button addbtn;

    @FXML
    private Tab recordtab1;

    @FXML
    private TabPane mytabpane;

    @FXML
    private TextField catview;

    @FXML
    private Label rectotal;

    @FXML
    private TableColumn<Expense,String> datecol;

    @FXML
    private TableColumn<Expense,String> catcol;

    @FXML
    private DatePicker dateview;

    @FXML
    private Label updatetext;
    
    @FXML
    private PieChart piec;

    @FXML
    private Label totalbview;

    @FXML
    private TextField amountview;

    @FXML
    private TableColumn<Expense, Integer> amcol;

    @FXML
    private Label availbview;

    @FXML
    private Label addresult;

    @FXML
    private TableView<Expense> table;

    @FXML
    private Label exptotal;
    
	public void addcategory(LocalDate localDate, String cate, String am)
	{
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./src/Expenses.txt", true)))) {
			out.println("\n"+cate + " "+ "Rs." + am + " " +localDate);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void updateavail(String value)
	{
		
			File originalFile = new File("./src/Expenses.txt");
	        BufferedReader br;
	        File tempFile = new File("tempfile.txt");
	        PrintWriter pw;
			try {
				br = new BufferedReader(new FileReader(originalFile));

				pw = new PrintWriter(new FileWriter(tempFile));
	        String line = null;
	  
				while ((line = br.readLine()) != null) {

				    if (line.contains("Available")) {
				        String strCurrentSalary = line.substring(line.lastIndexOf(" "), line.length());
				        if (strCurrentSalary != null || !strCurrentSalary.trim().isEmpty())
				        {
				            line = line.substring(0,line.lastIndexOf(" ")) + value;
				        }
				    }
				        pw.println(line);
					    pw.flush();
				    
				   
				   
				}
				 pw.close();
			        br.close();
			}
			catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
			
	       

	        if (!originalFile.delete()) {
	            System.out.println("Could not delete file");
	            return;
	        }

	        if (!tempFile.renameTo(originalFile))
	            System.out.println("Could not rename file");
	}
	public void upd(String value)
		{
		File originalFile = new File("./src/Expenses.txt");
        BufferedReader br;
        File tempFile = new File("tempfile.txt");
        PrintWriter pw;
		try {
			br = new BufferedReader(new FileReader(originalFile));

			pw = new PrintWriter(new FileWriter(tempFile));
        String line = null;
  
			while ((line = br.readLine()) != null) {

			    if (line.contains("Budget")) {
			        String strCurrentSalary = line.substring(line.lastIndexOf(" "), line.length());
			        if (strCurrentSalary != null || !strCurrentSalary.trim().isEmpty())
			        {
			            line = line.substring(0,line.lastIndexOf(" ")) + value;
			        }
			        pw.println(line);
				    pw.flush();
			    }
			    else if(line.contains("Available"))
			    {
			    	line = line.substring(0,line.lastIndexOf(" ")) + value;
			    	pw.println(line);
			    	pw.flush();
			    }
			   
			   
			}
			 pw.close();
		        br.close();
		}
		catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		
       

        if (!originalFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        if (!tempFile.renameTo(originalFile))
            System.out.println("Could not rename file");
		}


    @FXML
    void updatebudg(ActionEvent event) {
    	if(budgetvalue.getLength()==0)
    	{
    		updatetext.setText("Please enter a value");
    	}
    	else
    	{
    		updatetext.setText("Entered!");
    		upd(" Rs."+budgetvalue.getText());
    		Main.budget=Integer.parseInt(budgetvalue.getText());
    		Main.avail=Integer.parseInt(budgetvalue.getText());
    		totalbview.setText("Rs."+Integer.toString(Main.budget));
    		availbview.setText("Rs."+Integer.toString(Main.avail));
    		budgetvalue.setText("");

    	}

    }
    @FXML
    void addex(ActionEvent event) {
    	if(catview.getLength()==0 || dateview.getValue()==null | amountview.getLength()==0)
    	{
    		addresult.setText("Enter values!");
    	}
    	if(Main.avail<Integer.parseInt(amountview.getText()))
    	{
    		addresult.setText("Please enter a lower value");
    	}
    	else
    	{
    		addcategory(dateview.getValue(),catview.getText(), amountview.getText());
    		addresult.setText("Added!");
    		Main.avail=Main.avail-Integer.parseInt(amountview.getText());
    		updateavail(" Rs."+ Main.avail);
    		availbview.setText("Rs."+Integer.toString(Main.avail));
    		dateview.setValue(null);
    		catview.setText("");
    		amountview.setText("");
    	}
    }
    @FXML
    void addtab(Event event)
    {
    	totalbview.setText("Rs."+Integer.toString(Main.budget));
		availbview.setText("Rs."+Integer.toString(Main.avail));
		addresult.setText("");
    }
    @FXML
    void uptab(Event event)
    {
    
    	updatetext.setText("");
    }
    ObservableList<Expense> getdatafromfile() {
        ObservableList<Expense> allData = FXCollections.observableArrayList();
        BufferedReader buffr = null;
    	String line;
    	int i =0;
    	try {
    		i++;
    		buffr = new BufferedReader(new FileReader("./src/Expenses.txt"));
    		while ((line = buffr.readLine()) != null) 
    		{
    			String[] data = line.split(" ");
    			//System.out.println("asasasas");
    			{
    				if(i>=3)
    				{
    					//System.out.println(data[0]);
    					try{
    						allData.add(new Expense(data[0], Integer.parseInt(data[1].replaceAll("\\D+","")), data[2]));
    					}
    					catch(Exception e){
	
    					}
    				}
    			}
    			i++;
    		}

    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    
        return allData;
    }
    ObservableList<PieChart.Data> getdataforpie() {
        ObservableList<PieChart.Data> allData = FXCollections.observableArrayList();
        HashMap<String, Integer> piedata = new HashMap<>();
        BufferedReader buffr = null;
    	String line;
    	int i =0;
    	try {
    		i++;
    		buffr = new BufferedReader(new FileReader("./src/Expenses.txt"));
    		while ((line = buffr.readLine()) != null) 
    		{
    			String[] data = line.split(" ");
    			//System.out.println("asasasas");
    			{
    				if(i>=3)
    				{
    					//System.out.println(data[0]);
    					try{
//    						allData.add(new PieChart.Data(data[0],Integer.parseInt(data[1].replaceAll("\\D+",""))));
    						Iterator entries = piedata.entrySet().iterator();
    						int flag = 0;
    						while (entries.hasNext()) {
    						  Entry thisEntry = (Entry) entries.next();
    						  String key = (String) thisEntry.getKey();
    						  int value = (int) thisEntry.getValue();
    						  if(key.equals(data[0]))
    						  {
    							  piedata.put(key, value + Integer.parseInt(data[1].replaceAll("\\D+","")));
    							  flag=1;
    						  }
    						}
    						if(flag==0)
    						{
    							piedata.put(data[0],Integer.parseInt(data[1].replaceAll("\\D+","")));
    						}
    				
    					}
    					catch(Exception e){
	
    					}
    				}
    			}
    			i++;
    		}
    		Iterator entries = piedata.entrySet().iterator();
    		while (entries.hasNext()) {
				  Entry thisEntry = (Entry) entries.next();
				  String key = (String) thisEntry.getKey();
				  int value = (int) thisEntry.getValue();
				  allData.add(new PieChart.Data(key,value));
    		}
				  

    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	allData.add(new PieChart.Data("Unspent",Main.avail));
        return allData;
    }
    @FXML
    void recordtab(Event event)
    {
    	//final ObservableList<Expense> data = FXCollections.observableArrayList(new Expense("Jacob", 10,"adad"), new Expense("Isabella",11, "Johnson"));
        //table.setItems(data);
    	rectotal.setText("Rs."+Integer.toString(Main.budget));
		exptotal.setText("Rs."+Integer.toString(Main.budget-Main.avail));
    	ObservableList<Expense> data = getdatafromfile();
        table.setEditable(true);
        catcol.setCellValueFactory(new PropertyValueFactory<Expense,String>("category"));
        amcol.setCellValueFactory(new PropertyValueFactory<Expense,Integer>("amount"));
        datecol.setCellValueFactory(new PropertyValueFactory<Expense,String>("dt"));
        table.setItems(data);
    }
   public void showChart(Event event)
    {

			ObservableList<PieChart.Data> data = getdataforpie();
	         
	        piec.setTitle("Monthly Record");
	        piec.setData(data);
	
    }
    
}
