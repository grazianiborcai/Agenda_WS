package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

final class RefumoipVisiMergePayordemist implements InfoMergerVisitorV3<RefumoipInfo, PayordemistInfo> {
	
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