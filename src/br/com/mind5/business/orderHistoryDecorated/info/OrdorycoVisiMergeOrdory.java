package br.com.mind5.business.orderHistoryDecorated.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdorycoVisiMergeOrdory extends InfoMergerVisitorTemplate<OrdorycoInfo, OrdoryInfo> {

	@Override public boolean shouldMerge(OrdorycoInfo baseInfo, OrdoryInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	
	

	@Override public List<OrdorycoInfo> merge(OrdorycoInfo baseInfo, OrdoryInfo selectedInfo) {
		List<OrdorycoInfo> results = new ArrayList<>();
		
		baseInfo.ordorys.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
