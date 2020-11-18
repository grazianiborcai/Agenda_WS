package br.com.mind5.business.materialStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class MatoreVisiMergeToSelect extends InfoMergerVisitorTemplate<MatoreInfo, MatoreInfo> {
	
	@Override public List<MatoreInfo> beforeMerge(List<MatoreInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatoreInfo baseInfo, MatoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatoreInfo> merge(MatoreInfo baseInfo, MatoreInfo selectedInfo) {
		List<MatoreInfo> results = new ArrayList<>();
		
		selectedInfo.codGroup = baseInfo.codGroup;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatoreInfo> getUniquifier() {
		return null;
	}
}
