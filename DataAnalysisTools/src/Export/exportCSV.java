package Export;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.io.File;



public class exportCSV implements ExportFileStream {

	@Override	
	public void export(String db, String table, String path, String un, String pass, String delimeter){
		try{
			FileWriter filew = new FileWriter(path);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//connect to database with db (database name), un (MySQL user name), pass (MySQL password)
			Connection connect = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s?useSSL=false", db), un, pass);
			
			//Get the whole table
			String query = String.format("SELECT * FROM %s", table);
			Statement statem = connect.createStatement();
			
			//Result Set
			ResultSet res = statem.executeQuery(query);
			ResultSetMetaData rsmd = res.getMetaData();
			int numcol = rsmd.getColumnCount();
			
			//loops through result set, while there is still columns use ',' as delimeter.
			//when out of columns use a newline
			while(res.next()){
				for(int i=1; i < numcol; i++){
					filew.append(res.getString(i));
					filew.append(',');
					filew.append(res.getString(i+1));
				}
				filew.append('\n');
			}
			
			//Clean up
			filew.flush();
			filew.close();
			connect.close();
			
			//Let us know what happened
			System.out.println("CSV File is created successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
