package br.com.mind5.business.company.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CompVisiMergeToUpdate extends InfoMergerVisitorTemplate<CompInfo, CompInfo> {
	
	@Override public List<CompInfo> beforeMerge(List<CompInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CompInfo baseInfo, CompInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CompInfo> merge(CompInfo baseInfo, CompInfo selectedInfo) {
		List<CompInfo> results = new ArrayList<>();
		
		baseInfo.codEntityCateg = selectedInfo.codEntityCateg;
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.createdOn = selectedInfo.createdOn;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CompInfo> getUniquifier() {
		return null;
	}
}
