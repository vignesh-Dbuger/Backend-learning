package baseoperation;

import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

public class connect1 {
	
	Jdb

	public static void main(String[] args) {

		String url = "jdbc:mysql://192.168.16.191:5873/user_1208";
		String user = "rw_onprem_user_1208";
		String password = "V1GN_I8SH_M3NB_Q6PL_Z9YX";

		Path file = Paths.get("sample.txt");

		// create txt file
		// connect db and read data from txt

		String table = """
				CREATE TABLE IF NOT EXISTS employees (
				    id INTEGER PRIMARY KEY,
				    name TEXT NOT NULL,
				    department TEXT NOT NULL
				);
				""";

		String query = "INSERT INTO employees (id,name,department) VALUES (?,?,?)";

		//create(file);
		
		//read

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			//insert(conn, table, file, query);
			//select(conn);
		} catch (SQLException e) {
			System.err.println("connection error");
		}
	}

	private static void insert(Connection conn, String table, Path file, String query) {

		try (Statement stmt = conn.createStatement()) {

			stmt.execute(table);
			System.out.println("db connected");

			try (PreparedStatement pstmt = conn.prepareStatement(query);
					BufferedReader br = Files.newBufferedReader(file)) {
				
				

				String line;
				while ((line = br.readLine()) != null) {
					String[] data = line.split(",");
					System.out.println(data[0]);
					if (data.length == 3) {
						pstmt.setInt(1, Integer.parseInt(data[0].trim()));
						pstmt.setString(2, data[1].trim());
						pstmt.setString(3, data[2].trim());
						pstmt.executeUpdate();
					}
				}
				System.out.println("dtat inserted");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static void create(Path file) {
		try (BufferedWriter br = Files.newBufferedWriter(file)) {
			br.write("data");
			System.out.println("file create successfully" + file.toAbsolutePath());
		} catch (IOException e) {
			System.err.println("can't write the file");
		}

	}

	public static void select(Connection conn) {
		String qry = "Select * from employees";
	 List<employee> list=new ArrayList<>();
		try (Statement stmt = conn.createStatement();
				ResultSet rs=stmt.executeQuery(qry)) {
		while(rs.next()) {
		list.add(new employee(
			     rs.getInt("id"),
			     rs.getString("name"),
			     rs.getString("department")
			
			));		
		}
		
		System.out.println(list);
			
			System.out.println("excutedd");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
class employee{
	
	int id;
	String name;
	String dept;
	
	public employee(int id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}
	
	
}