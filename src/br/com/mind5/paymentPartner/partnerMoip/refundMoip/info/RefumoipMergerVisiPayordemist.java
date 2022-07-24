package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

final class RefumoipMergerVisiPayordemist extends InfoMergerVisitorTemplate<RefumoipInfo, PayordemistInfo> {

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
}
