package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CusmoipVisiMergePhonap implements InfoMergerVisitorV3<CusmoipInfo, PhonapInfo> {
	
	@Override public List<CusmoipInfo> beforeMerge(List<CusmoipInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusmoipInfo baseInfo, PhonapInfo selectedInfo) {
		return (baseInfo.codOwner 			== selectedInfo.codOwner	&&
				baseInfo.codPhoneSnapshot	== selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<CusmoipInfo> merge(CusmoipInfo baseInfo, PhonapInfo selectedInfo) {
		List<CusmoipInfo> results = new ArrayList<>();
		
		baseInfo.phonapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusmoipInfo> getUniquifier() {
		return null;
	}
}
