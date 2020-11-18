package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorapVisiMergePhonap extends InfoMergerVisitorTemplate<StorapInfo, PhonapInfo> {
	
	
	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorapInfo baseInfo, PhonapInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner	&&
				baseInfo.codStore 	 == selectedInfo.codStore	&&
				baseInfo.codSnapshot == selectedInfo.codStoreSnapshot	);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, PhonapInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.phones.add(PhoneInfo.copyFrom(selectedInfo));
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
