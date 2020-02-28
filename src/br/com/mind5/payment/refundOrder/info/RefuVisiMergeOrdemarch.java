package br.com.mind5.payment.refundOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class RefuVisiMergeOrdemarch implements InfoMergerVisitorV3<RefuInfo, OrdemarchInfo> {
	
	@Override public List<RefuInfo> beforeMerge(List<RefuInfo> baseInfos) {
		for (RefuInfo eachBase : baseInfos) {
			eachBase.ordemarches = new ArrayList<>();
		}
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefuInfo baseInfo, OrdemarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codOrder == selectedInfo.codOrder);
	}
	
	
	
	@Override public List<RefuInfo> merge(RefuInfo baseInfo, OrdemarchInfo selectedInfo) {
		List<RefuInfo> results = new ArrayList<>();
		
		baseInfo.ordemarches.add(selectedInfo); 
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefuInfo> getUniquifier() {
		return null;
	}
}
