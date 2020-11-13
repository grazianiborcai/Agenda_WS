package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

final class OrderVisiMergeRefugroup implements InfoMergerVisitor<OrderInfo, RefugroupInfo> {

	@Override public List<OrderInfo> beforeMerge(List<OrderInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderInfo baseInfo, RefugroupInfo selectedInfo) {
		return (baseInfo.codRefundPolicyGroup == selectedInfo.codRefundPolicyGroup);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, RefugroupInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderInfo> getUniquifier() {
		return null;
	}
}
