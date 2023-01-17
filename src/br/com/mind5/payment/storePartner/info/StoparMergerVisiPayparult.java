package br.com.mind5.payment.storePartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;

final class StoparMergerVisiPayparult extends InfoMergerVisitorTemplate<StoparInfo, PayparultInfo> {
	@Override public boolean shouldMerge(StoparInfo baseInfo, PayparultInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<StoparInfo> merge(StoparInfo baseInfo, PayparultInfo selectedInfo) {
		List<StoparInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		
		results.add(baseInfo);
		return results;
	}
}
