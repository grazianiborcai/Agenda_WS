package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusparMergerVisiPhonault extends InfoMergerVisitorTemplate<CusparInfo, PhonaultInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, PhonaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser == selectedInfo.codUser	);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, PhonaultInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.codPhone         = selectedInfo.codPhone;
		baseInfo.codPhoneSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
