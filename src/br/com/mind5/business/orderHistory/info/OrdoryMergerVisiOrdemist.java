package br.com.mind5.business.orderHistory.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdoryMergerVisiOrdemist extends InfoMergerVisitorTemplate<OrdoryInfo, OrdemistInfo> {

	@Override public boolean shouldMerge(OrdoryInfo baseInfo, OrdemistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codOrder == selectedInfo.codOrder);
	}
	
	
	

	@Override public List<OrdoryInfo> merge(OrdoryInfo baseInfo, OrdemistInfo selectedInfo) {
		List<OrdoryInfo> results = new ArrayList<>();
		
		baseInfo.ordemists.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
