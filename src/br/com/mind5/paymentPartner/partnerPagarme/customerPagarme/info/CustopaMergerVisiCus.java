package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CustopaMergerVisiCus extends InfoMergerVisitorTemplate<CustopaInfo, CusInfo> {

	@Override public boolean shouldMerge(CustopaInfo baseInfo, CusInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<CustopaInfo> merge(CustopaInfo baseInfo, CusInfo selectedInfo) {
		List<CustopaInfo> results = new ArrayList<>();
		
		baseInfo.name     		= getCustomerName(baseInfo, selectedInfo);
		baseInfo.email    		= getCustomerEmail(baseInfo, selectedInfo);
		baseInfo.code     		= getCustomerCode(baseInfo, selectedInfo);
		baseInfo.document 		= getCustomerDocument(baseInfo, selectedInfo);
		baseInfo.documentType 	= getCustomerDocumentType(baseInfo, selectedInfo);
		baseInfo.type 			= getCustomerType(baseInfo, selectedInfo);
		baseInfo.gender 		= getCustomerGender(baseInfo, selectedInfo);
		baseInfo.birthdate 		= getCustomerBirthdate(baseInfo, selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private String getCustomerName(CustopaInfo baseInfo, CusInfo selectedInfo) {
		if (baseInfo.name != null)
			return baseInfo.name;
		
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.name == null)
			return null;
		
		return selectedInfo.personData.name;
	}
	
	
	
	private String getCustomerEmail(CustopaInfo baseInfo, CusInfo selectedInfo) {
		if (baseInfo.email != null)
			return baseInfo.email;
		
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.email == null)
			return null;
		
		return selectedInfo.personData.email;
	}
	
	
	
	private String getCustomerCode(CustopaInfo baseInfo, CusInfo selectedInfo) {
		return selectedInfo.codOwner + "-" + selectedInfo.codCustomer;
	}
	
	
	
	private String getCustomerDocumentType(CustopaInfo baseInfo, CusInfo selectedInfo) {
		if (baseInfo.documentType != null)
			return baseInfo.documentType;
		
		if (getCustomerDocument(baseInfo, selectedInfo) == null)
			return null;
		
		return "CPF";
	}
	
	
	
	private String getCustomerDocument(CustopaInfo baseInfo, CusInfo selectedInfo) {
		if (baseInfo.document != null)
			return baseInfo.document;
		
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.cpf == null)
			return null;
		
		return selectedInfo.personData.cpf;
	}
	
	
	
	private String getCustomerType(CustopaInfo baseInfo, CusInfo selectedInfo) {
		if (baseInfo.type != null)
			return baseInfo.type;
		
		return "individual";
	}
	
	
	
	private String getCustomerGender(CustopaInfo baseInfo, CusInfo selectedInfo) {
		if (baseInfo.gender != null)
			return baseInfo.gender;
		
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.codGender == 2)
			return "male";
		
		if (selectedInfo.personData.codGender == 3)
			return "female";
		
		return null;
	}
	
	
	
	private String getCustomerBirthdate(CustopaInfo baseInfo, CusInfo selectedInfo) {
		if (baseInfo.birthdate != null)
			return baseInfo.birthdate;
		
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.birthDate == null)
			return null;
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return selectedInfo.personData.birthDate.format(formatter);
	}
}
