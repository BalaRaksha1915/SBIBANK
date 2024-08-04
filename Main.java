package SBI;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account_holder accountHolder = new Account_holder();
        Admin admin = null;

        try {
            admin = new Admin();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Unable to connect to database: " + e);
            return;
        }

        boolean ex = false;
        while (!ex) {
        	
            System.out.println("    \n    "+"=== Welcome to SBI BANK ===");
            System.out.print("\n");
            System.out.println("1. Registaion For Account Holder");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("\nChoose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    
                    accountHolder.registeraccountholder();
                    break;

                case 2:
                    
                    System.out.print("Enter Username: ");
                    String username = sc.next();
                    System.out.print("Enter Password: ");
                    String password = sc.next();

                    try {
                        if (admin.login(username, password)) {
                            System.out.println("Login successful!");
                            boolean admin1= false;
                            while (!admin1) {
                                System.out.println("\n=== Admin Menu ===");
                                System.out.println("1. View Account Holders");
                                System.out.println("2. Update Account Holder");
                                System.out.println("3. Update Costumerid");
                                System.out.println("4. Delete Account Holder");
                                System.out.println("5. Logout");
                                System.out.print("Choose an option: ");
                                int adminChoice = sc.nextInt();

                                switch (adminChoice) {
                                    case 1:
                                        
                                        admin.view();
                                        break;

                                    case 2:
                                        
                                        System.out.print("Enter First Name of Account Holder to Update: ");
                                        String newfirstName = sc.next();
                                        System.out.print("Enter New Address: ");
                                        String newAddress = sc.next();
                                        System.out.print("Enter New Pincode: ");
                                        int newPincode = sc.nextInt();
                                        int updatedRows = admin.update(newAddress, newPincode, newfirstName);
                                        if (updatedRows > 0) {
                                            System.out.println("Account details updated successfully.");
                                        } else {
                                            System.out.println("Update failed. No account holder found with the given first name.");
                                        }
                                        break;
                                    case 3:
                                    	System.out.println("Enter the Fristname:");
                                    	String newfirstname1=sc.next();
                                    	System.out.println("Enter the CostumerId:");
                                    	String newcustomerid=sc.next();
                                    	int updatedRows1 = admin.update(newcustomerid,newfirstname1);
                                    	if (updatedRows1 > 0) {
                                            System.out.println("Account details updated successfully.");
                                        } else {
                                            System.out.println("Update failed. No account holder found with the given first name.");
                                        }
                                    	break;
                                        

                                    case 4:
                                        
                                        System.out.print("Enter Account Holder FirstName to Delete: ");
                                        String firstname = sc.next();
                                        int deletedRows = admin.delete(firstname);
                                        if (deletedRows > 0) {
                                            System.out.println("Account deleted successfully.");
                                        } else {
                                            System.out.println("Account deletion failed.");
                                        }
                                        break;

                                    case 5:
                                        
                                        admin1 = true;
                                        System.out.println("Logging out...");
                                        System.out.println("Thankyou for visting our Bank...");
                                        break;

                                    default:
                                        System.out.println("Invalid choice! Please try again.");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Invalid credentials! Please try again.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error during login: " + e);
                    }
                    break;

                case 3:
                    ex = true;
                    System.out.println("Thank you for using SBI Bank.");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        }

        sc.close();
       try {
            if (admin != null) {
                admin.ConClose();
            }
        } 
        catch (SQLException e) {
           System.out.println(e);
       }
    }
}
