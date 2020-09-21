package br.com.mind5.business.storeText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;


final class StorextVisiMergeMatextault implements InfoMergerVisitorV3<StorextInfo, MatextaultInfo> {
	
	@Override public List<StorextInfo> beforeMerge(List<StorextInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorextInfo baseInfo, MatextaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StorextInfo> merge(StorextInfo baseInfo, MatextaultInfo selectedInfo) {
		List<StorextInfo> results = new ArrayList<>();
		
		StorextInfo result = StorextInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorextInfo> getUniquifier() {
		return null;
	}
}
