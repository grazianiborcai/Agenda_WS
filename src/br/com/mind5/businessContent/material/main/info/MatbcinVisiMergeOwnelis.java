package br.com.mind5.businessContent.material.main.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatbcinVisiMergeOwnelis implements InfoMergerVisitor<MatbcinInfo, OwnelisInfo> {
	
	@Override public List<MatbcinInfo> beforeMerge(List<MatbcinInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatbcinInfo baseInfo, OwnelisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatbcinInfo> merge(MatbcinInfo baseInfo, OwnelisInfo selectedInfo) {
		List<MatbcinInfo> results = new ArrayList<>();
		
		baseInfo.codBusiness = selectedInfo.codBusiness;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatbcinInfo> getUniquifier() {
		return null;
	}
}
