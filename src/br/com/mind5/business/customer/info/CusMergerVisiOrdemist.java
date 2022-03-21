package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusMergerVisiOrdemist extends InfoMergerVisitorTemplate<CusInfo, OrdemistInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, OrdemistInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner	&&
			    baseInfo.codOrder 		== selectedInfo.codOrder	&&
			    baseInfo.codOrderItem 	== selectedInfo.codOrderItem	);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, OrdemistInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
