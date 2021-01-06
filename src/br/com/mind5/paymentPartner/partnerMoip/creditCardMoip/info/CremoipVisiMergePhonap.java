package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CremoipVisiMergePhonap extends InfoMergerVisitorTemplate<CremoipInfo, PhonapInfo> {

	@Override public boolean shouldMerge(CremoipInfo baseInfo, PhonapInfo selectedInfo) {
		return (baseInfo.codOwner 			== selectedInfo.codOwner	&&
				baseInfo.codPhoneSnapshot	== selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<CremoipInfo> merge(CremoipInfo baseInfo, PhonapInfo selectedInfo) {
		List<CremoipInfo> results = new ArrayList<>();
		
		baseInfo.phonapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
