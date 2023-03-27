package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusparMergerVisiPhonap extends InfoMergerVisitorTemplate<CusparInfo, PhonapInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, PhonapInfo selectedInfo) {
		return (baseInfo.codOwner         == selectedInfo.codOwner &&
				baseInfo.codPhone         == selectedInfo.codPhone &&
				baseInfo.codPhoneSnapshot == selectedInfo.codSnapshot);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, PhonapInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.phonapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
