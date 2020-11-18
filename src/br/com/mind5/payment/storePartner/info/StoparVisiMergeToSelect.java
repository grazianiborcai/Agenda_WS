package br.com.mind5.payment.storePartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoparVisiMergeToSelect extends InfoMergerVisitorTemplate<StoparInfo, StoparInfo> {
	
	@Override public List<StoparInfo> beforeMerge(List<StoparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoparInfo baseInfo, StoparInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoparInfo> merge(StoparInfo baseInfo, StoparInfo selectedInfo) {
		List<StoparInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoparInfo> getUniquifier() {
		return null;
	}
}
