package br.com.mind5.business.orderListAuth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OrdistauVisiMergeOrdist implements InfoMergerVisitorV3<OrdistauInfo, OrdistInfo> {

	@Override public List<OrdistauInfo> beforeMerge(List<OrdistauInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdistauInfo baseInfo, OrdistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	

	@Override public List<OrdistauInfo> merge(OrdistauInfo baseInfo, OrdistInfo selectedInfo) {
		List<OrdistauInfo> results = new ArrayList<>();
		OrdistauInfo result;
		
		result = OrdistauInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdistauInfo> getUniquifier() {
		return null;
	}
}
