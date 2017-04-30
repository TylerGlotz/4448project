package Import;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class importTXT implements ImportFileStream {
	
	
	@Override	
	public void importFile(String db, String table, String path, String un, String pass, String delimeter){
		  try {
	            Connection con = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s", db), un, pass);
	            Statement statement = con.createStatement();

	            String query= String.format("LOAD DATA INFILE '%s' INTO TABLE %s " + 
	            " FIELDS TERMINATED BY '%s' ENCLOSED BY '\"' " +
	            " LINES TERMINATED BY '\r\n'", path, table, delimeter);

	            ResultSet res = statement.executeQuery(query);
	            System.out.println("------------------------------");    

	        } catch (SQLException ex) {
	            Logger lgr = Logger.getLogger(importCSV.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);

	        } 
		
	}
	
}