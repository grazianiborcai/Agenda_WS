package br.com.mind5.business.orderSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrdnapVisiMergeToSelect implements InfoMergerVisitorV3<OrdnapInfo, OrdnapInfo> {
	
	@Override public List<OrdnapInfo> beforeMerge(List<OrdnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdnapInfo baseInfo, OrdnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrdnapInfo> merge(OrdnapInfo baseInfo, OrdnapInfo selectedInfo) {
		List<OrdnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdnapInfo> getUniquifier() {
		return null;
	}
}
