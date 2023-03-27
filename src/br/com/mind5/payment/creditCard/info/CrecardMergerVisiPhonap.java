package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CrecardMergerVisiPhonap extends InfoMergerVisitorTemplate<CrecardInfo, PhonapInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, PhonapInfo selectedInfo) {
		return (baseInfo.codOwner         	    == selectedInfo.codOwner &&
				baseInfo.codPhoneHolder         == selectedInfo.codPhone &&
				baseInfo.codPhoneSnapshotHolder == selectedInfo.codSnapshot);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, PhonapInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.phonapData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
