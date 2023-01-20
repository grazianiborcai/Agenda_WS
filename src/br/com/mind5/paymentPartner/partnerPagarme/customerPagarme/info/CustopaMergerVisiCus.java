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
		
		baseInfo.name     		= getCustomerName(selectedInfo);
		baseInfo.email    		= getCustomerEmail(selectedInfo);
		baseInfo.code     		= getCustomerCode(selectedInfo);
		baseInfo.document 		= getCustomerDocument(selectedInfo);
		baseInfo.documentType 	= getCustomerDocumentType(selectedInfo);
		baseInfo.type 			= getCustomerType(selectedInfo);
		baseInfo.gender 		= getCustomerGender(selectedInfo);
		baseInfo.birthdate 		= getCustomerBirthdate(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private String getCustomerName(CusInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		return selectedInfo.personData.name;
	}
	
	
	
	private String getCustomerEmail(CusInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		return selectedInfo.personData.email;
	}
	
	
	
	private String getCustomerCode(CusInfo selectedInfo) {
		return selectedInfo.codOwner + "-" + selectedInfo.codCustomer;
	}
	
	
	
	private String getCustomerDocument(CusInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		return selectedInfo.personData.cpf;
	}
	
	
	
	private String getCustomerDocumentType(CusInfo selectedInfo) {
		if (getCustomerDocument(selectedInfo) == null)
			return null;
		
		return "CPF";
	}
	
	
	
	private String getCustomerType(CusInfo selectedInfo) {
		return "individual";
	}
	
	
	
	private String getCustomerGender(CusInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.codGender == 2)
			return "male";
		
		if (selectedInfo.personData.codGender == 3)
			return "female";
		
		return null;
	}
	
	
	
	private String getCustomerBirthdate(CusInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.birthDate == null)
			return null;
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return selectedInfo.personData.birthDate.format(formatter);
	}
}
