package student;

import java.util.Scanner;

public class StudentMain {
		public static void main(String[] args) {
			StudentCRUD st = new StudentCRUD();
		    boolean flag=true;
		do {
			Scanner scanner=new Scanner(System.in);
			  System.out.println("enter 1 for add student");
			  System.out.println("enter 2 for update student");
			  System.out.println("enter 3 to delete student");
			  System.out.println("enter 4 to get student data");
			  System.out.println("enter 5 to stop");
			  int choice =scanner.nextInt();
			  Student s = new Student();
			 
			  switch(choice) {
			  case 1:{		 
					System.out.println("enter the id");
					int id=scanner.nextInt();
					System.out.println("enter the name");
					String name=scanner.next();
					System.out.println("enter the age");
					int age=scanner.nextInt();
					System.out.println("enter the marks");
					int marks=scanner.nextInt();
					
					s.setId(id);
					s.setName(name);
					s.setAge(age);
					s.setMarks(marks);
				    try {
						st.insertStudent(s);
					} catch (Exception e) {
						System.out.println("student data is inserted");
					}
			  }break;
			  case 2:{
				 
				   System.out.println("enter the id");
				   int id=scanner.nextInt();
				   System.out.println("enter the name");
					String name=scanner.next();
				   
					s.setId(id);
					s.setName(name);
					
				   try {
					st.updateStudent(s);
						}
				catch (Exception e) {
					System.out.println("student data is updated");
				}
			  }break;
			  case 3:{
				  System.out.println("enter the id");
				   int id=scanner.nextInt();
				   s.setId(id);
				   try {
						st.deleteStudent(s);
							}
					catch (Exception e) {
						System.out.println("student data is deleted");
					}
				 
			  }break;
			  case 4:{
				  st.getStudent(s);
			  }break;
			  case 5:{
				  System.out.println("thank you");
				  flag=false;
			  }
				
			  }//end of switch
		}
		while(flag);
		}
	}
