package br.com.mind5.masterData.materialGroupOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoupowMergerVisiOwnelis extends InfoMergerVisitorTemplate<MatoupowInfo, OwnelisInfo> {

	@Override public boolean shouldMerge(MatoupowInfo baseInfo, OwnelisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatoupowInfo> merge(MatoupowInfo baseInfo, OwnelisInfo selectedInfo) {
		List<MatoupowInfo> results = new ArrayList<>();
		
		baseInfo.codBusiness = selectedInfo.codBusiness;
		
		results.add(baseInfo);
		return results;
	}
}
