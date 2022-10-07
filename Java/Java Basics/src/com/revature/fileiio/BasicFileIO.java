package com.revature.fileiio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * 
 * Like in many languages, you can read and write to files on your file system.
 * Java provides an object representation of files with the "File" class.
 * 
 * Files
 *
 */
public class BasicFileIO {

	public static void main(String[] args) {

		File myFile = new File("words.txt");

		/*
		 * This syntax is called try-with-resources. It can provide a cleaner way of
		 * handling resources that must be closed as any resources declared this way
		 * will be automatically closed.
		 */
		try (FileWriter fileWriter = new FileWriter(myFile, true);
				BufferedWriter writer = new BufferedWriter(fileWriter)) {
//			FileOutputStream fos = new FileOutputStream(myFile); //deals in bytes

			writer.write("there is a cup on the counter \n");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// This time we'll read the information from our file into our program.
		try (FileReader fileReader = new FileReader(myFile); BufferedReader reader = new BufferedReader(fileReader)) {
			while (reader.ready()) {
				System.out.println(reader.readLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * Technically speaking, the modern approach in Java to file IO is the "Files"
		 * class.
		 */

	
		try (BufferedWriter myWriter = Files.newBufferedWriter(Path.of("words.txt"), StandardOpenOption.APPEND)) {
			myWriter.write("writing stuff using the modern Files API");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
