package br.com.mind5.payment.refundOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class RefuMergerVisiOrdist extends InfoMergerVisitorTemplate<RefuInfo, OrdistInfo> {

	@Override public boolean shouldMerge(RefuInfo baseInfo, OrdistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codOrder == selectedInfo.codOrder		);
	}
	
	
	
	@Override public List<RefuInfo> merge(RefuInfo baseInfo, OrdistInfo selectedInfo) {
		List<RefuInfo> results = new ArrayList<>();
		
		baseInfo.codPayOrder = selectedInfo.codPayOrder; 
		
		results.add(baseInfo);
		return results;
	}
}
