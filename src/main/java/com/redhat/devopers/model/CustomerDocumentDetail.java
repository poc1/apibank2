package com.redhat.devopers.model;

public class CustomerDocumentDetail {

	private String documentType;
	private String documentSequence;
	private String documentNumber;
	private String expeditionDate;
	private String expirationDate;
	private String expeditorName;
	
	
	
	
	public CustomerDocumentDetail(String documentType, String documentSequence, String documentNumber,
			String expeditionDate, String expirationDate, String expeditorName) {
		super();
		this.documentType = documentType;
		this.documentSequence = documentSequence;
		this.documentNumber = documentNumber;
		this.expeditionDate = expeditionDate;
		this.expirationDate = expirationDate;
		this.expeditorName = expeditorName;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentSequence() {
		return documentSequence;
	}
	public void setDocumentSequence(String documentSequence) {
		this.documentSequence = documentSequence;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getExpeditionDate() {
		return expeditionDate;
	}
	public void setExpeditionDate(String expeditionDate) {
		this.expeditionDate = expeditionDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getExpeditorName() {
		return expeditorName;
	}
	public void setExpeditorName(String expeditorName) {
		this.expeditorName = expeditorName;
	}
	
	
	
	
}
