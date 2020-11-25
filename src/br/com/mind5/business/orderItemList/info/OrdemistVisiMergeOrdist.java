package br.com.mind5.business.orderItemList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdemistVisiMergeOrdist extends InfoMergerVisitorTemplate<OrdemistInfo, OrdistInfo> {

	@Override public boolean shouldMerge(OrdemistInfo baseInfo, OrdistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codOrder == selectedInfo.codOrder);
	}
	
	
	
	@Override public List<OrdemistInfo> merge(OrdemistInfo baseInfo, OrdistInfo selectedInfo) {
		List<OrdemistInfo> results = new ArrayList<>();
		
		baseInfo.codUser = baseInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
