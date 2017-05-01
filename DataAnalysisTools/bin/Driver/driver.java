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
		
		private static String database="database";
		private static String table="table";
		private static String  username="username";
		private static String password="password";
		
	//driver holds important JDBC parameters and represents a working database
	public driver(String db, String table, String un, String pass){
		
		db=name;
		table=t;
		un=u;
		pass=psw;
	}
	
	
	//Calls correct import to path
	//If data type has no Delimeter or it is trivial enter "0"
	public static void directImport(String db, String table, String path, String un, String pass, String delimeter){
		
		//this block puts the file extension into a string
		String extension = "";
		int i = path.lastIndexOf('.');
		if (i > 0) {
		    extension = path.substring(i+1);
		}
		
		//if it is a text file
		if(extension=="txt" || extension=="t"){
			Import.importTXT port=new importTXT();
			port.importFile(db, table, path, un, pass, delimeter);
		}
		
		//if it is a CSV file
			if(extension=="csv" || extension=="c"){
				Import.importCSV port=new importCSV();
				port.importFile(db, table, path, un, pass, delimeter);
			}		

		
	}
	
	//Calls correct export to path
	//If data type has no Delimeter or it is trivial enter "0"
	public static void directExport(String db, String table, String path, String un, String pass, String delimeter){
		
		//this block puts the file extension into a string
		String extension = "";
		int i = path.lastIndexOf('.');
		if (i > 0) {
		    extension = path.substring(i+1);
		}
		
		//if it is a txt file call exportTXT
		if(extension=="txt" || extension=="t"){
			Export.exportTXT port=new exportTXT();
			port.export(db, table, path, un, pass, delimeter);
		}
		
		//if it is a CSV file call exportCSV
			if(extension=="csv" || extension=="c"){
				Export.exportCSV port=new exportCSV();
				port.export(db, table, path, un, pass, delimeter);
			}
	}
	
	//Calls correct calculation
	public static void directCalc(String db, String table, String un, String pass, String calc, int col){
		
		//calls appropriate column calculation
		if(calc=="minCol"){
			minCol calcz=new minCol();
			calcz.doCalc(db, table, un, pass, calc, col);
		}
		if(calc=="maxCol"){
			maxCol calcz=new maxCol();
			calcz.doCalc(db, table, un, pass, calc, col);
		}
		if(calc=="averageCol"){
			averageCol calcz=new averageCol();
			calcz.doCalc(db, table, un, pass, calc, col);
		}
		if(calc=="sumCol"){
			sumCol calcz=new sumCol();
			calcz.doCalc(db, table, un, pass, calc, col);
		}
	}
	
	
	public static void main(String[] args) {
		
		//get database running
		/*
		 * uncomment for test import text set delimeter and path to appropraite values
		 * must change private database values
		driver d=new driver(database,table,username,password);
		startDriver(d,database,table,username,password);
		
		String delimeter="";
		String path="/sample/read/path";
		directImport(d.name, d.t, path, d.u, d.psw, delimeter);
		*/
		
	}

}
