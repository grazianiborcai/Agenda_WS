package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

final class OrderMergerVisiRefugroup extends InfoMergerVisitorTemplate<OrderInfo, RefugroupInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, RefugroupInfo selectedInfo) {
		return (baseInfo.codRefundPolicyGroup == selectedInfo.codRefundPolicyGroup);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, RefugroupInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		
		results.add(baseInfo);
		return results;
	}
}
