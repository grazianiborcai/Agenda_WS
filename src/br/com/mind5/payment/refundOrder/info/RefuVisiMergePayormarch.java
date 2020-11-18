package br.com.mind5.payment.refundOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

final class RefuVisiMergePayormarch extends InfoMergerVisitorTemplate<RefuInfo, PayormarchInfo> {
	
	@Override public List<RefuInfo> beforeMerge(List<RefuInfo> baseInfos) {
		for (RefuInfo eachBase : baseInfos) {
			eachBase.payormarches = new ArrayList<>();
		}
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefuInfo baseInfo, PayormarchInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner	&&
				baseInfo.codPayOrder == selectedInfo.codPayOrder);
	}
	
	
	
	@Override public List<RefuInfo> merge(RefuInfo baseInfo, PayormarchInfo selectedInfo) {
		List<RefuInfo> results = new ArrayList<>();
		
		baseInfo.payormarches.add(selectedInfo); 
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefuInfo> getUniquifier() {
		return null;
	}
}
