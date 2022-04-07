package br.com.mind5.business.materialCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatogueMergerVisiMatore extends InfoMergerVisitorTemplate<MatogueInfo, MatoreInfo> {

	@Override public boolean shouldMerge(MatogueInfo baseInfo, MatoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<MatogueInfo> merge(MatogueInfo baseInfo, MatoreInfo selectedInfo) {
		List<MatogueInfo> results = new ArrayList<>();
		
		baseInfo.matores.add(selectedInfo);
		baseInfo.stolisData = selectedInfo.stolisData;
		
		results.add(baseInfo);
		return results;
	}
}
