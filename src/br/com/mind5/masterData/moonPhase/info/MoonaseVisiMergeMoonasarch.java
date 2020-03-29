package br.com.mind5.masterData.moonPhase.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;

final class MoonaseVisiMergeMoonasarch implements InfoMergerVisitorV3<MoonaseInfo, MoonasarchInfo> {
	
	@Override public List<MoonaseInfo> beforeMerge(List<MoonaseInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MoonaseInfo baseInfo, MoonasarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MoonaseInfo> merge(MoonaseInfo baseInfo, MoonasarchInfo selectedInfo) {
		List<MoonaseInfo> results = new ArrayList<>();
		
		MoonaseInfo result = MoonaseInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MoonaseInfo> getUniquifier() {
		return null;
	}
}
