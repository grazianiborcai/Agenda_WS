package br.com.mind5.business.storeCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class StogueMergerVisiMatoup extends InfoMergerVisitorTemplate<StogueInfo, MatoupInfo> {

	@Override public boolean shouldMerge(StogueInfo baseInfo, MatoupInfo selectedInfo) {
		return (baseInfo.codBusiness == selectedInfo.codBusiness);
	}
	
	
	
	@Override public List<StogueInfo> merge(StogueInfo baseInfo, MatoupInfo selectedInfo) {
		List<StogueInfo> results = new ArrayList<>();
		
		baseInfo.matoups.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
