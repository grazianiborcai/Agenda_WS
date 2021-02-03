package br.com.mind5.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

final class RefemVisiMergePayormarch extends InfoMergerVisitorTemplate<RefemInfo, PayormarchInfo> {

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
}
