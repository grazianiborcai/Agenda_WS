package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrderemVisiMergeRefupore extends InfoMergerVisitorTemplate<OrderemInfo, RefuporeInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, RefuporeInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	

	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, RefuporeInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		baseInfo.codRefundPolicyGroup = selectedInfo.codRefundPolicyGroup;
		baseInfo.txtRefundPolicyGroup = selectedInfo.txtRefundPolicyGroup;
		
		results.add(baseInfo);
		return results;
	}
}
