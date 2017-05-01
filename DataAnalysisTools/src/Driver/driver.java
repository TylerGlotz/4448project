package Driver;

import java.io.File;
import java.util.*;

import Export.*;
import Import.*;
import Calculations.*;



public class driver {
		
		private String t;
		private String u;
		private String psw;
		private String name;
		
		private static String database="dataToolsDB";
		private static String table="pet";
		private static String username="root";
		private static String password="datatools";
		
	//driver holds important JDBC parameters and represents a working database
	public driver(String db, String table, String un, String pass){
		
		db=name;
		table=t;
		un=u;
		pass=psw;
	}
	
	//Starts Database
	public static void startDriver(driver d, String db, String table, String un, String pass){
		
	}
	
	
	//Calls correct import to path
	//If data type has no Delimeter or it is trivial enter "0"
	public static void directImport(String db, String table, String path, String un, String pass, String delimeter){
		
		
		String db1="dataToolsDB";
		String table1="pet";
		String un1="root";
		String pass1="datatools";
		
		
		Import.importTXT port=new importTXT();
		port.importFile(db1, table1, path, un1, pass1, delimeter);
		
		
	}
	
	//Calls correct export to path
	//If data type has no Delimeter or it is trivial enter "0"
	public static void directExport(String db, String table, String path, String un, String pass, String delimeter){
		
	}
	
	//Calls correct calculation
	public static void directCalc(String db, String table, String un, String pass, String calc, int col){
		
	}
	
	
	public static void main(String[] args) {
		
		//get database running
		/*
		uncomment for test import text set delimeter and path to appropraite values
		must change private database values
		*/
		
		driver d=new driver(database,table,username,password);
		startDriver(d,database,table,username,password);
		
		String delimeter="\t";
		String path="/Users/yolo/GoogleDrive/College Senior Spring/CSCI 4448/4448project/tabDelimter.txt";
		directImport(d.name, d.t, path, d.u, d.psw, delimeter);
		
		
	}

}
