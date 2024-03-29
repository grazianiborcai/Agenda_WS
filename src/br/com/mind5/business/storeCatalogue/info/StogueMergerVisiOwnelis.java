package br.com.mind5.business.storeCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StogueMergerVisiOwnelis extends InfoMergerVisitorTemplate<StogueInfo, OwnelisInfo> {

	@Override public boolean shouldMerge(StogueInfo baseInfo, OwnelisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StogueInfo> merge(StogueInfo baseInfo, OwnelisInfo selectedInfo) {
		List<StogueInfo> results = new ArrayList<>();
		
		baseInfo.codBusiness = selectedInfo.codBusiness;
		baseInfo.txtBusiness = selectedInfo.txtBusiness;
		
		results.add(baseInfo);
		return results;
	}
}
