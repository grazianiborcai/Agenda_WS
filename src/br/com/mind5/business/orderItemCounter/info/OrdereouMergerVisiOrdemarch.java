package br.com.mind5.business.orderItemCounter.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdereouMergerVisiOrdemarch extends InfoMergerVisitorTemplate<OrdereouInfo, OrdemarchInfo> {

	@Override public boolean shouldMerge(OrdereouInfo baseInfo, OrdemarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.codOrder == selectedInfo.codOrder		);
	}
	
	
	
	@Override public List<OrdereouInfo> merge(OrdereouInfo baseInfo, OrdemarchInfo selectedInfo) {
		List<OrdereouInfo> results = new ArrayList<>();
		
		baseInfo.ordemarches.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
