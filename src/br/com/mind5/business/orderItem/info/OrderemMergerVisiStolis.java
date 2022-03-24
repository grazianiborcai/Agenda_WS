package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderemMergerVisiStolis extends InfoMergerVisitorTemplate<OrderemInfo, StolisInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, StolisInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.stolisData = selectedInfo;
		baseInfo.codCurr = selectedInfo.codCurr;
		baseInfo.txtCurr = selectedInfo.txtCurr;
		
		results.add(baseInfo);
		return results;
	}
}
