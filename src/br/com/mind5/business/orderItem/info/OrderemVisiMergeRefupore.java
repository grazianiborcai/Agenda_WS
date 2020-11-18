package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class OrderemVisiMergeRefupore extends InfoMergerVisitorTemplate<OrderemInfo, RefuporeInfo> {

	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
