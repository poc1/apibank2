package com.redhat.developers.msa.ola;

import java.util.ArrayList;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.redhat.devopers.model.CustomerData;
import com.redhat.devopers.model.CustomerDocumentDetail;


@Service
public class CustomerService {

	ArrayList<CustomerData> customerDataList;	
	ArrayList<CustomerDocumentDetail> customerList;
	

	public CustomerService() {
		
		// para la speticiones por codigo de cliente, docoumentos(curp, pasaporte, rfc, etc)
		customerList = new ArrayList<CustomerDocumentDetail>();
		customerList.add(new CustomerDocumentDetail("CODIGO DE CLIENTE", "01", "11111", "20170107", "20170111", ""));
		customerList.add(new CustomerDocumentDetail("CODIGO DE CLIENTE", "01", "22222", "20170107", "20170509", ""));
		customerList.add(new CustomerDocumentDetail("RFC", "01", "MOVP830412111", "20170107", "20170509", ""));
		customerList.add(new CustomerDocumentDetail("RFC", "01", "MOVP830412222", "20170305", "20170608", ""));
		customerList.add(new CustomerDocumentDetail("CURP", "01", "MOVP830412HSLNLL01", "20170107", "20170509", ""));
		customerList.add(new CustomerDocumentDetail("CURP", "01", "MOVP830412HSLNLL02", "20170305", "20170608", ""));
		customerList.add(new CustomerDocumentDetail("PASAPORTE", "01", "12345", "20170107", "20170509", ""));
		customerList.add(new CustomerDocumentDetail("PASAPORTE", "01", "54321", "20170305", "20170608", ""));
		
		
		// para las peticiones de nombres y apellidos
		customerDataList = new ArrayList<CustomerData>();
		customerDataList.add(new CustomerData("11111", "", "ACEVES BARBOZA ADOLFO", "CLIENTE", "", "", "FISICA"));
		customerDataList.add(new CustomerData("22222", "GARRA TELEMARKETING", "MENDOZA BARBOZA ADOLFO", "CLIENTE", "RME RB", "", "FISICA"));
		customerDataList.add(new CustomerData("33333", "", "MILLAN CAMBEROS ANA", "PRECLIENTE", "", "", "FISICA"));
		customerDataList.add(new CustomerData("44444", "ENLACE ALQUIMIA", "ACEVES MIRANDA MANUEL", "REQUETECLIENTE", "RMARA2", "", "FISICA"));
		customerDataList.add(new CustomerData("55555", "DESENLAZADO", "QUINTANA RUIZ MARIA", "CLIENTE", "QUINTA", "", "FISICA"));
		customerDataList.add(new CustomerData("66666", "PRIMATE", "LUNA DUARTE JAIME", "CLIENTE", "LUNILLA", "", "FISICA"));
		customerDataList.add(new CustomerData("20019279", "", "COCA & HACTH PROPERTIES SA DE CV", "CLIENTE", "", "", "JURIDICA"));
		customerDataList.add(new CustomerData("27662675", "", "COCA COLA FEMSA DE VENEZUELA SA", "PRECLIENTE", "", "", "JURIDICA"));
		customerDataList.add(new CustomerData("28907552", "", "COCA COLA FEMSA O SUBSIDIARIAS SA DE CV", "PRECLIENTE", "", "", "JURIDICA"));
		customerDataList.add(new CustomerData("16249790", "", "COCA COLA FEMSA SA DE CV", "PROSPECT", "", "", "JURIDICA"));
		customerDataList.add(new CustomerData("79271378", "BANCO SANTANDER MEXICANO", "RASGADO POSADAS RUBEN", "CLIENTE", "PREMIER NUEVO", "BERNARDO QUINTANA", "FISICA"));
		
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
	public Iterable<CustomerData> getCustomerByName(String name, String paternal_name, String maternal_name)
		{
			ArrayList<CustomerData> it = new ArrayList<CustomerData>();
			ListIterator<CustomerData> iterator =  customerDataList.listIterator();
			while(iterator.hasNext()) {
				
				CustomerData data = iterator.next();
				name = name.toUpperCase();
				paternal_name = paternal_name.toUpperCase();
				maternal_name = maternal_name.toUpperCase();
				
				if( ((data.getFullName().contains(name) && !name.equals("") ) || name.equals("")) && 
					((data.getFullName().contains(paternal_name) && !paternal_name.equals("") ) || paternal_name.equals("")) && 
					((data.getFullName().contains(maternal_name) && !maternal_name.equals("") ) || maternal_name.equals("")) &&
					!(name.equals("") && paternal_name.equals("") && maternal_name.equals(""))
				   )
					it.add(data);
			}		
			return it;
	}
		
	

	// obtener clientes por compañia
	public Iterable<CustomerData> getCustomerByCompany(String company)
	{
			ArrayList<CustomerData> it = new ArrayList<CustomerData>();
			ListIterator<CustomerData> iterator =  customerDataList.listIterator();
			while(iterator.hasNext()) {
				
				CustomerData data = iterator.next();
				if(data.getFullName().contains(company.toUpperCase()) && !company.equals(""))
					it.add(data);
			}
			return it;
	}
		
	
	/**
	 * Obtener el cliente por numero de cuenta
	 * @param accountNumber
	 * @return
	 */
	public Iterable<CustomerData> getCustomerByAccountNumber(String accountNumber)
	{
		ArrayList<CustomerData> it = new ArrayList<CustomerData>();
		int numero = (int) (Math.random() * 10);
		it.add(customerDataList.get(numero));
				
		return it;
	}
	

}
