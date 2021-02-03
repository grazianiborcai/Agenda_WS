package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class PayordVisiMergePayordem extends InfoMergerVisitorTemplate<PayordInfo, PayordemInfo> {

	@Override public boolean shouldMerge(PayordInfo baseInfo, PayordemInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner 	&&
				baseInfo.codPayOrder 	== selectedInfo.codPayOrder		);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, PayordemInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.payordems.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<PayordInfo> uniquifyHook(List<PayordInfo> results) {
		InfoUniquifier<PayordInfo> uniquifier = new PayordUniquifier();		
		return uniquifier.uniquify(results);
	}
}
