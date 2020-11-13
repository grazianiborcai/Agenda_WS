package br.com.mind5.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class PaytusVisiMergePaymoip implements InfoMergerVisitor<PaytusInfo, PaymoipInfo> {
	
	@Override public List<PaytusInfo> beforeMerge(List<PaytusInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PaytusInfo baseInfo, PaymoipInfo selectedInfo) {
		return (baseInfo.idOrderPartner.equals(selectedInfo.idOrderPartner));
	}
	
	
	
	@Override public List<PaytusInfo> merge(PaytusInfo baseInfo, PaymoipInfo selectedInfo) {
		List<PaytusInfo> results = new ArrayList<>();
		
		baseInfo.idPaymentPartner = selectedInfo.idPaymentPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PaytusInfo> getUniquifier() {
		return new PaytusUniquifier();
	}
}
