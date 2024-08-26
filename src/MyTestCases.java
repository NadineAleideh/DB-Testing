import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	
	//WebDriver driver = new ChromeDriver();

	Connection con;
	Statement stmt;
	ResultSet rs;
	
	@BeforeTest
	public void MySetup() throws SQLException {
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","NadeenAhmad2000");
	}
	
	@Test
	public void GetData() throws SQLException {
		
		stmt = con.createStatement();
		
		rs = stmt.executeQuery("SELECT * FROM customers where customerNumber = 148 ");
		
		while(rs.next()) {
		
			int CustomerNumber = rs.getInt("customerNumber");
			String CustomerName = rs.getString("CustomerName");
			//String Address = rs.getString("addressLine1");
			String Address = rs.getString("addressLine1") +" "+ rs.getString("addressLine2");
			
			System.out.println(CustomerNumber);
			System.out.println("***************");
			System.out.println(CustomerName);
			System.out.println("***************");
			System.out.println(Address);
	}
	}
}

	
	
