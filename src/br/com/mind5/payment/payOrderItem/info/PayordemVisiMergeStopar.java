package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class PayordemVisiMergeStopar implements InfoMergerVisitorV3<PayordemInfo, StoparInfo> {
	
	@Override public List<PayordemInfo> beforeMerge(List<PayordemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordemInfo baseInfo, StoparInfo selectedInfo) {
		return (baseInfo.codOwner		== selectedInfo.codOwner	&&
				baseInfo.codStore  	 	== selectedInfo.codStore	&&
				baseInfo.codPayPartner  == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, StoparInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		baseInfo.itemReceiver = selectedInfo.idPayPartnerStore; 
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordemInfo> getUniquifier() {
		return null;
	}
}
