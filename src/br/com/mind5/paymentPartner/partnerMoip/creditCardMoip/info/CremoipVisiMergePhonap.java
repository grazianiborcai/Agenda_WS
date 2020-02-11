package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CremoipVisiMergePhonap implements InfoMergerVisitorV3<CremoipInfo, PhonapInfo> {
	
	@Override public List<CremoipInfo> beforeMerge(List<CremoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<CremoipInfo> getUniquifier() {
		return null;
	}
}
