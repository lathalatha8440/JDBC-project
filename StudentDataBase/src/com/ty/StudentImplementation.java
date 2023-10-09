package com.ty;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImplementation implements StudentInterface {
Scanner sc=new Scanner(System.in);

@Override
public void addStudent()
{
	System.out.println("Enter student id:");
	int id=sc.nextInt();
	
	System.out.println("Enter student name:");
	String name=sc.next();
	
	System.out.println("Enter student age:");
	int age=sc.nextInt();
	
	System.out.println("Enter student gender:");
	String gender=sc.next();
	
	System.out.println("Enter student marks:");
	double marks=sc.nextDouble();
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
		PreparedStatement ps=connection.prepareStatement("insert into student values(?,?,?,?,?)");
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setInt(3,age);
		ps.setString(4,gender);
		ps.setDouble(5,marks);
		ps.execute();
		connection.close();
		System.out.println("Data saved");
	}
	catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
}

 @Override
  public void deleteStudent()
   {
	System.out.println("Enter student age:");
	int age=sc.nextInt();
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
		PreparedStatement ps=connection.prepareStatement("delete from student where age>?");
		ps.setInt(1,age);
		ps.execute();
		connection.close();
		System.out.println("data deleted");
	}
	catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
   }
 
 @Override
 public void updateStudent()
 {
	 System.out.println("Enter student marks:");
		double marks=sc.nextDouble();
		 System.out.println("Enter student id:");
		 int id=sc.nextInt();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement ps=connection.prepareStatement("update student set marks=? where id=?");
			ps.setDouble(1,marks);
			ps.setInt(2,id);
			ps.execute();
			connection.close();
			System.out.println("data updated");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}

	}
 @Override
 public void getStudentbyMarks()
 {
	 System.out.println("Enter marks:");
		double marks=sc.nextDouble(); 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement ps=connection.prepareStatement("select * from student where marks=?");
			ps.setDouble(1,marks);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("ID:"+rs.getInt(1));
				System.out.println("NAME:"+rs.getString(2));
				System.out.println("AGE:"+rs.getInt(3));
				System.out.println("GENDER:"+rs.getString(4));
				System.out.println("MARKS:"+rs.getDouble(5));
				System.out.println("==============");
				
			}
			connection.close();
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
				
 }
 
 @Override
 public void getAllStudent()
 {
	 try
	 {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement ps=connection.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("ID:"+rs.getInt(1));
				System.out.println("NAME:"+rs.getString(2));
				System.out.println("AGE:"+rs.getInt(3));
				System.out.println("GENDER:"+rs.getString(4));
				System.out.println("MARKS:"+rs.getDouble(5));
				System.out.println("==============");
			}
			connection.close();
	 }
	 catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
}

}