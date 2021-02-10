package br.com.mind5.business.orderItemCounter.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdereouVisiMergeOrdemist extends InfoMergerVisitorTemplate<OrdereouInfo, OrdemistInfo> {

	@Override public boolean shouldMerge(OrdereouInfo baseInfo, OrdemistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.codOrder == selectedInfo.codOrder		);
	}
	
	
	
	@Override public List<OrdereouInfo> merge(OrdereouInfo baseInfo, OrdemistInfo selectedInfo) {
		List<OrdereouInfo> results = new ArrayList<>();
		
		baseInfo.ordemists.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
