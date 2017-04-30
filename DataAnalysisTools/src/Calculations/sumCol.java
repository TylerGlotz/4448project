package Calculations;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class sumCol implements Calculations {

	@Override
	public void doCalc(String db, String table, String un, String pass, String calc, int col){
		FileWriter filew = new FileWriter(path);
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		//connect to database with db (database name), un (MySQL user name), pass (MySQL password)
		Connection connect = DriverManager.getConnection(String.format("jdbc:mysql://localhost:3306/%s", db), un, pass);
		String query = String.format("SELECT SUM(%d) as 'col_sum' FROM %s", col, table);
		Statement statem = connect.createStatement();
		ResultSet res = statem.executeQuery(query);
		//result set of the query
		ResultSetMetaData rsmd = res.getMetaData();
	}
	
	@Override
	public void printCalc(String answer){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
