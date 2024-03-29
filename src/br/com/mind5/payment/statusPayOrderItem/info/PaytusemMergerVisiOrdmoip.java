package br.com.mind5.payment.statusPayOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class PaytusemMergerVisiOrdmoip extends InfoMergerVisitorTemplate<PaytusemInfo, OrdmoipInfo> {

	@Override public boolean shouldMerge(PaytusemInfo baseInfo, OrdmoipInfo selectedInfo) {
		return (baseInfo.idOrderPartner.equals(selectedInfo.idOrderPartner));
	}
	
	
	
	@Override public List<PaytusemInfo> merge(PaytusemInfo baseInfo, OrdmoipInfo selectedInfo) {
		List<PaytusemInfo> results = new ArrayList<>();
		
		baseInfo.statusOrderPartner = selectedInfo.statusOrderPartner;	
		baseInfo.idPaymentPartner = selectedInfo.idPaymentPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		baseInfo.idRefundPartner = selectedInfo.idRefundPartner;
		baseInfo.statusRefundPartner = selectedInfo.statusRefundPartner;
		
		results.add(baseInfo);
		return results;
	}
}
