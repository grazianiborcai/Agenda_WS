package br.com.mind5.business.owner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OwnerVisiMergeComp implements InfoMergerVisitorV3<OwnerInfo, CompInfo> {
	
	@Override public List<OwnerInfo> beforeMerge(List<OwnerInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OwnerInfo baseInfo, CompInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OwnerInfo> merge(OwnerInfo baseInfo, CompInfo selectedInfo) {
		List<OwnerInfo> results = new ArrayList<>();
		
		baseInfo.codCompany = selectedInfo.codCompany;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OwnerInfo> getUniquifier() {
		return new OwnerUniquifier();
	}
}
