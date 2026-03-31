package iooperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PathOperation {

	public static void main(String[] args) {
		Path file =Paths.get("sample1.txt");
		
		try {
			if(Files.exists(file)) {
				try(BufferedReader br=Files.newBufferedReader(file)){
					String line;
					if(br.readLine()!= null) {
						System.out.print("file readed");
						line=br.readLine();
					   System.out.println(line);	
					}
					else {
						System.out.println("nothing is there");
						writedata(file,"hello bhaii");
					}
				}
				
			}else {
				System.out.println("file is missing");
				writedata(file,"vankam");
			}
		}
		catch(IOException e) {
			System.err.println("IO error"+e.getMessage());
		}
	
		
	  try(BufferedWriter write=Files.newBufferedWriter(file,StandardOpenOption.TRUNCATE_EXISTING)){
		  
		  System.out.println("deleted sucessfully");
	  }
	  catch(NoSuchFileException e) {
		  System.err.println("file not exist");
	  }
	  catch (IOException e) {
		System.err.println("errror"+e.getMessage());
	}

	}
	static void writedata(Path file,String content) {
		try(BufferedWriter br=Files.newBufferedWriter(file,StandardOpenOption.CREATE,StandardOpenOption.APPEND)) {
			System.out.println("so,new file is created");
			br.write(content);
			br.newLine();
		}
	    catch(IOException e) {
	    	System.err.println("can't create file");
	    }
	}

}
