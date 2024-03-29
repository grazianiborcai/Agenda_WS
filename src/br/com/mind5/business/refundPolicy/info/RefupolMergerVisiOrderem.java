package br.com.mind5.business.refundPolicy.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class RefupolMergerVisiOrderem extends InfoMergerVisitorTemplate<RefupolInfo, OrderemInfo> {

	@Override public boolean shouldMerge(RefupolInfo baseInfo, OrderemInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner &&
				baseInfo.codOrder 		== selectedInfo.codOrder &&
				baseInfo.codOrderItem 	== selectedInfo.codOrderItem);
	}
	
	
	
	@Override public List<RefupolInfo> merge(RefupolInfo baseInfo, OrderemInfo selectedInfo) {
		List<RefupolInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		baseInfo.codMat = selectedInfo.codMat;
		baseInfo.date = selectedInfo.date;
		baseInfo.beginTime = selectedInfo.beginTime;
		baseInfo.endTime = selectedInfo.endTime;
		
		results.add(baseInfo);
		return results;
	}
}
