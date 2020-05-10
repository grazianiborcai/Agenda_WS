package br.com.mind5.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

final class RefemVisiMergePayormarch implements InfoMergerVisitorV3<RefemInfo, PayormarchInfo> {
	
	@Override public List<RefemInfo> beforeMerge(List<RefemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(RefemInfo baseInfo, PayormarchInfo selectedInfo) {
		return ( baseInfo.codOwner 	   == baseInfo.codOwner &&
				 baseInfo.codOrder 	   == baseInfo.codOrder &&
				 baseInfo.codOrderItem == baseInfo.codOrderItem );
	}
	
	
	
	@Override public List<RefemInfo> merge(RefemInfo baseInfo, PayormarchInfo selectedInfo) {
		List<RefemInfo> results = new ArrayList<>();
		
		baseInfo.codPayOrder = selectedInfo.codPayOrder;
		baseInfo.codPayOrderItem = selectedInfo.codPayOrderItem;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<RefemInfo> getUniquifier() {
		return null;
	}
}