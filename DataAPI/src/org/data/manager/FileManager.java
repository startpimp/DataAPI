package org.data.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
	private static File file;
	/**
	 * Save the file were you want put the var in a variable
	 * @param fileName The name of the file
	 * @param folderPath The path were the file are created
	 */
	public static void setFile(String fileName, String folderPath) {file = new File(folderPath+fileName+".txt");}
	/**
	 * @return the saved file;
	 */
	public static File getFile() {return file;}
	private static void print(String text, boolean append) {try(PrintWriter p = new PrintWriter(new FileOutputStream(file, append))) {p.print(text);} catch(IOException e) {System.err.println("Cannot write in the file : "+e.getMessage());}}
	public static void println(String text) {print(text+"\n", true);}
	/**
	 * Clear the entire of the file
	 */
	public static void clear() {try(PrintWriter p = new PrintWriter(new FileOutputStream(file))) {p.print("");} catch(IOException e) {System.err.println("Cannot write in the file : "+e.getMessage());}}
}
