import javax.swing.*;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Node;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import java.awt.*; 
import java.awt.event.*; 

class ui_swing<E> extends JFrame implements ActionListener { 
	

	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel fname; 
	private JTextField tname; 
	private JLabel lname; 
	private JTextField tlname; 
	private JLabel gender; 
	private JLabel city;
	private JTextField tcity;
	private JLabel state;
	private JTextField tstate;
	private JRadioButton male; 
	private JRadioButton female; 
	private ButtonGroup gengp;   
	private JLabel add; 
	private JTextArea tadd; 
	private JCheckBox term; 
	private JButton sub; 
	private JButton reset; 
	private JTextArea tout; 
	private JLabel res; 
	private JTextArea resadd;
	private JTable table;
	static String line="",str="";




	// constructor, to initialize the components 
	// with default values. 
	public ui_swing() 
	{ 
		
		setTitle("Registration Form"); 
		setBounds(300, 90, 900, 600); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Registration Form"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(300, 30); 
		title.setLocation(300, 30); 
		c.add(title); 

		fname = new JLabel("First Name"); 
		fname.setFont(new Font("Arial", Font.PLAIN, 20)); 
		fname.setSize(100, 20); 
		fname.setLocation(100, 100); 
		c.add(fname); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(190, 20); 
		tname.setLocation(200, 100); 
		c.add(tname); 

		lname = new JLabel("Last Name"); 
		lname.setFont(new Font("Arial", Font.PLAIN, 20)); 
		lname.setSize(100, 20); 
		lname.setLocation(100, 150); 
		c.add(lname); 

		tlname = new JTextField(); 
		tlname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tlname.setSize(150, 20); 
		tlname.setLocation(200, 150); 
		c.add(tlname); 

		add = new JLabel("Address"); 
		add.setFont(new Font("Arial", Font.PLAIN, 20)); 
		add.setSize(100, 20); 
		add.setLocation(100, 300); 
		c.add(add); 
		
		tadd = new JTextArea(); 
	    tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
	    tadd.setSize(200, 75); 
	    tadd.setLocation(200, 300); 
	    tadd.setLineWrap(true); 
	    c.add(tadd); 
		
		
		gender = new JLabel("Gender"); 
		gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
		gender.setSize(100, 20); 
		gender.setLocation(100, 200); 
		c.add(gender); 

		male = new JRadioButton("Male"); 
		male.setFont(new Font("Arial", Font.PLAIN, 15)); 
		male.setSelected(true); 
		male.setSize(75, 20); 
		male.setLocation(200, 200); 
		c.add(male); 

		female = new JRadioButton("Female"); 
		female.setFont(new Font("Arial", Font.PLAIN, 15)); 
		female.setSelected(false); 
		female.setSize(80, 20); 
		female.setLocation(275, 200); 
		c.add(female); 
		
		gengp = new ButtonGroup(); 
		gengp.add(male); 
		gengp.add(female); 
		
		city = new JLabel("City"); 
		city.setFont(new Font("Arial", Font.PLAIN, 20)); 
		city.setSize(100, 20); 
		city.setLocation(100, 250); 
		c.add(city); 

		tcity = new JTextField(); 
		tcity.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tcity.setSize(190, 20); 
		tcity.setLocation(150, 250); 
		c.add(tcity); 
		
		state = new JLabel("State"); 
		state.setFont(new Font("Arial", Font.PLAIN, 20)); 
		state.setSize(100, 20); 
		state.setLocation(100, 400 ); 
		c.add(state); 

		tstate = new JTextField(); 
		tstate.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tstate.setSize(190, 20); 
		tstate.setLocation(200, 400); 
		c.add(tstate);

		sub = new JButton("Submit"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(150, 450); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(270, 450); 
		reset.addActionListener(this); 
		c.add(reset); 

//		tout = new JTextArea(); 
//		tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
//		tout.setSize(300, 400); 
//		tout.setLocation(500, 100); 
//		tout.setLineWrap(true); 
//		tout.setEditable(false); 
//		c.add(tout); 

		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setLocation(100, 500); 
		c.add(res); 

//		resadd = new JTextArea(); 
//		resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
//		resadd.setSize(200, 75); 
//		resadd.setLocation(580, 175); 
//		resadd.setLineWrap(true); 
//		c.add(resadd); 
		
		
		

	
		setVisible(true); 
		
		  Date date= new Date();
	      long time = date.getTime();
	      
	      Timestamp ts = new Timestamp(time);
	} 

	// method actionPerformed() 
	// to get the action performed 
	// by the user and act accordingly 
	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getSource() == sub) { 
				final String xmlFilePath = "xmlfile.xml";
			 	String data1; 
			 	String fname = tname.getText();
			 	String lname = tlname.getText();
			 	String cityofuser = tcity.getText();
			 	String stateofuser = tstate.getText();
			 	String addressofuser = tadd.getText();
			 	
				String data 
					= "Name : "
					+ fname + "\n"
					+ "Last Name : "
					+ lname + "\n"
					+ "City : "
					+ cityofuser + "\n"
					+ "State : "
					+ stateofuser + "\n";
				
				if (male.isSelected()) 
					data1 = "Gender : Male"
							+ "\n"; 
				else
					data1 = "Gender : Female"
							+ "\n"; 
				

				String data3 = "Address : " + addressofuser; 
				//tout.setText(data + data1 + data3); 
				//tout.setEditable(false); 
				res.setText("Registration Successfully.."); 
				

				try {
					
					makexml(xmlFilePath, fname, lname, cityofuser, stateofuser, addressofuser);
				} catch (TransformerFactoryConfigurationError | SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
		    }
			
		

		else if (e.getSource() == reset) { 
			String def = ""; 
			tname.setText(def); 
			tadd.setText(def); 
			tlname.setText(def);
			tcity.setText(def);
			tstate.setText(def);
			res.setText(def); 
			//term.setSelected(false); 
			
		} 
	}
	
	

