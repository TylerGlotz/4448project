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

public class sumCol implements Calculations {
	int sum = 0;
	@Override
	public void doCalc(String db, String table, String un, String pass, String calc, String col){
		try{
		
		//connect to database with db (database name), un (MySQL user name), pass (MySQL password)
		Connection connect = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s?useSSL=false", db), un, pass);
		
		//SQL query
		String query = String.format("SELECT SUM(%s) FROM %s", col, table);
		Statement statem = connect.createStatement();
		
		//Result Set of query
		ResultSet res = statem.executeQuery(query);
		
		//Get results and print
		while(res.next()){
			int sum = res.getInt(1);
			System.out.println(String.format("Sum of column %s is %d", col, sum));;
			
		}
		
		//catch exceptions
		}catch (SQLException ex) {
            Logger lgr = Logger.getLogger(sumCol.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
