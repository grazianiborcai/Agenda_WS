package br.com.mind5.business.ownerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OwnelisMergerVisiOwnarch extends InfoMergerVisitorTemplate<OwnelisInfo, OwnarchInfo> {

	@Override public boolean shouldMerge(OwnelisInfo baseInfo, OwnarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<OwnelisInfo> merge(OwnelisInfo baseInfo, OwnarchInfo selectedInfo) {
		List<OwnelisInfo> results = new ArrayList<>();
		
		OwnelisInfo result = OwnelisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
