package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class CremoipVisiMergeSetupar extends InfoMergerVisitorTemplate<CremoipInfo, SetuparInfo> {

	@Override public boolean shouldMerge(CremoipInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<CremoipInfo> merge(CremoipInfo baseInfo, SetuparInfo selectedInfo) {
		List<CremoipInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
