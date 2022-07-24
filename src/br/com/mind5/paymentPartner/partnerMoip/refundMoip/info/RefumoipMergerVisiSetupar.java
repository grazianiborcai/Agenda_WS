package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class RefumoipMergerVisiSetupar extends InfoMergerVisitorTemplate<RefumoipInfo, SetuparInfo> {

	@Override public boolean shouldMerge(RefumoipInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<RefumoipInfo> merge(RefumoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<RefumoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
