package br.com.mind5.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class PaytusMergerVisiPaymoip extends InfoMergerVisitorTemplate<PaytusInfo, PaymoipInfo> {

	@Override public boolean shouldMerge(PaytusInfo baseInfo, PaymoipInfo selectedInfo) {
		return (baseInfo.idOrderPartner.equals(selectedInfo.idOrderPartner));
	}
	
	
	
	@Override public List<PaytusInfo> merge(PaytusInfo baseInfo, PaymoipInfo selectedInfo) {
		List<PaytusInfo> results = new ArrayList<>();
		
		baseInfo.idPaymentPartner     = selectedInfo.idPaymentPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<PaytusInfo> uniquifyHook(List<PaytusInfo> results) {
		InfoUniquifier<PaytusInfo> uniquifier = new PaytusUniquifier();		
		return uniquifier.uniquify(results);
	}
}
