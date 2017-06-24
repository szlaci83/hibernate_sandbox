package me.laszloszoboszlai.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.laszloszoboszlai.hibernate.entity.Student;

public class PrimaryKeyDemo {

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
					System.out.println("Creating 3 new Student object...");
					Student newStudent1 = new Student("Bob", "Dylan", "bob.dylan@gmail.com");
					Student newStudent2 = new Student("Alice", "Cooper", "alice.cooper@gmail.com");
					Student newStudent3 = new Student("Paul", "McCartney", "paul.mccartney@gmail.com");
					
					//start transaction
					session.beginTransaction();
					
					//save the object
					System.out.println("Saving the students to DB...");
					session.save(newStudent1);
					session.save(newStudent2);
					session.save(newStudent3);
					
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				}
				finally{
					factory.close();
				} 

	}
}