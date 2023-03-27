package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class CustopaMergerVisiCuspar extends InfoMergerVisitorTemplate<CustopaInfo, CusparInfo> {

	@Override public boolean shouldMerge(CustopaInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner       == selectedInfo.codOwner &&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer);
	}
	
	
	
	@Override public List<CustopaInfo> merge(CustopaInfo baseInfo, CusparInfo selectedInfo) {
		List<CustopaInfo> results = new ArrayList<>();
		
		baseInfo.codUser     	= selectedInfo.codUser;
		baseInfo.codCustomer    = selectedInfo.codCustomer;
		baseInfo.homePhone     	= getHomePhone(selectedInfo);
		baseInfo.mobilePhone    = getMobilePhone(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private Map<String,String> getHomePhone(CusparInfo selectedInfo) {
		Map<String,String> phone = new HashMap<>();
		
		if (hasPhone(selectedInfo) == false)
			return phone;
		
		if (isMobile(selectedInfo.phonapData.number) == true)
			return phone;		
		
		phone = getPhone(selectedInfo);
		return phone;
	}
	
	
	
	private Map<String,String> getMobilePhone(CusparInfo selectedInfo) {
		Map<String,String> phone = new HashMap<>();
		
		if (hasPhone(selectedInfo) == false)
			return phone;
		
		if (isMobile(selectedInfo.phonapData.number) == false)
			return phone;		
		
		phone = getPhone(selectedInfo);
		return phone;
	}
	
	
	
	private Map<String,String> getPhone(CusparInfo selectedInfo) {
		Map<String,String> phone = new HashMap<>();
		
		if (hasPhone(selectedInfo) == false)
			return phone;
		
		phone.put("country_code", String.valueOf(selectedInfo.phonapData.codCountryPhone));
		phone.put("area_code"   , selectedInfo.phonapData.codArea);
		phone.put("number"      , selectedInfo.phonapData.number);
		
		return phone;
	}
	
	
	
	private boolean hasPhone(CusparInfo selectedInfo) {
		if (selectedInfo.phonapData == null)
			return false;
		
		if (selectedInfo.phonapData.number == null)
			return false;
		
		return true;
	}
	
	
	
	private boolean isMobile(String number) {
		int firstDigit = Integer.parseInt(number.substring(0, 1));
		
		if (firstDigit >= 6)
			return true;
					
		return false;
	}
}
