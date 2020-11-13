package br.com.mind5.business.ownerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnelisVisiMergeOwnarch implements InfoMergerVisitor<OwnelisInfo, OwnarchInfo> {
	
	@Override public List<OwnelisInfo> beforeMerge(List<OwnelisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OwnelisInfo baseInfo, OwnarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<OwnelisInfo> merge(OwnelisInfo baseInfo, OwnarchInfo selectedInfo) {
		List<OwnelisInfo> results = new ArrayList<>();
		
		OwnelisInfo result = OwnelisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OwnelisInfo> getUniquifier() {
		return null;
	}
}
