package crudoperation;

import java.sql.Connection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;

public class filedb{

	public static void main(String[] args) {
		String url="jdbc:mysql://192.168.16.191:5873/user_1208";
		String user="rw_onprem_user_1208";
        String password="V1GN_I8SH_M3NB_Q6PL_Z9YX";
        Path file=Paths.get("text1.csv");
        
        try( Connection conn=DriverManager.getConnection(url,user,password)){
        	System.out.println("Connected to Database");
        	
        	String sql="INSERT INTO users(rollno,name,mark) VALUES (?,?,?)";
        	
        	
            try(PreparedStatement patmt=conn.prepareStatement(sql);
            		BufferedReader br=Files.newBufferedReader(file)){
            	
            	String line=br.readLine();
            	while((line=br.readLine())!=null) {
            		String[] data =line.split(",");
            		
            		patmt.setInt(1, Integer.parseInt(data[0].trim()));
            		patmt.setString(2, data[1].trim());
            		patmt.setInt(3, Integer.parseInt(data[2].trim()));
            		patmt.executeUpdate();
            	}
           }
            catch(NoSuchFileException e) {
            	System.err.println("csv file is missing");
            } catch (IOException e1) {
				e1.printStackTrace();
			}
        	
        
        try(Statement stmt=conn.createStatement();
        		ResultSet rs=stmt.executeQuery("SELECT * FROM users")){
        	
        }
        
        }
        
        catch(SQLException e) {
        	System.err.println("database error"+e.getMessage());
        }
        		
	}

}
