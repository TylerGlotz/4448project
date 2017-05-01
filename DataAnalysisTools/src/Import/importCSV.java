package Import;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.opencsv.*;


public class importCSV implements ImportFileStream{

		public void importFile(String db, String table, String path, String un, String pass, String delimeter) throws IOException {
			  try {
		            Connection con = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s", db), un, pass);
		            Statement statement = con.createStatement();

		            CSVReader csvFile = new CSVReader(new FileReader(path));
		            
		            String [] headers;
		            while ((headers = csvFile.readNext()) != null) {
		            	   // nextLine[] is an array of values from the line
		            	   System.out.println(headers);
		            	}
		            
		            String query= String.format("LOAD DATA INFILE '%s' INTO TABLE %s " + 
		            " FIELDS TERMINATED BY '%s' ENCLOSED BY '\"' " +
		            " LINES TERMINATED BY '\r\n'", path, table, delimeter);
		            
		            System.out.println("Closing file");  
		            csvFile.close();
		            System.out.println("Closed file");  
		            ResultSet res = statement.executeQuery(query);

		        } catch (SQLException ex) {
		            Logger lgr = Logger.getLogger(importCSV.class.getName());
		            lgr.log(Level.SEVERE, ex.getMessage(), ex);

		        } 
			
		}
		
	}
	

