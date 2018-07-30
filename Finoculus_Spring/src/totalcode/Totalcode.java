package totalcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.Database;
import pojo.Addpojo;
import pojo.Signinpojo;
import pojo.Signuppojo;
import pojo.Viewpojo;

public class Totalcode {

	public int signup(Signuppojo sp) {
		int i=0;
		try {
		Connection con=Database.getConnection();
		
		PreparedStatement ps=con.prepareStatement("insert into student1(email,password,name,id) values(?,?,?,?)");
		ps.setString(1, sp.getEmail());
		ps.setString(2, sp.getPass());
		ps.setString(3, sp.getName());
		ps.setString(4, sp.getSid());
		 i=ps.executeUpdate();
        }
		catch(Exception e) {
			System.out.println("Signup method error" +e);			
		}
		return i;
	}
	
	
	//*************************************************************************
	public String signin(Signinpojo si) {
		int i=0;
		String id="";
		try {
			Connection con=Database.getConnection();
			PreparedStatement ps=con.prepareStatement("select password,id from student1 where email=?");
			ps.setString(1,si.getEmail());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				id=rs.getString(2);
			}
			else 
				return "";
			
			
		}catch(Exception e) {
			
		}
		
		
		return id;
		
	}
	
	//*****************************************************************************
	
	public ArrayList<Viewpojo> view(String id) {
		ArrayList<Viewpojo> ar=new ArrayList();
		try {
			
			Connection con=Database.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from assignment1 where id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Viewpojo vp=new Viewpojo();

				vp.setAssignname(rs.getString(1));
				vp.setAssigndate(rs.getString(2));
				vp.setStatus(rs.getString(3));
				vp.setAid(rs.getInt(5));
				ar.add(vp);
			}
		}catch(Exception e) {
			
		}
	
		return ar;
		
	}
	
	//*********************************************************************************
	
public int add (Addpojo a) {
	int i=0;
	try {
		
		Connection con=Database.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into assignment1 values(?,?,?,?,AID.nextval)");
	    ps.setString(1, a.getAssignname());
	    ps.setString(2, a.getAssigndate());
	    ps.setString(3, a.getStatus());
	    ps.setString(4, a.getId());
	    i=ps.executeUpdate();

	}catch(Exception e) {
		
	}
	
	return i;
}
	//*********************************************************************************8
	
public Viewpojo viewbyid(String id,int aid) {
	
  Viewpojo vp=null;
	try {
		
		Connection con=Database.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from assignment1 where id=? AND aid=?");
		ps.setString(1,id);
		ps.setInt(2,aid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			 vp=new Viewpojo();
			vp.setAssignname(rs.getString(1));
			vp.setAssigndate(rs.getString(2));
			vp.setStatus(rs.getString(3));
			vp.setAid(rs.getInt(5));
			
			
		}
	}catch(Exception e) {
		
	}

	return vp;
	
}


 //**********************************************************************************
public int update(Viewpojo v,String id) {
	int i=0;
try {
		
		Connection con=Database.getConnection();
		PreparedStatement ps=con.prepareStatement("update assignment1 set assignname=?,assigndate=?,status=? where id=? AND aid=?");
	    ps.setString(1, v.getAssignname());
	    ps.setString(2, v.getAssigndate());
	    ps.setString(3, v.getStatus());
	    ps.setString(4, id);
	    ps.setInt(5, v.getAid());
	    i=ps.executeUpdate();

	}catch(Exception e) {
		
	}
	
	
	
	return i;
}

//***************************************************************************************

public int delete(String id,int aid) {
	int i=0;
try {
	System.out.println();
		
		Connection con=Database.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from assignment1 where id=? AND aid=?");
	    ps.setString(1,id);
	    ps.setInt(2,aid);
	 
	    i=ps.executeUpdate();

	}catch(Exception e) {
		System.out.println("delete error");
		
	}
	
	
	
	return i;
	
	
}
















}