	public void makexml(final String xmlFilePath, String fname, String lname, String cityofuser, String stateofuser,
			String addressofuser) throws TransformerFactoryConfigurationError, SAXException, IOException {
		
		try {
			File file = new File("xmlfile.xml"); 
			if(!file.exists()) {
				DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
				 
			    DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	 
			    Document document = documentBuilder.newDocument();
	 
			    // root element
			    Element root = document.createElement("Registration");
			    document.appendChild(root);
	 
			    // employee element
			    Element employee = document.createElement("employee");
	 
			    root.appendChild(employee);
	 
	
	 
			    // firstname element
			    Element firstName = document.createElement("firstname");
			    firstName.appendChild(document.createTextNode(fname));
			    employee.appendChild(firstName);
	 
			    // lastname element
			    Element lastname = document.createElement("lastname");
			    lastname.appendChild(document.createTextNode(lname));
			    employee.appendChild(lastname);
	 
			    Element city = document.createElement("city");
			    city.appendChild(document.createTextNode(cityofuser));
			    employee.appendChild(city);
			    
			    Element state = document.createElement("state");
			    state.appendChild(document.createTextNode(stateofuser));
			    employee.appendChild(state);
			    
			    Element address = document.createElement("address");
			    address.appendChild(document.createTextNode(addressofuser));
			    employee.appendChild(address);
			    
			    // create the xml file
			    //transform the DOM Object to an XML File
			    TransformerFactory transformerFactory = TransformerFactory.newInstance();
			    Transformer transformer = transformerFactory.newTransformer();
			    DOMSource domSource = new DOMSource(document);
			    StreamResult streamResult = new StreamResult(new File("D:\\selenium\\UserRegi\\xmlfile.xml"));
	 
			    // If you use
			    // StreamResult result = new StreamResult(System.out);
			    // the output will be pushed to the standard output ...
			    // You can use that for debugging 
			    
			    transformer.transform(domSource, streamResult);
	 
			    System.out.println("Done creating XML File");
			    
//			    String[] columnNames = { "F_Name", "L_Name", "City", "State", "Address" };
//				String[][] tdata = { 
//						{ fname, lname, cityofuser, stateofuser, addressofuser }
//						 
//					}; 
				
				
				
				jtable();
				
		
	 
			}
			else {
				try   
				{ 
					 File inputFile = new File("xmlfile.xml");
			         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			         Document doc = dBuilder.parse(inputFile);
			         doc.getDocumentElement().normalize();
			         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			         NodeList nList = doc.getElementsByTagName("Registration");
			         System.out.println(nList);
			         System.out.println("----------------------------");
			         System.out.println("Node List" + nList);
			         Node root = nList.item(0);
			         System.out.println("Root is" + root);
				
					    // employee element
					    Element employee = doc.createElement("employee");
			 
					    root.appendChild(employee);
			
					    // firstname element
					    Element firstName = doc.createElement("firstname");
					    firstName.appendChild(doc.createTextNode(fname));
					    employee.appendChild(firstName);
			 
					    // lastname element
					    Element lastname = doc.createElement("lastname");
					    lastname.appendChild(doc.createTextNode(lname));
					    employee.appendChild(lastname);
			 
					    Element city = doc.createElement("city");
					    city.appendChild(doc.createTextNode(cityofuser));
					    employee.appendChild(city);
					    
					    Element state = doc.createElement("state");
					    state.appendChild(doc.createTextNode(stateofuser));
					    employee.appendChild(state);
					    
					    Element address = doc.createElement("address");
					    address.appendChild(doc.createTextNode(addressofuser));
					    employee.appendChild(address);
					
					   TransformerFactory transformerFactory = TransformerFactory.newInstance();
					    Transformer transformer = transformerFactory.newTransformer();
					    DOMSource domSource = new DOMSource(doc);
					    StreamResult streamResult = new StreamResult(new File("xmlfile.xml"));
			 
					    transformer.transform(domSource, streamResult);
			 
					    System.out.println("Done Updating the XML File");
					    
					    
					    
					    //creating a constructor of file class and parsing an XML file  
					    File file1 = new File("xmlfile.xml");  
					    //an instance of factory that gives a document builder  
					    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
					    //an instance of builder to parse the specified xml file  
					    DocumentBuilder db = dbf.newDocumentBuilder();  
					    Document doc1 = db.parse(file1);  
					    doc.getDocumentElement().normalize();  
					    System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
					    NodeList nList1 = doc.getElementsByTagName("employee");  
					    
					    System.out.println("Node List ==" + nList1.toString());
					    

				 
					    for (int itr = 0; itr < nList1.getLength(); itr++)   
					    {  
					    Node node = nList1.item(itr);  
					    System.out.println("\nNode Name :" + node.getNodeName());  
					    if (node.getNodeType() == Node.ELEMENT_NODE)   
					    {  
					    Element eElement = (Element) node;  
					      
					    System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());  
					    System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());  
					    System.out.println("Subject: "+ eElement.getElementsByTagName("city").item(0).getTextContent());  
					    System.out.println("Marks: "+ eElement.getElementsByTagName("state").item(0).getTextContent());
					    System.out.println("Marks: "+ eElement.getElementsByTagName("address").item(0).getTextContent());
					    

					    }  
					    }  
						jtable();

					    

				
				}   
				catch (Exception e)   
				{  
				e.printStackTrace();  
				} 
				
				
			}	
		} catch (ParserConfigurationException pce) {
			    pce.printStackTrace();
			} catch (TransformerException tfe) {
			    tfe.printStackTrace();
			}
}

	/**
	 * @param columnNames
	 * @param tdata
	 */
	public void jtableCuttent(String[] columnNames, String[][] tdata) {
		table = new JTable(tdata, columnNames); 
		JScrollPane sp = new JScrollPane(table);
		sp.setSize(300, 300); 
		sp.setLocation(500, 100);
		c.add(sp);
	}

	/**
	 * @return 
	 * 
	 */
	public void jtable() {
		
		XMLInJTable t = new XMLInJTable();
		table = new JTable();
		table.setModel(t);
		JScrollPane sp = new JScrollPane(table);
		sp.setSize(300, 300); 
		sp.setLocation(500, 100);
		c.add(sp);
		
		
	}
	
	



} 





// Driver Code 
class Registration { 
	
	


	public static void main(String[] args) throws Exception 
	{ 
		
		 
		ui_swing f = new ui_swing();
		
		
		
		
	
		

	}
} 

 


