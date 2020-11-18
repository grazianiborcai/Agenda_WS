package br.com.mind5.payment.ownerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OwnparVisiMergeToSelect extends InfoMergerVisitorTemplate<OwnparInfo, OwnparInfo> {

	@Override public List<OwnparInfo> beforeMerge(List<OwnparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OwnparInfo baseInfo, OwnparInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnparInfo> merge(OwnparInfo baseInfo, OwnparInfo selectedInfo) {
		List<OwnparInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OwnparInfo> getUniquifier() {
		return null;
	}
}
