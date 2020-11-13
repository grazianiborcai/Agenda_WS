package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class OrdmoipVisiMergeStopar implements InfoMergerVisitor<OrdmoipInfo, StoparInfo> {
	
	@Override public List<OrdmoipInfo> beforeMerge(List<OrdmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OrdmoipInfo> getUniquifier() {
		return null;
	}
}
