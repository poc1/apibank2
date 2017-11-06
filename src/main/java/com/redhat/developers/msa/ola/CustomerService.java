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


@Service
public class CustomerService {

	ArrayList<CustomerData> customerList;	
	

	public CustomerService() {
		customerList = new ArrayList<CustomerData>();
		customerList.add(new CustomerData("11111", "BANCA SERFIN", "ACEVES GONZALEZ ADOLFO", "CLIENTE", "PREMIER", "LOMA BONITA 1839", "FISICA"));
		customerList.add(new CustomerData("22222", "", "COCA & HACTH PROPERTIES SA DE CV", "CLIENTE", "", "", "JURIDICA"));
		customerList.add(new CustomerData("33333", "", "COCA COLA FEMSA DE VENEZUELA SA", "PRECLIENTE", "", "", "JURIDICA"));
		customerList.add(new CustomerData("44444", "BANCO SANTANDER MEXICANO", "FERNANDEZ RODRIGUEZ MARIA FERNANDA", "CLIENTE", "BANCA PRIVADA", "AHUEHETE", "FISICA"));
	}
	
	// busqueda por codigo de cliente
	public Iterable<CustomerData> getCustomerByCode(String code)
	{
		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
		ListIterator<CustomerData> iterator =  customerList.listIterator();
		while(iterator.hasNext()) {
			
			CustomerData data = iterator.next();
			if(data.getCustomerId().equals(code))
				it.add(data);
		}
		return it;		
	}
	
    // regresa el primer elemento por el momento ya que no tengo curp en el model ( hasta que se implemente la llamada a la API )
	public Iterable<CustomerData> getCustomerByDocument(String curp)
	{
		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
		it.add(customerList.get(0));
		it.add(customerList.get(1));
		return it;
	}
	
	public Iterable<CustomerData> getCustomerByName(Person person)
	{
		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
		ListIterator<CustomerData> iterator =  customerList.listIterator();
		while(iterator.hasNext()) {
			
			CustomerData data = iterator.next();
			if(data.getFullName().contains(person.getName()) || data.getFullName().contains(person.getFirstName()) || data.getFullName().contains(person.getLastName()))
				it.add(data);
		}		
		return it;
	}
	
	public Iterable<CustomerData> getCustomerByCompany(String company)
	{
		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
		ListIterator<CustomerData> iterator =  customerList.listIterator();
		while(iterator.hasNext()) {
			
			CustomerData data = iterator.next();
			if(data.getFullName().contains(company))
				it.add(data);
		}		
		return it;
	}
	
	// regresa el primer elemento por el momento ya que no tengo account number en el model ( hasta que se implemente la llamada a la API )
	public /*CustomerData*/ String getCustomerByAccountNumber(long accountNumber)
	{
		StringBuffer response = new StringBuffer();
		
		try {
		
		// https://customermtemp.mybluemix.net/api/customer/accountnum/21332432
		// Accept:application/json
		// Content-Type:application/json
		
		  String urlString = "https://customermtemp.mybluemix.net/api/customer/accountnum/" + accountNumber;
		  
		  URL url = new URL(urlString);
		  HttpURLConnection con = (HttpURLConnection) url.openConnection();
		 
		  // By default it is GET request
		  con.setRequestMethod("GET");
		 
		  //add request header
		  con.setRequestProperty("Accept", "application/json");
		  con.setRequestProperty("Content-Type", "application/json");
		 
		  //int responseCode = con.getResponseCode();
			 
		  // Reading response from input Stream
		  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		  String output;
		  		 
		  while ((output = in.readLine()) != null) {
		   response.append(output);
		  }
		  in.close();
		  
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	  // System.out.println(response.toString());
	  return response.toString();		
	  // return customerList.get(0);
	}
	
	

}
