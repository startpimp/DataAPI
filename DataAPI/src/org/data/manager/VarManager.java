package org.data.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VarManager {
	private static ArrayList<String[]> vars = new ArrayList<String[]>();
	/**
	 * Add the variable in an ArrayList<String[]>
	 * @param varName The name of the variable
	 * @param valor The valor of the variable
	 * @see ArrayList<Object>
	 */
	public static void addVar(String varName, Object valor) {
		for(int i = 0;i < vars.size();i++) {
			if(vars.get(i)[0].equals(varName)) {
				System.err.println("The varibale \""+varName+"\" already exist.");
				return;
			}
		}
		vars.add(new String[] {varName, (String) valor});
	}
	/**
	 * Save the variables in the file that you've been saved
	 * @see FileManager
	 */
	public static void save() {
		destroy();
		for(int i = 0;i < vars.size();i++) {FileManager.println(vars.get(i)[0]+"="+vars.get(i)[1]);}
	}
	/**
	 * Destroy the entire ArrayList<String[]>
	 * @see ArrayList<Object>
	 */
	public static void destroy() {vars.clear();}
	/**
	 * Modify the valor of the variable
	 * @param varName The name of the variable
	 * @param valor The modified valor of the variable
	 */
	public static void modify(String varName, Object valor) {for(int i = 0;i < vars.size();i++) {if(vars.get(i)[0].equals(varName)) {vars.get(i)[1] = (String)valor;}}}
	/**
	 * Adds variables in an ArrayList<String[]> witch there are in the file
	 * @param file The file were the variables are
	 */
	public static void getVars(File file) {
		try(FileInputStream f = new FileInputStream(file)) {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String[] s = sc.nextLine().split("=");
				vars.add(s);
			}
			sc.close();
			f.close();
		} catch(IOException e) {System.err.println("Cannot read the file : \""+file.getPath()+"\" "+e.getMessage());}
	}
}
