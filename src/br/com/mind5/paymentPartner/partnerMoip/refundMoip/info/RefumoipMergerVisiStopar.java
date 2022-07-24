package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class RefumoipMergerVisiStopar extends InfoMergerVisitorTemplate<RefumoipInfo, StoparInfo> {

	@Override public boolean shouldMerge(RefumoipInfo baseInfo, StoparInfo selectedInfo) {
		return (baseInfo.codOwner 	   == selectedInfo.codOwner	&&
				baseInfo.codStore 	   == selectedInfo.codStore	&&
				baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<RefumoipInfo> merge(RefumoipInfo baseInfo, StoparInfo selectedInfo) {
		List<RefumoipInfo> results = new ArrayList<>();
		
		baseInfo.stoparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
