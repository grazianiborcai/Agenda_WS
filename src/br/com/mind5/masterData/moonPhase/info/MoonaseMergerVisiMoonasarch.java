package br.com.mind5.masterData.moonPhase.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;

final class MoonaseMergerVisiMoonasarch extends InfoMergerVisitorTemplate<MoonaseInfo, MoonasarchInfo> {

	@Override public boolean shouldMerge(MoonaseInfo baseInfo, MoonasarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MoonaseInfo> merge(MoonaseInfo baseInfo, MoonasarchInfo selectedInfo) {
		List<MoonaseInfo> results = new ArrayList<>();
		
		MoonaseInfo result = MoonaseInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
