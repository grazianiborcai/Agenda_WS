package br.com.mind5.business.storeCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class StogueVisiMergeMatoup implements InfoMergerVisitor<StogueInfo, MatoupInfo> {
	
	@Override public List<StogueInfo> beforeMerge(List<StogueInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StogueInfo baseInfo, MatoupInfo selectedInfo) {
		return (baseInfo.codBusiness == selectedInfo.codBusiness);
	}
	
	
	
	@Override public List<StogueInfo> merge(StogueInfo baseInfo, MatoupInfo selectedInfo) {
		List<StogueInfo> results = new ArrayList<>();
		
		baseInfo.matoups.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StogueInfo> getUniquifier() {
		return null;
	}
}
