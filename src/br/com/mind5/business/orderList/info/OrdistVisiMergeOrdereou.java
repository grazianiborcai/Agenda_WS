package br.com.mind5.business.orderList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdistVisiMergeOrdereou extends InfoMergerVisitorTemplate<OrdistInfo, OrdereouInfo> {

	@Override public boolean shouldMerge(OrdistInfo baseInfo, OrdereouInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codOrder == selectedInfo.codOrder);
	}
	
	
	

	@Override public List<OrdistInfo> merge(OrdistInfo baseInfo, OrdereouInfo selectedInfo) {
		List<OrdistInfo> results = new ArrayList<>();
		
		baseInfo.itemCounter = selectedInfo.itemCounter;
		
		results.add(baseInfo);
		return results;
	}
}
