package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusVisiMergeOrdemarch extends InfoMergerVisitorTemplate<CusInfo, OrdemarchInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, OrdemarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
			    baseInfo.codOrder == selectedInfo.codOrder		);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, OrdemarchInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
