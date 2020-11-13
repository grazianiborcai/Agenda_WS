package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class OrdmoipVisiMergePayordem implements InfoMergerVisitor<OrdmoipInfo, PayordemInfo> {
	
	@Override public List<OrdmoipInfo> beforeMerge(List<OrdmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdmoipInfo baseInfo, PayordemInfo selectedInfo) {
		return (baseInfo.codOwner    	 == selectedInfo.codOwner 		&&
				baseInfo.codPayOrder 	 == selectedInfo.codPayOrder	&&
				baseInfo.codPayOrderItem == selectedInfo.codPayOrderItem	);
	}
	
	
	
	@Override public List<OrdmoipInfo> merge(OrdmoipInfo baseInfo, PayordemInfo selectedInfo) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		baseInfo.payordemData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdmoipInfo> getUniquifier() {
		return null;
	}
}
