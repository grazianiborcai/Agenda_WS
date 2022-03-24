package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

final class OrderemMergerVisiRefugroup extends InfoMergerVisitorTemplate<OrderemInfo, RefugroupInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, RefugroupInfo selectedInfo) {
		return (baseInfo.codRefundPolicyGroup == selectedInfo.codRefundPolicyGroup);
	}
	
	

	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, RefugroupInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		
		results.add(baseInfo);
		return results;
	}
}
