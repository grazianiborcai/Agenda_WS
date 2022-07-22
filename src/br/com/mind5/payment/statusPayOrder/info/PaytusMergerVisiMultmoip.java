package br.com.mind5.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PaytusMergerVisiMultmoip extends InfoMergerVisitorTemplate<PaytusInfo, MultmoipInfo> {

	@Override public boolean shouldMerge(PaytusInfo baseInfo, MultmoipInfo selectedInfo) {
		return (baseInfo.idOrderPartner.equals(selectedInfo.idOrderPartner));
	}
	
	
	
	@Override public List<PaytusInfo> merge(PaytusInfo baseInfo, MultmoipInfo selectedInfo) {
		List<PaytusInfo> results = new ArrayList<>();
		
		baseInfo.statusOrderPartner = selectedInfo.statusOrderPartner;	
		baseInfo.idPaymentPartner = selectedInfo.idPaymentPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<PaytusInfo> uniquifyHook(List<PaytusInfo> results) {
		InfoUniquifier<PaytusInfo> uniquifier = new PaytusUniquifier();		
		return uniquifier.uniquify(results);
	}
}
