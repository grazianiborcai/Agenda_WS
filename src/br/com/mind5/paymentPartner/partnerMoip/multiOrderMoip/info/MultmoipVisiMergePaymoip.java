package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class MultmoipVisiMergePaymoip implements InfoMergerVisitorV3<MultmoipInfo, PaymoipInfo> {
	
	@Override public List<MultmoipInfo> beforeMerge(List<MultmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MultmoipInfo baseInfo, PaymoipInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MultmoipInfo> merge(MultmoipInfo baseInfo, PaymoipInfo selectedInfo) {
		List<MultmoipInfo> results = new ArrayList<>();
		
		baseInfo.idPaymentPartner = selectedInfo.idPaymentPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MultmoipInfo> getUniquifier() {
		return new MultmoipUniquifier();
	}
}
