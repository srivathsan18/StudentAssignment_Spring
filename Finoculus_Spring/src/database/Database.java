package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	static Connection con=null;
	
	 public static Connection getConnection(){  
         
	        try{  
	        	 Class.forName("oracle.jdbc.driver.OracleDriver");  
	            if(con==null)
	            {
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");  
	        }
	            
	        }
	        catch(Exception e)
	        {System.out.println(e);}  
	        
	   return con;
	   
	}
	

}
