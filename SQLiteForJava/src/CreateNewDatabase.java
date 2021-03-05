import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateNewDatabase {
	
	private Connection connection = null;
	private PreparedStatement prStatement = null;
	
	
	
	public static void main(String[] args) {
		CreateNewDatabase createDb = new CreateNewDatabase();
		
		createDb.create("newDatabase.db");
		
	}
	
	public void create(String filename) {
		String url = "jdbc:sqlite:C:/Users/Mustafa/Desktop/"+filename;
		
		String sql = "Create Table if not exists users(name TEXT, age INTEGER)";
		
		try {
			connection = DriverManager.getConnection(url);
			prStatement = connection.prepareStatement(sql);
			
			prStatement.execute();
			
			System.out.println("Database is created successfully.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
