package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

final class RefumoipVisiMergePayordemist implements InfoMergerVisitor<RefumoipInfo, PayordemistInfo> {
	
	@Override public List<RefumoipInfo> beforeMerge(List<RefumoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefumoipInfo baseInfo, PayordemistInfo selectedInfo) {
		return (baseInfo.codOwner 		 == selectedInfo.codOwner 	 &&
				baseInfo.codPayOrder 	 == selectedInfo.codPayOrder &&
				baseInfo.codPayOrderItem == selectedInfo.codPayOrderItem);
	}
	
	
	
	@Override public List<RefumoipInfo> merge(RefumoipInfo baseInfo, PayordemistInfo selectedInfo) {
		List<RefumoipInfo> results = new ArrayList<>();
		
		baseInfo.itemReceiver = selectedInfo.itemReceiver;
		baseInfo.idOrderPartner = selectedInfo.idOrderPartner;
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefumoipInfo> getUniquifier() {
		return null;
	}
}
