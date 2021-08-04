package com.dao;

import java.io.PrintWriter;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.io.Compliance;
import com.io.Department;
import com.io.Employee;
import com.io.login;

public class adminDao {
	public static boolean validateAdmin(login Data) {
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.io.login.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String sql = "Select * from empdb.login where empId = " + Data.getEmpId() + " and passwd = \"" + Data.getPassword() + "\" and role=\"admin\"";
		System.out.println(sql);
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List output = query.list();
		
		transaction.commit();
		session.close();
		if(!output.isEmpty())
			return true;
		return false;
	}
	
	public static void insertEmployeeinDB(Employee e) {
		
		System.out.println(e);
		
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.io.Employee.class);
		configuration.addAnnotatedClass(com.io.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(e.getDepID());
		session.save(e);
		transaction.commit();
		session.close();
	}
	
	public static void deleteEmployeeFromDB(int empid) {
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.io.Employee.class);
		configuration.addAnnotatedClass(com.io.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee e1 = session.get(Employee.class, empid);
		System.out.println(e1);
		session.delete(e1);
		transaction.commit();
		session.close();
	}
	
	public static void updateEmployeeFromDB(int empId, Employee e) {	
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.io.Employee.class);
		configuration.addAnnotatedClass(com.io.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee updatedEmplyee = session.get(Employee.class, empId);
		session.save(e.getDepID());
		updatedEmplyee.setFname(e.getFname());
		updatedEmplyee.setLname(e.getLname());
		updatedEmplyee.setDob(e.getDob());
		updatedEmplyee.setEmail(e.getEmail());
		updatedEmplyee.setDepID(e.getDepID());
		
//		System.out.println(updatedEmplyee);
		
		transaction.commit();
		session.close();
	}
	
	public static Employee viewEmployeeFromDB(int empId) {
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.io.Employee.class);
		configuration.addAnnotatedClass(com.io.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = session.get(Employee.class, empId);
		session.close();
		
		return emp;
	}
	
	//Department DB
	public static void insertDepartmentinDB(Department d) {
		
		System.out.println(d);
		
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		//configuration.addAnnotatedClass(com.io.Employee.class);
		configuration.addAnnotatedClass(com.io.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		//session.save(e.getDepID());
		session.save(d);
		transaction.commit();
		session.close();
	}
	public static Department viewDepartmentFromDB(int depId) {
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		//configuration.addAnnotatedClass(com.io.Employee.class);
		configuration.addAnnotatedClass(com.io.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Department dep = session.get(Department.class, depId);
		session.close();
		
		return dep;
	}
	
	// Regulations
	public static void insertComplianceinDB(Compliance c) {
		
		System.out.println(c);
		
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.io.Compliance.class);
		configuration.addAnnotatedClass(com.io.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(c.getDept());
		session.save(c);
		transaction.commit();
		session.close();
	}
	public static Compliance viewComplianceFromDB(int compId) {
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.io.Department.class);
		configuration.addAnnotatedClass(com.io.Compliance.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Compliance comp = session.get(Compliance.class, compId);
		session.close();
		
		return comp;
	}
}
