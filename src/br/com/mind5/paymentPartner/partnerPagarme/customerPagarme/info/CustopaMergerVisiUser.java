package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class CustopaMergerVisiUser extends InfoMergerVisitorTemplate<CustopaInfo, UserInfo> {

	@Override public boolean shouldMerge(CustopaInfo baseInfo, UserInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	
	
	@Override public List<CustopaInfo> merge(CustopaInfo baseInfo, UserInfo selectedInfo) {
		List<CustopaInfo> results = new ArrayList<>();
		
		baseInfo.name     		= getUserName(selectedInfo);
		baseInfo.email    		= getUserEmail(selectedInfo);
		baseInfo.document 		= getUserDocument(selectedInfo);
		baseInfo.documentType 	= getUserDocumentType(selectedInfo);
		baseInfo.type 			= getUserType(selectedInfo);
		baseInfo.gender 		= getUserGender(selectedInfo);
		baseInfo.birthdate 		= getUserBirthdate(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private String getUserName(UserInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.name == null)
			return null;
		
		return selectedInfo.personData.name;
	}
	
	
	
	private String getUserEmail(UserInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.email == null)
			return null;
		
		return selectedInfo.personData.email;
	}
	
	
	
	private String getUserDocument(UserInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.cpf == null)
			return null;
		
		return selectedInfo.personData.cpf;
	}
	
	
	
	private String getUserDocumentType(UserInfo selectedInfo) {
		if (getUserDocument(selectedInfo) == null)
			return null;
		
		return "CPF";
	}
	
	
	
	private String getUserType(UserInfo selectedInfo) {
		return "individual";
	}
	
	
	
	private String getUserGender(UserInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.codGender == 2)
			return "male";
		
		if (selectedInfo.personData.codGender == 3)
			return "female";
		
		return null;
	}
	
	
	
	private String getUserBirthdate(UserInfo selectedInfo) {
		if (selectedInfo.personData == null)
			return null;
		
		if (selectedInfo.personData.birthDate == null)
			return null;
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return selectedInfo.personData.birthDate.format(formatter);
	}
}
