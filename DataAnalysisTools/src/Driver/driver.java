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
		private String p;
		private String d;
		
		//globals if you want to use
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
		
		String extension ="";
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
		System.out.println("Importing from a "+ extension+" file, with delimeter "+delimeter+".");
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
	public static void directExport(String db, String table, String path, String un, String pass, String delimeter){
		
		String extension= parse(path);
		System.out.println("Exporting to a "+ extension+" file, with delimeter "+delimeter+".");
		
		//if it is a txt file call exportTXT
		if(extension.equals("txt")){
			Export.exportTXT port=new exportTXT();
			port.export(db, table, path, un, pass, delimeter);
		}
		
		//if it is a CSV file call exportCSV
		if(extension.equals("csv")){
			Export.exportCSV port=new exportCSV();
			port.export(db, table, path, un, pass, delimeter);
		}
		
	}
	
	//Calls correct calculation
	public static void directCalc(String db, String table, String un, String pass, String calc, String col){
		
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
	
	
	public static void main(String[] args){
		
		//get database running
		/*
		 * uncomment for test import text set delimeter and path to appropraite values
		 * must change private database values*/

		driver d=new driver(database,table,username,password);
		//
		/*d.name=args[0];//db
		d.t=args[1];//table
		d.u=args[2];//username
		d.psw=args[3];//password
		d.d=args[4];//path
		d.p=args[5];//delimeter
		*/
		System.out.println("sure");
		d.name="test";//db
		d.t="test";//table
		d.u="test";//username
		d.psw="test";//password
		d.p="test/test.csv";//path
		d.d="test";//delimeter
		System.out.println("sure");
		
		directExport(d.name, d.t, d.p, d.u, d.psw, d.d);
		

	
	}

}