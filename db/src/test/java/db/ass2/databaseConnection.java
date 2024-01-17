package db.ass2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseConnection {

	public static void main(String[] args) {
		
		//Java Connect to Microsoft SQL Server

		Connection connection = null;
		
		try {
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Learners;encrypt=true;trustServerCertificate=true;";
			String dbuser = "admin";
			String dbpass = "admin";
			
			
			connection = DriverManager.getConnection(dbURL, dbuser, dbpass);
			
			String sql = "SELECT * FROM productcodes";
			
			Statement stat = connection.createStatement();
			
			ResultSet result =	stat.executeQuery(sql);
			int Count = 0;
			while(result.next()) {
				Count++;
				String productName = result.getString("ProductName");
				int productCode = result.getInt("ProductCode");
				
				System.out.printf("Product %d: %d - %s\n", Count, productCode, productName);
				
			}
			

//			if(connection !=null) {
//				DatabaseMetaData metadata = (DatabaseMetaData) connection.getMetaData();
//				System.out.println("Product Name: " + metadata.getDatabaseProductName());
//				System.out.println("Product Verion:" + metadata.getDatabaseProductVersion());
//			}
//			
			connection.close();

			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
	}

}
