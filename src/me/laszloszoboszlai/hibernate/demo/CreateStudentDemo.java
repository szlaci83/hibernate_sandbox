package me.laszloszoboszlai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.laszloszoboszlai.hibernate.entity.Student;

public class CreateStudentDemo {

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
			//create the object
			System.out.println("Creating new Student object...");
			Student newStudent = new Student("Ben", "Smith", "ben.smith@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the object
			System.out.println("Saving the student details to DB...");
			session.save(newStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally{
			factory.close();
		}
	}				

}
