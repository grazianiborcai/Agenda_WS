package br.com.mind5.business.orderHistory.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdoryMergerVisiOrdist extends InfoMergerVisitorTemplate<OrdoryInfo, OrdistInfo> {

	@Override public boolean shouldMerge(OrdoryInfo baseInfo, OrdistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	

	@Override public List<OrdoryInfo> merge(OrdoryInfo baseInfo, OrdistInfo selectedInfo) {
		List<OrdoryInfo> results = new ArrayList<>();
		OrdoryInfo result;
		
		result = OrdoryInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
