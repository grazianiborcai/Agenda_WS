package br.com.mind5.business.orderItemList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdemistVisiMergeOrdemarch extends InfoMergerVisitorTemplate<OrdemistInfo, OrdemarchInfo> {

	@Override public boolean shouldMerge(OrdemistInfo baseInfo, OrdemarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrdemistInfo> merge(OrdemistInfo baseInfo, OrdemarchInfo selectedInfo) {
		List<OrdemistInfo> results = new ArrayList<>();
		
		OrdemistInfo result = OrdemistInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
