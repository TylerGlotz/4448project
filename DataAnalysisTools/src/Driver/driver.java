package Driver;

import java.io.File;
import java.io.IOException;
import java.util.*;

import Export.*;
import Import.*;
import Calculations.*;



public class driver {
		
		private String t;
		private String u;
		private String psw;
		private String name;
		
		private static String database="salary";
		private static String table="name_salary";
		private static String  username="root";
		private static String password="root";
		
	//driver holds important JDBC parameters and represents a working database
	public driver(String db, String table, String un, String pass){
		
		db=name;
		table=t;
		un=u;
		pass=psw;
	}
	
	//parses string returns extension
	public static String parse(String path){
		
		String extension = "";
		int i = path.lastIndexOf('.');
		if (i > 0) {
		    extension = path.substring(i+1);
		}
		return extension;
	}
	
	//Calls correct import to path
	//If data type has no Delimeter or it is trivial enter "0"
	public static void directImport(String db, String table, String path, String un, String pass, String delimeter) throws IOException{
		
		String extension= parse(path);
		//if it is a text file
		if(extension.equals("txt")){
			Import.importTXT port=new importTXT();
			port.importFile(db, table, path, un, pass, delimeter);
		}
		
		//if it is a CSV file
			if(extension.equals("csv")){
				Import.importCSV port=new importCSV();
				port.importFile(db, table, path, un, pass, delimeter);
			}		

		
	}
	
	//Calls correct export to path
	//If data type has no Delimeter or it is trivial enter "0"
	public static void directExport(String db, String table, String path, String un, String pass, String delimeter) throws IOException{
		String extension= parse(path);
		//if it is a txt file call exportTXT
		if(extension.equals("txt")){
			Export.exportTXT port=new exportTXT();
			port.export(db, table, path, un, pass, delimeter);
		}
		
		//if it is a CSV file call exportCSV
		if(extension.equals("csv")){
			//System.out.println("it is a csv");
			Export.exportCSV port=new exportCSV();
			port.export(db, table, path, un, pass, delimeter);
		}
	}
	
	//Calls correct calculation
	public static void directCalc(String db, String table, String un, String pass, String calc, String col) throws IOException{
		
		//calls appropriate column calculation
		if(calc.equals("minCol")){
			minCol calcz=new minCol();
			calcz.doCalc(db, table, un, pass, calc, col);
		}
		if(calc.equals("maxCol")){
			maxCol calcz=new maxCol();
			calcz.doCalc(db, table, un, pass, calc, col);
		}
		if(calc.equals("averageCol")){
			averageCol calcz=new averageCol();
			calcz.doCalc(db, table, un, pass, calc, col);
		}
		if(calc.equals("sumCol")){
			sumCol calcz=new sumCol();
			calcz.doCalc(db, table, un, pass, calc, col);
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		
		//get database running
		/*
		 * uncomment for test import text set delimeter and path to appropraite values
		 * must change private database values*/
		driver d=new driver(database,table,username,password);
		
		d.name=database;
		d.t=table;
		d.u=username;
		d.psw="yes";
		
		/* code to test
		String delimeter="\t";
		String path="C:/Users/tyler/Desktop/name_salary.csv";
		//String col = "salary";
		//String calc = "maxCol";
		directImport(d.name, d.t, path, d.u, d.psw, delimeter);
		//directExport(d.name, d.t, path, d.u, d.psw, delimeter);
		//directCalc(d.name, d.t, d.u, d.psw, calc, col);
		 * */
	
	
	}

}