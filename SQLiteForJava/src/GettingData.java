import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GettingData {
	
	
	
	public static void main(String[] args) {
		GettingData gettingData = new GettingData();
		
		gettingData.getData();
		

	}
	
	public void getData() {
		
		try(Connection connection = this.connect("C:/Users/Mustafa/Desktop/newDatabase.db")){
			String sql = "Select * from users";
			PreparedStatement prStatement = connection.prepareStatement(sql);
			ResultSet rSet = prStatement.executeQuery();
			
			while(rSet.next()) {
				System.out.println(rSet.getString(1));
				System.out.println(rSet.getInt(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	private Connection connect(String path) {
		Connection connection = null;
		String url = "jdbc:sqlite:"+path;
		
		try {
			connection = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
		
		
	}

}
