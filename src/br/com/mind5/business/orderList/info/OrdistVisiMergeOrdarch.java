package br.com.mind5.business.orderList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OrdistVisiMergeOrdarch extends InfoMergerVisitorTemplate<OrdistInfo, OrdarchInfo> {

	@Override public List<OrdistInfo> beforeMerge(List<OrdistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrdistInfo baseInfo, OrdarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	

	@Override public List<OrdistInfo> merge(OrdistInfo baseInfo, OrdarchInfo selectedInfo) {
		List<OrdistInfo> results = new ArrayList<>();
		OrdistInfo result;
		
		result = OrdistInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrdistInfo> getUniquifier() {
		return null;
	}
}
