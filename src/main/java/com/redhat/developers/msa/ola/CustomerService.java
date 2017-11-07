package com.redhat.developers.msa.ola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
		customerDataList.add(new CustomerData("22222", "GARRA TELEMARKETING", "ACEVES BARBOZA ADOLFO", "CLIENTE", "RME RB", "", "FISICA"));
		customerDataList.add(new CustomerData("33333", "", "ACEVES CAMBEROS ADOLFO", "PRECLIENTE", "", "", "FISICA"));
		customerDataList.add(new CustomerData("44444", "ENLACE ALQUIMIA", "INSUNZA CUELLAR MANUELA", "REQUETECLIENTE", "RMARA2", "", "FISICA"));
		customerDataList.add(new CustomerData("55555", "DESENLAZADO", "QUINTANA RUIZ MARIA", "CLIENTE", "QUINTA", "", "FISICA"));
		customerDataList.add(new CustomerData("66666", "PRIMATE", "LUNA DUARTE JAIME", "CLIENTE", "LUNILLA", "", "FISICA"));
		
	}
	
	// PARA LA BUSQUEDA POR por CLIENTE, REGRESA UNA LISTA DE CustomerDocumentRetail ( igual que la busqueda de documentos )
	public Iterable<CustomerDocumentDetail> getCustomerByCode(String code)
	{
		ArrayList<CustomerDocumentDetail> it = new ArrayList<CustomerDocumentDetail>();
		ListIterator<CustomerDocumentDetail> iterator =  customerList.listIterator();
		while(iterator.hasNext()) {
				
			CustomerDocumentDetail data = iterator.next();
			if(data.getDocumentNumber().equals(code))
				it.add(data);
		}
		return it;		
	}
		
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
				if(data.getFullName().contains(person.getName()) || data.getFullName().contains(person.getFirstName()) || data.getFullName().contains(person.getLastName()))
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

	
	
	// ----------------------------------------------------------------------
	// ANTIGUOS METODOS
	
	
	
//	// busqueda por codigo de cliente
//	public Iterable<CustomerData> getCustomerByCode(String code)
//	{
//		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
//		ListIterator<CustomerData> iterator =  customerList.listIterator();
//		while(iterator.hasNext()) {
//			
//			CustomerData data = iterator.next();
//			if(data.getCustomerId().equals(code))
//				it.add(data);
//		}
//		return it;		
//	}
//	
//    // regresa el primer elemento por el momento ya que no tengo curp en el model ( hasta que se implemente la llamada a la API )
//	public Iterable<CustomerData> getCustomerByDocument(String curp)
//	{
//		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
//		it.add(customerList.get(0));
//		it.add(customerList.get(1));
//		return it;
//	}
//	
//	public Iterable<CustomerData> getCustomerByName(Person person)
//	{
//		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
//		ListIterator<CustomerData> iterator =  customerList.listIterator();
//		while(iterator.hasNext()) {
//			
//			CustomerData data = iterator.next();
//			if(data.getFullName().contains(person.getName()) || data.getFullName().contains(person.getFirstName()) || data.getFullName().contains(person.getLastName()))
//				it.add(data);
//		}		
//		return it;
//	}
//	
//	public Iterable<CustomerData> getCustomerByCompany(String company)
//	{
//		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
//		ListIterator<CustomerData> iterator =  customerList.listIterator();
//		while(iterator.hasNext()) {
//			
//			CustomerData data = iterator.next();
//			if(data.getFullName().contains(company))
//				it.add(data);
//		}		
//		return it;
//	}
//	
//	// regresa el primer elemento por el momento ya que no tengo account number en el model ( hasta que se implemente la llamada a la API )
//	public /*CustomerData*/ String getCustomerByAccountNumber(long accountNumber)
//	{
//		StringBuffer response = new StringBuffer();
//		
//		try {
//		
//		// https://customermtemp.mybluemix.net/api/customer/accountnum/21332432
//		// Accept:application/json
//		// Content-Type:application/json
//		
//		  String urlString = "https://customermtemp.mybluemix.net/api/customer/accountnum/" + accountNumber;
//		  
//		  URL url = new URL(urlString);
//		  HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		 
//		  // By default it is GET request
//		  con.setRequestMethod("GET");
//		 
//		  //add request header
//		  con.setRequestProperty("Accept", "application/json");
//		  con.setRequestProperty("Content-Type", "application/json");
//		 
//		  //int responseCode = con.getResponseCode();
//			 
//		  // Reading response from input Stream
//		  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//		  String output;
//		  		 
//		  while ((output = in.readLine()) != null) {
//		   response.append(output);
//		  }
//		  in.close();
//		  
//		}catch(IOException ex) {
//			System.out.println(ex.getMessage());
//		}
//		
//	  // System.out.println(response.toString());
//	  return response.toString();		
//	  // return customerList.get(0);
//	}
	
	

}
