package com.childcare.dao;
import java.sql.*;
import java.util.*;

import com.childcare.bean.Baby;


public class BabyDao {

	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static int save(Baby b){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("insert into babyname(name,meaning,sex,religion) values(?,?,?,?)");
			ps.setString(1,b.getName());
			ps.setString(2,b.getMeaning());
			ps.setString(3,b.getSex());
			ps.setString(4,b.getReligion());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("delete from babyname where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static List<Baby> getAllRecords(){
		List<Baby> list=new ArrayList<Baby>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from babyname");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setMeaning(rs.getString(3));
				b.setSex(rs.getString(4));
				b.setReligion(rs.getString(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static List<Baby> getRecordsByStart(String start){
		List<Baby> list=new ArrayList<Baby>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from babyname where name like '"+start+"%' ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setMeaning(rs.getString(3));
				b.setSex(rs.getString(4));
				b.setReligion(rs.getString(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static List<Baby> getRecordsByReligion(String religion){
		List<Baby> list=new ArrayList<Baby>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from babyname where religion=? ");
			ps.setString(1,religion);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setMeaning(rs.getString(3));
				b.setSex(rs.getString(4));
				b.setReligion(rs.getString(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static List<Baby> getRecordsByIndianName(String indian){
		List<Baby> list=new ArrayList<Baby>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from `indian-male-names`");
			ps.setString(1,indian);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setName(rs.getString(1));
				b.setSex(rs.getString(2));
				b.setRace(rs.getString(3));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	  public static boolean validate(String name, String pass) {        
	        boolean status = false;
	        //Connection con = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;

	        
	        try {
	          
	        	Connection con=getCon();
				PreparedStatement ps=con.prepareStatement("select * from users where user=? and password=?");
	                    
	            ps.setString(1, name);
	            ps.setString(2, pass);

	            rs = ps.executeQuery();
	            status = rs.next();

	        } catch (Exception e) {
	            System.out.println(e);
	        } finally {
	          
	            if (pst != null) {
	                try {
	                    pst.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return status;
	    }

	public static List<Baby> getRecordsByIndianName() {
		List<Baby> list=new ArrayList<Baby>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from `indian-male-names`");
		//	ps.setString(1,indian);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setName(rs.getString(1));
				b.setSex(rs.getString(2));
				b.setRace(rs.getString(3));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static List<Baby> getAllDoctorsRecords(){
		List<Baby> list=new ArrayList<Baby>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from doctors");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setCity(rs.getString(3));
				b.setPhone(rs.getString(4));
				b.setImageData(rs.getBlob(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}

	public static int saveDoctorsData(Baby b) {
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("insert into doctors(name,city,phone) values(?,?,?)");
			ps.setString(1,b.getName());
			ps.setString(2,b.getCity());
			ps.setString(3,b.getPhone());
			
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e)
		{System.out.println(e);}
		return status;
	}
}
