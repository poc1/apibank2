package com.redhat.developers.msa.ola;

import java.util.ArrayList;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.redhat.developers.pojo.Person;
import com.redhat.devopers.model.CustomerData;
import com.redhat.devopers.model.CustomerDocumentDetail;


@Service
public class CustomerService {

	ArrayList<CustomerData> customerDataList;	
	ArrayList<CustomerDocumentDetail> customerList;
	

	public CustomerService() {
		
		// para la speticiones por codigo de cliente, docoumentos(curp, pasaporte, rfc, etc)
		customerList = new ArrayList<CustomerDocumentDetail>();
		customerList.add(new CustomerDocumentDetail("Codigo de Cliente", "01", "22222", "20170107", "20170111", ""));
		customerList.add(new CustomerDocumentDetail("Codigo de Cliente", "01", "11111", "20170107", "20170509", ""));
		customerList.add(new CustomerDocumentDetail("RFC", "01", "MIRFC1", "20170107", "20170509", ""));
		customerList.add(new CustomerDocumentDetail("RFC", "01", "MIRFC2", "20170305", "20170608", ""));
		customerList.add(new CustomerDocumentDetail("CURP", "01", "MICURP1", "20170107", "20170509", ""));
		customerList.add(new CustomerDocumentDetail("CURP", "01", "MICURP2", "20170305", "20170608", ""));
		customerList.add(new CustomerDocumentDetail("PASAPORTE", "01", "MIPASAPORTE1", "20170107", "20170509", ""));
		customerList.add(new CustomerDocumentDetail("PASAPORTE", "01", "MIPASAPORTE2", "20170305", "20170608", ""));
		
		
		// para las peticiones de nombres y apellidos
		customerDataList = new ArrayList<CustomerData>();
		customerDataList.add(new CustomerData("11111", "", "ACEVES BARBOZA ADOLFO", "CLIENTE", "", "", "FISICA"));
		customerDataList.add(new CustomerData("22222", "GARRA TELEMARKETING", "MENDOZA BARBOZA ADOLFO", "CLIENTE", "RME RB", "", "FISICA"));
		customerDataList.add(new CustomerData("33333", "", "MILLAN CAMBEROS ANA", "PRECLIENTE", "", "", "FISICA"));
		customerDataList.add(new CustomerData("44444", "ENLACE ALQUIMIA", "ACEVES MIRANDA MANUEL", "REQUETECLIENTE", "RMARA2", "", "FISICA"));
		customerDataList.add(new CustomerData("55555", "DESENLAZADO", "QUINTANA RUIZ MARIA", "CLIENTE", "QUINTA", "", "FISICA"));
		customerDataList.add(new CustomerData("66666", "PRIMATE", "LUNA DUARTE JAIME", "CLIENTE", "LUNILLA", "", "FISICA"));
		
	}
	
//	// PARA LA BUSQUEDA POR por CLIENTE, REGRESA UNA LISTA DE CustomerDocumentRetail ( igual que la busqueda de documentos )
	// ESTE METODO SE HOMOLOGA CON EL DE DOCUMENTOS YA QUE EN  EL API DEL CLENTE ES EL MISMO METODO PARA ESTE TAMBIEN
//	public Iterable<CustomerDocumentDetail> getCustomerByCode(String code)
//	{
//		ArrayList<CustomerDocumentDetail> it = new ArrayList<CustomerDocumentDetail>();
//		ListIterator<CustomerDocumentDetail> iterator =  customerList.listIterator();
//		while(iterator.hasNext()) {
//				
//			CustomerDocumentDetail data = iterator.next();
//			if(data.getDocumentNumber().equals(code))
//				it.add(data);
//		}
//		return it;		
//	}
		
    // PARA LA BUSQUEDA POR DOCUMENTOS DEL CLIENTE, REGRESA UNA LISTA DE CustomerDocumentRetail
	// donde DOCUMENTO puede ser la curp, pasaporte, rfc, etc
	public Iterable<CustomerDocumentDetail> getCustomerByDocument(String DOCUMENTO)
		{
			ArrayList<CustomerDocumentDetail> it = new ArrayList<CustomerDocumentDetail>();
			ListIterator<CustomerDocumentDetail> iterator =  customerList.listIterator();
			while(iterator.hasNext()) {
				
				CustomerDocumentDetail data = iterator.next();
				if(data.getDocumentNumber().equals(DOCUMENTO))
					it.add(data);
			}
			return it;	
		}
	
	
	// CONSULTA DE CustomerData por el nombre, apellido paterno y/o materno
	public Iterable<CustomerData> getCustomerByName(Person person)
		{
			ArrayList<CustomerData> it = new ArrayList<CustomerData>();
			ListIterator<CustomerData> iterator =  customerDataList.listIterator();
			while(iterator.hasNext()) {
				
				CustomerData data = iterator.next();
				
				if( (data.getFullName().contains(person.getName()) && !person.getName().equals("") ) || 
					(data.getFullName().contains(person.getPaternal_name()) && !person.getPaternal_name().equals("") ) || 
					(data.getFullName().contains(person.getMaternal_name()) && !person.getMaternal_name().equals(""))
				   )
					it.add(data);
			}		
			return it;
	}
		
	
	// de momento queda devolviendo el CustomerData hasta que se defina con el cliente si devuelve algo distinto
	public Iterable<CustomerData> getCustomerByCompany(String company)
	{
			ArrayList<CustomerData> it = new ArrayList<CustomerData>();
			ListIterator<CustomerData> iterator =  customerDataList.listIterator();
			while(iterator.hasNext()) {
				
				CustomerData data = iterator.next();
				if(data.getFullName().contains(company))
					it.add(data);
			}		
			return it;
	}
		
	
	// de momento queda devolviendo el CustomerData hasta que se defina con el cliente si devuelve algo distinto
	public Iterable<CustomerData> getCustomerByAccountNumber(String accountNumber)
	{
		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
		ListIterator<CustomerData> iterator =  customerDataList.listIterator();
		while(iterator.hasNext()) {
			
			CustomerData data = iterator.next();
			if(data.getCustomerId().equals(accountNumber))
				it.add(data);
		}		
		return it;
	}
	

}
