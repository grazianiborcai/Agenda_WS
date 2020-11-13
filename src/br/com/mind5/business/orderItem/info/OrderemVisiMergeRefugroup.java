package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

final class OrderemVisiMergeRefugroup implements InfoMergerVisitor<OrderemInfo, RefugroupInfo> {

	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderemInfo baseInfo, RefugroupInfo selectedInfo) {
		return (baseInfo.codRefundPolicyGroup == selectedInfo.codRefundPolicyGroup);
	}
	
	

	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, RefugroupInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
