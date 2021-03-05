import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataUpdate {
	
	public static void main(String[] args) {
		DataUpdate dUpdate = new DataUpdate();
		
		dUpdate.setData();
		
		
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
	
	
	public void setData() {
		//Update the names of those whose name is john to gabriel.
		String sql = "Update users Set name = 'John' Where name = 'Gabriel'";
		
		try(Connection connection = this.connect("C:/Users/Mustafa/Desktop/newDatabase.db")){// Enter the database path.
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
