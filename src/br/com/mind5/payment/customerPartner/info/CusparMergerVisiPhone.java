package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusparMergerVisiPhone extends InfoMergerVisitorTemplate<CusparInfo, PhoneInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, PhoneInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codPhone == selectedInfo.codPhone	);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, PhoneInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.codPhoneSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
