package br.com.mind5.payment.storePartnerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoparnapVisiMergeToSelect extends InfoMergerVisitorTemplate<StoparnapInfo, StoparnapInfo> {
	
	@Override public List<StoparnapInfo> beforeMerge(List<StoparnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoparnapInfo baseInfo, StoparnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoparnapInfo> merge(StoparnapInfo baseInfo, StoparnapInfo selectedInfo) {
		List<StoparnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoparnapInfo> getUniquifier() {
		return null;
	}
}
