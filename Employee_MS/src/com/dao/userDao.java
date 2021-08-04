package com.dao;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.io.Compliance;
import com.io.login;


public class userDao {
	
	public static boolean validateUser(login Data) {
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.io.login.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String sql = "Select * from empdb.login where empId = " + Data.getEmpId() + " and passwd = \"" + Data.getPassword() + "\"";
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
	public static ArrayList<Compliance> viewRegulations(String id) {
		Configuration configuration = new Configuration().configure("/com/control/hibernate.cfg.xml");
		configuration.addAnnotatedClass(com.io.StatusReport.class);
		configuration.addAnnotatedClass(com.io.Employee.class);
		configuration.addAnnotatedClass(com.io.Compliance.class);
		configuration.addAnnotatedClass(com.io.Department.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String sql = "Select comp_ComplianceID from empdb.StatusReport where emp_empid = " +id;
		System.out.println(sql);
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List output = query.list();
		
		ArrayList<Compliance> l = new ArrayList<Compliance>();
		for(Object o:output) {
			Map d = (Map) o;
			int compid = Integer.parseInt(d.get("comp_ComplianceID").toString());
			l.add(session.get(com.io.Compliance.class, compid));
		}
		
		transaction.commit();
		session.close();
		return l;
	}
}



//create table empdb.login(
//		empid int primary key,
//	    passwd varchar(255),
//	    role varchar(10))


//insert into empdb.login values(1, "tom", "user");
//insert into empdb.login values(2, "admin", "admin")