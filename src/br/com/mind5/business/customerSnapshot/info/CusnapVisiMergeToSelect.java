package br.com.mind5.business.customerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CusnapVisiMergeToSelect implements InfoMergerVisitorV3<CusnapInfo, CusnapInfo> {
	
	@Override public List<CusnapInfo> beforeMerge(List<CusnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusnapInfo baseInfo, CusnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusnapInfo> merge(CusnapInfo baseInfo, CusnapInfo selectedInfo) {
		List<CusnapInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusnapInfo> getUniquifier() {
		return null;
	}
}
