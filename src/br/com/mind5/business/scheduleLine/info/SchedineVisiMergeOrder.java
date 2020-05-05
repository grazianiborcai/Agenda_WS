package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedineVisiMergeOrder implements InfoMergerVisitorV3<SchedineInfo, OrderInfo> {
	
	@Override public List<SchedineInfo> beforeMerge(List<SchedineInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedineInfo baseInfo, OrderInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codOrder == selectedInfo.codOrder	);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, OrderInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		for(OrderemInfo eachOrderem : selectedInfo.orderms) {
			SchedineInfo eachResult = SchedineInfo.copyFrom(eachOrderem);
			eachResult.codCustomer = selectedInfo.codCustomer;		
			eachResult.codOrderStatus = selectedInfo.codOrderStatus;
			eachResult.codSchedule = baseInfo.codSchedule;	
			
			results.add(eachResult);
		}		
		
		
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedineInfo> getUniquifier() {
		return null;
	}
}
