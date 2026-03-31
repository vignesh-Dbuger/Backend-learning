package iooperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;


public class Fileoperation {

	public static void main(String[] args) {
		Path file=Paths.get("sample.txt");
		
//		if(Files.exists(file)) {
//			System.out.println("file already exist");
//		}
//		else if(Files.notExists(file)) {
//		
//		}
		
		try {
			Files.createFile(file);
			System.out.println("file created successfully");
		}
		catch(FileAlreadyExistsException e){
			System.err.println("file already exist"+e.getMessage());
			
		}
		catch(IOException e) {
			System.out.println("error");
		}
		
		
		try(BufferedReader read=Files.newBufferedReader(file)) {
			String line=read.readLine();
			if(line!=null) System.out.println(line);
			else writefile(file,"intial data");
		}
		catch(IOException e) {
			System.out.println("error to read file");
		}
	}
		static void writefile(Path file,String content) {
			try(BufferedWriter write=Files.newBufferedWriter(file)) {
				write.write(content);
				System.out.println("contentwrite sucessfull");
			}
		    catch(IOException e) {
		    	System.err.println("could not found"+e.getMessage());
		    }
		
	}

}
