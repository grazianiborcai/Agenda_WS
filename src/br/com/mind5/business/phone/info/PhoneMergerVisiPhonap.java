package br.com.mind5.business.phone.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhoneMergerVisiPhonap extends InfoMergerVisitorTemplate<PhoneInfo, PhonapInfo> {

	@Override public boolean shouldMerge(PhoneInfo baseInfo, PhonapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codPhone == selectedInfo.codPhone		);
	}
	
	
	
	@Override public List<PhoneInfo> merge(PhoneInfo baseInfo, PhonapInfo selectedInfo) {
		List<PhoneInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
