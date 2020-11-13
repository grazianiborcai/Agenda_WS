package br.com.mind5.business.materialMovement.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatmovVisiMergeToSelect implements InfoMergerVisitor<MatmovInfo, MatmovInfo> {

	@Override public List<MatmovInfo> beforeMerge(List<MatmovInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatmovInfo baseInfo, MatmovInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatmovInfo> merge(MatmovInfo baseInfo, MatmovInfo selectedInfo) {
		List<MatmovInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatmovInfo> getUniquifier() {
		return null;
	}
}
