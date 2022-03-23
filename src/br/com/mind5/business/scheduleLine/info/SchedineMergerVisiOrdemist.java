package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedineMergerVisiOrdemist extends InfoMergerVisitorTemplate<SchedineInfo, OrdemistInfo> {

	@Override public boolean shouldMerge(SchedineInfo baseInfo, OrdemistInfo selectedInfo) {
		return (baseInfo.codOwner 	  == selectedInfo.codOwner &&
				baseInfo.codOrder 	  == selectedInfo.codOrder &&
				baseInfo.codOrderItem == selectedInfo.codOrderItem);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, OrdemistInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.codOrderStatus = selectedInfo.codOrderStatus;
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
