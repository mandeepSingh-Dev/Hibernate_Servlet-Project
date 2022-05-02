package FileDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jvnet.fastinfoset.VocabularyApplicationData;

import Entity.Files;

public class FilesModel {

	SessionFactory factory = new Configuration()
			.configure("hibernate-configuration.xml")
			.addAnnotatedClass(Files.class)
			.buildSessionFactory();
	
	public void addData(Files file) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(file);
		session.getTransaction().commit();
	}

	public List<Files> readAllFiles(){
		Session session  = factory.getCurrentSession();
	
		session.beginTransaction();
     	List<Files> list  =	session.createQuery("from files").getResultList();
		session.getTransaction().commit();
		
		return list;
	}
	
	public Files readAfile(int id) {
		Session session = factory.getCurrentSession();
	
		session.beginTransaction();
		Files file =  session.get(Files.class, id);
		session.getTransaction().commit();
		return file;	
	}
	
	public void updateAFile(Files  file , Files fileDatatoUpdate)
	{
		Session session = factory.getCurrentSession();
		session.beginTransaction();
	
		//	Files file = session.get(Files.class, id );
		file.setLabel(fileDatatoUpdate.getLabel());
		file.setCaption(fileDatatoUpdate.getCaption());
		file.setUsername(fileDatatoUpdate.getUsername());
    	file.setRollnumber(fileDatatoUpdate.getRollnumber());
		
		session.update(file);
		session.getTransaction().commit();
		
	}
	
	
}
