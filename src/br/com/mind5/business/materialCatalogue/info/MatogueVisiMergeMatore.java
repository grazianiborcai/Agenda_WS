package br.com.mind5.business.materialCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatogueVisiMergeMatore implements InfoMergerVisitor<MatogueInfo, MatoreInfo> {
	
	@Override public List<MatogueInfo> beforeMerge(List<MatogueInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<MatogueInfo> getUniquifier() {
		return null;
	}
}
