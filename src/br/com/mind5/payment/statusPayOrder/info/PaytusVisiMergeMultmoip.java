package br.com.mind5.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PaytusVisiMergeMultmoip implements InfoMergerVisitor<PaytusInfo, MultmoipInfo> {
	
	@Override public List<PaytusInfo> beforeMerge(List<PaytusInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<PaytusInfo> getUniquifier() {
		return new PaytusUniquifier();
	}
}
