package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

final class CrecardVisiMergeCremoip extends InfoMergerVisitorTemplate<CrecardInfo, CremoipInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, CremoipInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, CremoipInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.creditCardId = selectedInfo.creditCardId;
		baseInfo.creditCardBrand = selectedInfo.creditCardBrand;
		baseInfo.creditCardLast4 = selectedInfo.creditCardLast4;
		
		results.add(baseInfo);
		return results;
	}
}
