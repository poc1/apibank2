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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.developers.pojo.Person;
import com.redhat.devopers.model.CustomerData;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
//@Api(value="API Customer", description="Customer Operations")
public class CustomerController {

	public final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
			this.customerService = customerService;
	}

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/holaclientes", produces = "text/plain")
    @ApiOperation("Hola clientes")
    public String holaclientes() {        
        return "Hola Customer !!!";
    }
    	
	
	// Búsqueda por codigo de cliente
	@RequestMapping(value="/code/{id}", method=RequestMethod.GET)
	@ApiOperation(value = "Código de Cliente",response = CustomerData.class, produces = "application/json")
	public Iterable<CustomerData> getCustomerByCode(@PathVariable final String id)
	{
		return customerService.getCustomerByCode(id);
	}
	
	@RequestMapping(value="/document/{curp}", method=RequestMethod.GET)
	@ApiOperation(value = "Documento del Cliente (RFC, CURP, PASAPORTE, ETC)",response = CustomerData.class, produces = "application/json")
	public Iterable<CustomerData> getCustomerByDocument(@PathVariable final String curp)
	{
		return customerService.getCustomerByDocument(curp);
	}
	
	
	@RequestMapping(value="/name/", method=RequestMethod.POST)
	@ApiOperation(value = "Nombre y Apellido Paterno o Nombre, Apellido Paterno y Materno o Apellido Paterno y Apellido Materno",response = CustomerData.class, produces = "application/json")
	public Iterable<CustomerData> getCustomerByDocument(@RequestBody Person person)
	{
		return customerService.getCustomerByName(person);
	}	
	
	@RequestMapping(value="/company/{company}", method=RequestMethod.GET)
	@ApiOperation(value = "Nombre de la Empresa",response = CustomerData.class, produces = "application/json")
	public Iterable<CustomerData> getCustomerByCompany(@PathVariable final String company)
	{
		return customerService.getCustomerByCompany(company);
	}
	
	@RequestMapping(value="/accountnum/{account}", method=RequestMethod.GET)
	@ApiOperation(value = "Número de Cuenta", response = String.class, produces = "application/json")
	public /*CustomerData*/ String getCustomerByCode(@PathVariable final long account)
	{
		return customerService.getCustomerByAccountNumber(account);
	}

}
