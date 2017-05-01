package Calculations;

import java.io.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Import.importCSV;

public class averageCol implements Calculations {

	@Override
	public void doCalc(String db, String table,  String un, String pass, String calc, String col){
		//FileWriter filew = new FileWriter(path);
	//	Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		try{
			
		//connect to database with db (database name), un (MySQL user name), pass (MySQL password)
		Connection connect = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s?useSSL=false", db), un, pass);
		
		//SQL QUERY
		String query = String.format("SELECT AVG(%s) FROM %s", col, table);
		Statement statem = connect.createStatement();
		
		//result set of query
		ResultSet res = statem.executeQuery(query);
		
		
		//get results and print
		if(res.next()){
			int av = res.getInt(1);
			System.out.println(String.format("Average value of column %s is %d", col, av));
		
			}
		
		
		
		}catch (SQLException ex) {
            Logger lgr = Logger.getLogger(averageCol.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
