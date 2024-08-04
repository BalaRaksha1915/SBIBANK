package SBI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin  {
	
private static Connection con;
public Admin() throws ClassNotFoundException, SQLException
{ 
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost/SBI_bank","root","1234");
	}
  public void ConClose() throws SQLException {
	  con.close();
  }
  public boolean login(String u , String p) throws SQLException
  {
	  String q="select * from admin where username=? and password=?";
	 PreparedStatement ps=con.prepareStatement(q);
	 ps.setString(1, u);
	 ps.setString(2, p);
	 ResultSet rs=ps.executeQuery();
	return rs.next();
	
  }
  public void view() throws SQLException
  {
	  
	  String q="select * from account_holder";
	  PreparedStatement ps= con.prepareStatement(q);
	  ResultSet rs=ps.executeQuery();
	  System.out.println("====Account holder infromation====");
	  System.out.println("---------------------------------------------------------------------------------------------------------------------");
	  System.out.println("firstname\t lastname\t date_of_brith\t phonenumber\t address\t pincode\t state \t religion");
	  System.out.println("---------------------------------------------------------------------------------------------------------------------");
	  while(rs.next())
	  {
		  System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+ rs.getString(3)+"\t"+ rs.getInt(4)+"\t"+
	                         rs.getString(5)+"\t"+ rs.getString(6)+"\t"+ rs.getString(7)+"\t"+ rs.getInt(8)+"\t"+ rs.getString(9));
	  }
	  System.out.println("---------------------------");
	  ps.execute();
	  }
  public int update(String address,int pin, String fi) throws SQLException
  {
      String q="update account_holder set address=?,pincode=? where firstname=?";
      PreparedStatement ps=con.prepareStatement(q);
      ps.setString(1,address);
      ps.setInt(2, pin);
      ps.setString(3, fi);
      return ps.executeUpdate();
  }
  public int update(String customerid, String firstname1) throws SQLException {
		String q="update account_holder set customerid=? where firstname=?";
	    PreparedStatement ps=con.prepareStatement(q);
	    ps.setString(1,customerid);
	    ps.setString(2,firstname1);
	    return ps.executeUpdate();
	}
  public int delete(String  firstname) throws SQLException
  {
      String q="delete from account_holder where  firstname=?";
      PreparedStatement ps=con.prepareStatement(q);
      ps.setString(1, firstname);
      return ps.executeUpdate();
  }
 /* public int deletename(String firstname) throws SQLException {
	  String q="delete from account_holder where firstname=?";
      PreparedStatement ps=con.prepareStatement(q);
      ps.setString(1, firstname);
      return ps.executeUpdate();
  }*/

   
}