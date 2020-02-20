package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class PayordVisiMergePayordem implements InfoMergerVisitorV3<PayordInfo, PayordemInfo> {
	
	@Override public List<PayordInfo> beforeMerge(List<PayordInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<PayordInfo> getUniquifier() {
		return new PayordUniquifier();
	}
}
