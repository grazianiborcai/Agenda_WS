package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;

final class OrderVisiMergeRefugrader implements InfoMergerVisitorV3<OrderInfo, RefugraderInfo> {

	@Override public List<OrderInfo> beforeMerge(List<OrderInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderInfo baseInfo, RefugraderInfo selectedInfo) {
		return (baseInfo.codRefundPolicyGroup == selectedInfo.codRefundPolicyGroup);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, RefugraderInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderInfo> getUniquifier() {
		return null;
	}
}
