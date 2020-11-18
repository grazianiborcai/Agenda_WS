package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OrderVisiMergeRefupown extends InfoMergerVisitorTemplate<OrderInfo, RefupownInfo> {

	@Override public List<OrderInfo> beforeMerge(List<OrderInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(OrderInfo baseInfo, RefupownInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, RefupownInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.codRefundPolicyGroup = selectedInfo.codRefundPolicyGroup;
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<OrderInfo> getUniquifier() {
		return null;
	}
}
