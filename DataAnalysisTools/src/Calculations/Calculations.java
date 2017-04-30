package Calculations;

import java.io.File;

public interface Calculations {
	
	public void doCalc(String db, String table, String un, String pass, String calc, int col);
	public void printCalc(String answer);
}
