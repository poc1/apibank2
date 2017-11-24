/**
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.developers.msa.ola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.devopers.model.CustomerData;
import com.redhat.devopers.model.CustomerDocumentDetail;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	public final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
			this.customerService = customerService;
	}

	

	/**
	 * Búsqueda por codigo de cliente y por Documento
	 * @param document_number
	 * @return
	 */
	@RequestMapping(value="/document", method=RequestMethod.GET)
	@ApiOperation(value = "Documentos y codigo del Cliente (RFC, CURP, PASAPORTE, CODIGO DE CLIENTE)", response = CustomerDocumentDetail.class, produces = "application/json")
	public @ResponseBody Iterable<CustomerDocumentDetail> getCustomerByDocument(@RequestParam(value="document_number", required = true, defaultValue = "") String document_number)
	{
		return customerService.getCustomerByDocument(document_number);
	}
	
	 
	/**
	 * Busqueda por nombre, apellido paterno, materno, etc 
	 * @param person
	 * @return
	 */
	@RequestMapping(value="/name", method=RequestMethod.GET)
	@ApiOperation(value = "Nombre y Apellido Paterno o Nombre, Apellido Paterno y Materno o Apellido Paterno y Apellido Materno", response = CustomerData.class, produces = "application/json")
	public @ResponseBody Iterable<CustomerData> getCustomerByDocument(@RequestParam(value="name", required = false, defaultValue = "") String name, @RequestParam(value="paternal_name", required = false, defaultValue = "") String paternal_name, @RequestParam(value="maternal_name", required = false, defaultValue = "") String maternal_name)
	{
		return customerService.getCustomerByName(name, paternal_name, maternal_name);
	}	
	


	/**
	 * Busqueda por nombre de la empresa
	 * @param company_name
	 * @return
	 */
	@RequestMapping(value="/company", method=RequestMethod.GET)
	@ApiOperation(value = "Nombre de la Empresa", response = CustomerData.class, produces = "application/json")
	public @ResponseBody Iterable<CustomerData> getCustomerByCompany(@RequestParam(value="company_name", required = true, defaultValue = "") String company_name)
	{
		return customerService.getCustomerByCompany(company_name);
	}
	

	/**
	 * Búsqueda por numero de cuenta
	 * @param account_number
	 * @return
	 */
	@RequestMapping(value="/accountnum", method=RequestMethod.GET)
	@ApiOperation(value = "Número de Cuenta", response = CustomerData.class, produces = "application/json")
	public @ResponseBody Iterable<CustomerData> getCustomerByAccountNumber(@RequestParam(value="account_number", required = true, defaultValue = "") String account_number)
	{
		return customerService.getCustomerByAccountNumber(account_number);
	}

}
