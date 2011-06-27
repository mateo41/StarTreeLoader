package org.sdsc.spatial.ontology;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import com.inxight.st.STLicenseException;
import com.inxight.st.STPanel2;
import com.inxight.st.StarTree;
import com.inxight.st.StdTreeDataModel;
import com.inxight.st.StdTreeDataNode;
import com.inxight.st.TreeDataModel;


public class OntologyLoader extends JFrame {
	private JTextField msg_text_field;
	private STPanel2 stPanel;
	private StarTree star1;
	private TreeDataModel tree;
	private Container main_pane;
	
	public OntologyLoader(){
		super("Loader");
		
		main_pane = getContentPane();
        main_pane.setLayout(new BorderLayout());
        setSize(400, 400);
        
  
        msg_text_field = new JTextField();
        msg_text_field.setEditable(false);
        msg_text_field.setBorder(null);
        msg_text_field.setColumns(50);
        
        stPanel = new STPanel2();
        main_pane.add("Center", stPanel);
        main_pane.add("South", msg_text_field);
        
        star1 = stPanel.getStarTree();
        StdTreeDataNode root = new StdTreeDataNode("Root", "Root", Color.blue);
        tree = new StdTreeDataModel(root);
   
        addLicense(star1);
        
        star1.setTree(tree);
        
        
	}
	private void addLicense(StarTree star) {

	    	ClassLoader loader = OntologyLoader.class.getClassLoader();
	    	URL license = loader.getResource("res/license/license.dat");
	    	URL company = loader.getResource("res/license/company.dat");
	    	try {
	        	
	            star.setLicense(null,license, company);
	        } catch (STLicenseException e) {
	            setMessage("Invalid license.");
	            System.out.println("Invalid license");
	        }
	    }
	 
	public void setMessage(String msg) {
	        msg_text_field.setText(msg);
	}
	public static void main(String[] args) {
		 //StdTreeDataModel model = new StdTreeDataModel();
		 //final TreeDataModel tree = new StdTreeDataModel();

	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                OntologyLoader demo = new OntologyLoader();
	                demo.setVisible(true);
	                
	             
	            }
	        }); 
	}
	protected static void addNodes() {
		int i = 1;
	}
	
}
