package br.com.mind5.payment.refundOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class RefuVisiMergeOrdist implements InfoMergerVisitorV3<RefuInfo, OrdistInfo> {
	
	@Override public List<RefuInfo> beforeMerge(List<RefuInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefuInfo baseInfo, OrdistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codOrder == selectedInfo.codOrder		);
	}
	
	
	
	@Override public List<RefuInfo> merge(RefuInfo baseInfo, OrdistInfo selectedInfo) {
		List<RefuInfo> results = new ArrayList<>();
		
		baseInfo.codPayOrder = selectedInfo.codPayOrder; 
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefuInfo> getUniquifier() {
		return null;
	}
}
