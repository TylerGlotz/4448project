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
		
	//driver holds important JDBC parameters and represents a working database
	public driver(String db, String table, String un, String pass){
		
		db=name;
		table=t;
		un=u;
		pass=psw;
	}
	
	//Starts Database
	public void startDriver(){
		
	}
	
	
	//Calls correct import to path
	//If data type has no Delimeter or it is trivial enter "0"
	public void directImport(String db, String table, String path, String un, String pass, String delimeter){
		
		/*Example
		Import.importTXT port=new importTXT();
		port.importFile(db, table, path, un, pass, delimeter);
		*/
	}
	
	//Calls correct export to path
	//If data type has no Delimeter or it is trivial enter "0"
	public void directExport(String db, String table, String path, String un, String pass, String delimeter){
		
	}
	
	//Calls correct calculation
	public void directCalc(String db, String table, String un, String pass, String calc, int col){
		
	}
	
	
	public static void main(String[] args) {

		//driver d=new driver();
		
		//directImport(d.path);
		
	}

}
