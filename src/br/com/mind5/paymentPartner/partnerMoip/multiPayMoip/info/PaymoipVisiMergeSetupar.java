package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class PaymoipVisiMergeSetupar implements InfoMergerVisitor<PaymoipInfo, SetuparInfo> {
	
	@Override public List<PaymoipInfo> beforeMerge(List<PaymoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PaymoipInfo baseInfo, SetuparInfo selectedInfo) {
		return baseInfo.codPayPartner == selectedInfo.codPayPartner;
	}
	
	
	
	@Override public List<PaymoipInfo> merge(PaymoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PaymoipInfo> getUniquifier() {
		return null;
	}
}
