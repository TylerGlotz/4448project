package Calculations;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Import.importCSV;

public class maxCol implements Calculations {

	@Override
	public void doCalc(String db, String table,  String un, String pass, String calc, String col){
		//FileWriter filew = new FileWriter(path);
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		try{
			
		//connect to database with db (database name), un (MySQL user name), pass (MySQL password)
		Connection connect = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s?useSSL=false", db), un, pass);
	
		//query to db
		String query = String.format("SELECT MAX(%s) FROM %s", col, table);
		Statement statem = connect.createStatement();
		
		//result set of the query
		ResultSet res = statem.executeQuery(query);
		
		
		//Get the result and print
		if(res.next()){
			int max = res.getInt(1);
			System.out.println(String.format("Max value of column %s is %d", col, max));	
			}
		
		//exception handling
		}catch (SQLException ex) {
        Logger lgr = Logger.getLogger(maxCol.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);

    } 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
