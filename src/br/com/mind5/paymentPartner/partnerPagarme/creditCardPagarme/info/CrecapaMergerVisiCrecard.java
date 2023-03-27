package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class CrecapaMergerVisiCrecard extends InfoMergerVisitorTemplate<CrecapaInfo, CrecardInfo> {

	@Override public boolean shouldMerge(CrecapaInfo baseInfo, CrecardInfo selectedInfo) {
		return (baseInfo.codOwner      == selectedInfo.codOwner &&
				baseInfo.codCreditCard == selectedInfo.codCreditCard);
	}
	
	
	
	@Override public List<CrecapaInfo> merge(CrecapaInfo baseInfo, CrecardInfo selectedInfo) {
		List<CrecapaInfo> results = new ArrayList<>();
		
		baseInfo.billingAddress = getAddress(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private Map<String,String> getAddress(CrecardInfo selectedInfo) {
		Map<String,String> address = new HashMap<>();
		
		if (hasAddress(selectedInfo) == false)
			return address;	
		
		address.put("country" , selectedInfo.addresnapData.codCountry);
		address.put("state"   , selectedInfo.addresnapData.codState);
		address.put("city"    , selectedInfo.addresnapData.city);
		address.put("zip_code", selectedInfo.addresnapData.postalCode);
		address.put("line_1"  , getAddressLine1(selectedInfo));
		address.put("line_2"  , getAddressLine2(selectedInfo));
		
		return address;
	}
	
	
	
	private String getAddressLine1(CrecardInfo selectedInfo) {
		return selectedInfo.addresnapData.streetNumber + ',' + 
			   selectedInfo.addresnapData.street       + ',' +
			   selectedInfo.addresnapData.district;
	}
	
	
	
	private String getAddressLine2(CrecardInfo selectedInfo) {
		String complement = selectedInfo.addresnapData.complement;
		
		if (complement == null) complement = "";
		
		return complement;
	}
	
	
	
	private boolean hasAddress(CrecardInfo selectedInfo) {
		if (selectedInfo.addresnapData == null)
			return false;
		
		return true;
	}
}
