package me.laszloszoboszlai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.laszloszoboszlai.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create session factory:
		SessionFactory factory = new Configuration()
							     .configure("hibernate.cfg.xml")
							     .addAnnotatedClass(Student.class)
							     .buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		//use session to save a Java object
		try{
			int studentId = 2;
			
			//get new session and start it
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//find the student by id 
			System.out.println("Looking for student with ID: "+ studentId);
			Student theStudent = session.get(Student.class, studentId);
			System.out.println("The student is: " + theStudent);
			
			//do the update
			System.out.println("Updating student...");
			theStudent.setEmail("foo@yahoo.com");
				
			//commit transaction
			session.getTransaction().commit();
			
			//start new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update all email
			System.out.println("Update all emails...");
			session.createQuery("update Student set email='foo@yahoo.com'")
				.executeUpdate();
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");	
		}
		finally{
			factory.close();
		} 
	}				

}
