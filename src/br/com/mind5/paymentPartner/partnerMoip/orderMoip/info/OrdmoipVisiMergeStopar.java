package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class OrdmoipVisiMergeStopar extends InfoMergerVisitorTemplate<OrdmoipInfo, StoparInfo> {

	@Override public boolean shouldMerge(OrdmoipInfo baseInfo, StoparInfo selectedInfo) {
		return (baseInfo.codOwner					== selectedInfo.codOwner	&&
				baseInfo.payordemData.codStore  	== selectedInfo.codStore	&&
				baseInfo.cusparData.codPayPartner  	== selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<OrdmoipInfo> merge(OrdmoipInfo baseInfo, StoparInfo selectedInfo) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		baseInfo.stoparData = selectedInfo; 
		
		results.add(baseInfo);
		return results;
	}
}
