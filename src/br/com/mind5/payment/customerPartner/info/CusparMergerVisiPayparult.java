package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;

final class CusparMergerVisiPayparult extends InfoMergerVisitorTemplate<CusparInfo, PayparultInfo> {
	@Override public boolean shouldMerge(CusparInfo baseInfo, PayparultInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, PayparultInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		
		results.add(baseInfo);
		return results;
	}
}
