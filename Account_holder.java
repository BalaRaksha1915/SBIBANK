package SBI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.SQLDataException;
public class Account_holder 
{
	private Connection Databaseconnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/SBI_bank","root","1234");
	}
	public void registeraccountholder(){
	try(Scanner sc= new Scanner(System.in);
			 Connection con= Databaseconnection()) {
				
		/*if(con!=null){
        System.out.println("          "+"-------------------------------------");
		System.out.println("                "+"Database will be connected");
		System.out.println("          "+"-------------------------------------");
		}
		else {
			System.out.println("      "+"-------------------------------------");
			System.out.println("      "+"Database will be not connnected...So check the URL of DATABASE_URL");
			System.out.println("      "+"-------------------------------------");
		}*/
		System.out.print("\n");
		System.out.println("          "+"|-------------------------------------|");
		System.out.println("          "+"|=====WELLCOME TO SBI BANK INDIA======|");
		System.out.println("          "+"|-------------------------------------|");
		System.out.println("          "+"|========REGISTER YOUR DETAILS========|");
		System.out.println("          "+"|-------------------------------------|");
		String q="insert into account_holder values(?,?,?,?,?,?,?,?,?) ";
		PreparedStatement ps=con.prepareStatement(q);
		System.out.print("\n");
		System.out.print("Enter the FirstName:");
		ps.setString(1,sc.next());
		System.out.print("\n");
		System.out.print("Enter the LastName:");
		ps.setString(2,sc.next());
        System.out.print("\n");
        System.out.print("Enter the DateOfBrith: ");
        ps.setString(3,sc.next());
        System.out.print("\n");
        System.out.print("Enter the PhoneNumber:");
        ps.setInt(4,sc.nextInt());
        System.out.print("\n");
        System.out.print("Enter the Email:");
        ps.setString(5,sc.next());
        System.out.print("\n");
        System.out.print("Enter your Address:");
        ps.setString(6,sc.next());
        System.out.print("\n");
        System.out.print("Enter your State");
        ps.setString(7,sc.next());
        System.out.print("\n");
        System.out.print("Enter your PinCode:");
        ps.setString(8, sc.next());
        System.out.print("\n");
        System.out.print("Enter Your Religion:");
        ps.setString(9,sc.next());
		
		int res=ps.executeUpdate();
		if(res>0) {
			System.out.println("Values has been Inserted......");		
			}
		else {
			System.out.println("Values has not been Inserted......");
		}		
	}
	catch(ClassNotFoundException | SQLException e) 
	{
		System.out.println(e.getMessage());
	}
}
}