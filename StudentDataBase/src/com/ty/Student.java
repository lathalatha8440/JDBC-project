package com.ty;

import java.util.Scanner;

public class Student {
	public static void main(String[] args) {
		StudentInterface si=new StudentImplementation();
		Scanner ip=new Scanner(System.in);
		while(true)
		{
			System.out.println("============welcome to student database============");
			System.out.println("1.addStudent\n2.deletestudent\n3.updatestudent\n4.getstudentbymarks\n5.getallstudent");
			System.out.println("enter choice");
			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:
				si.addStudent();
				System.out.println("student data added successfully");
				break;
			case 2:
				si.deleteStudent();
				System.out.println("student data deleted successfully");
				break;
			case 3:
				si.updateStudent();
				 System.out.println("student data updated successfully");
				 break;
			case 4:
				si.getStudentbyMarks();
				 System.out.println("get  student data  successfully");
				 break;
			case 5:
				si.getAllStudent();
				 System.out.println(" get all student data added successfully");
				 break;
				 default:
					 System.out.println("invalid choice");


			}
		}
	}

}
