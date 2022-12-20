package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class CheckDataFromMySqlusingScannerclass {

	public static void main(String[] args) throws Throwable {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		Statement stat= conn.createStatement();
		String selectquery = "select * from student";
		ResultSet result = stat.executeQuery(selectquery);
		String allname="";
		while (result.next()) {
			allname=result.getString(1);
			System.out.println(allname);
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name");
		String first_name = sc.next();
		String last_name = sc.next();
		String address = sc.next();
		if (allname.contains(first_name)) {
			System.out.println("name already exist");
		} else {
			String query="insert into student(first_name,last_name,address)values('"+first_name+"','"+last_name+"','"+address+"')";
			int result1=stat.executeUpdate(query);

		}
	}
	}


