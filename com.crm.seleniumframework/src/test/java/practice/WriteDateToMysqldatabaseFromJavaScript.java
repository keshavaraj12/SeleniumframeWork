package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class WriteDateToMysqldatabaseFromJavaScript {
public static void main(String[] args) throws Throwable {
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
	Statement stat= conn.createStatement();
	String query="insert into student(first_name,last_name,address,ph_num)values('RAJU','RM','INDIA','98764')";
	//String query1="ALTER TABLE student DROP ph_num";
	int result=stat.executeUpdate(query);
	//int result1=stat.executeUpdate(query1);
	if(result==1)
	{
		System.out.println("user is created");
	}
	else {
		System.out.println("user is not created");
	}
	conn.close();
}
}
