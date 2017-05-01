package Import;

import java.awt.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.opencsv.*;


public class importCSV implements ImportFileStream{

		public void importFile(String db, String table, String path, String un, String pass, String delimeter) throws IOException {
			  try {
		            Connection con = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s", db), un, pass);
		            Statement statement = con.createStatement();

		            CSVReader csvFile = new CSVReader(new FileReader(path));
      
		            String[] header = csvFile.readNext();		            
		            
		            
		    		
		            String createTableQuery = String.format("CREATE TABLE '%s'", table);
		            Integer count = 0;
		            
;		            String addColumnsQuery = "";
		    		for (String s: header) {           
		    			addColumnsQuery = String.format("ALTER TABLE '%s' ADD ('%s' VARCHAR(250));", table, header[count]);
		    			count = count + 1;
		    	        System.out.println(s); 
		    	    }
		    		ResultSet res1 = statement.executeQuery(createTableQuery);
		    		//ResultSet res2 = statement.executeQuery(addColumnsQuery);
		            
		            String loadToDBQuery = String.format("LOAD DATA INFILE '%s' INTO TABLE %s " + " FIELDS TERMINATED BY '%s' ENCLOSED BY '\"' " + " LINES TERMINATED BY '\r\n'", path, table, delimeter);
		            
		            csvFile.close();
		            System.out.println("Closed file");  
		            ResultSet res3 = statement.executeQuery(loadToDBQuery);

		        } catch (SQLException ex) {
		            Logger lgr = Logger.getLogger(importCSV.class.getName());
		            lgr.log(Level.SEVERE, ex.getMessage(), ex);

		        } 
			
		}
		
	}
	

