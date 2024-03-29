package br.com.mind5.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

final class RefemMergerVisiRefumoip extends InfoMergerVisitorTemplate<RefemInfo, RefumoipInfo> {

	@Override public boolean shouldMerge(RefemInfo baseInfo, RefumoipInfo selectedInfo) {
		return (baseInfo.idOrderPartner.equals(selectedInfo.idOrderPartner));
	}
	
	
	
	@Override public List<RefemInfo> merge(RefemInfo baseInfo, RefumoipInfo selectedInfo) {
		List<RefemInfo> results = new ArrayList<>();
		
		baseInfo.idRefundPartner     = selectedInfo.idRefundPartner;
		baseInfo.statusRefundPartner = selectedInfo.statusRefundPartner;
		
		results.add(baseInfo);
		return results;
	}
}
