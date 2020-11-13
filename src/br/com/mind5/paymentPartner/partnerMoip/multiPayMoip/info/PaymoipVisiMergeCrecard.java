package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PaymoipVisiMergeCrecard implements InfoMergerVisitor<PaymoipInfo, CrecardInfo> {
	
	@Override public List<PaymoipInfo> beforeMerge(List<PaymoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PaymoipInfo baseInfo, CrecardInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner 		||
				baseInfo.codCreditCard 	== selectedInfo.codCreditCard		);
	}
	
	
	
	@Override public List<PaymoipInfo> merge(PaymoipInfo baseInfo, CrecardInfo selectedInfo) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		baseInfo.crecardData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PaymoipInfo> getUniquifier() {
		return null;
	}
}
