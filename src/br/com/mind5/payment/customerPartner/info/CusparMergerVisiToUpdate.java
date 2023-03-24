package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusparMergerVisiToUpdate extends InfoMergerVisitorTemplate<CusparInfo, CusparInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, CusparInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		selectedInfo.username    = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		selectedInfo = setPhone(baseInfo, selectedInfo);
		selectedInfo = setAddress(baseInfo, selectedInfo);
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	private CusparInfo setPhone(CusparInfo baseInfo, CusparInfo selectedInfo) {
		if (baseInfo.codPhone <= 0) 
			return selectedInfo;
			
			selectedInfo.codPhone         = baseInfo.codPhone;
			selectedInfo.codPhoneSnapshot = DefaultValue.number();
		
			return selectedInfo;
	}
	
	
	
	private CusparInfo setAddress(CusparInfo baseInfo, CusparInfo selectedInfo) {
		if (baseInfo.codAddress <= 0) 
			return selectedInfo;
			
			selectedInfo.codAddress         = baseInfo.codAddress;
			selectedInfo.codAddressSnapshot = DefaultValue.number();
		
			return selectedInfo;
	}
}
