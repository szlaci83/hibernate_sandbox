package me.laszloszoboszlai.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.laszloszoboszlai.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory:
		SessionFactory factory = new Configuration()
							     .configure("hibernate.cfg.xml")
							     .addAnnotatedClass(Student.class)
							     .buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		//use session to save a Java object
		try{
			//start transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student s where s.lastName='Dylan' or "
										+" s.firstName='Axel' and s.email LIKE '%gmail.com'").list();
			
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally{
			factory.close();
		} 
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student aStudent : theStudents){
			System.out.println(aStudent);
		}
	}				

}
