package demoAnt23.packgae;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class WriteData {
	 
	public void book1() throws IOException
	{
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("demoAnt2.demoAnt23.EntityClass");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		EntityTransaction entitytrasaction = entitymanager.getTransaction();
		try {
			entitytrasaction.begin();
	      String file = "C:/Users/nagsen.shinde/Documents/studentInfo.xlsx";
	      FileInputStream fileinputstring = new FileInputStream(file);
	      try (XSSFWorkbook workbook = new XSSFWorkbook(fileinputstring)) {
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			  Iterator<Row>iterator = sheet.iterator();
			  while(iterator.hasNext())
			  {
				  Row row = iterator.next();
				  EntityClass entityclass = new EntityClass();
				  entityclass.setId((int) row.getCell(0).getNumericCellValue());
				  entityclass.setName(row.getCell(1).getStringCellValue());
				  entitymanager.persist(entityclass);
			  }
		}
	      entitytrasaction.commit();
	      System.out.println("Data imported sucessfully");
	 
	}
		 
    catch(Exception e)
		{
    	if(entitytrasaction!= null  && entitytrasaction.isActive())
		{
			entitytrasaction.rollback();
		}
		System.out.println("data not found");
		}
  }
}

