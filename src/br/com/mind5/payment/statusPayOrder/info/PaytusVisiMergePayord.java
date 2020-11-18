package br.com.mind5.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class PaytusVisiMergePayord extends InfoMergerVisitorTemplate<PaytusInfo, PayordInfo> {
	
	@Override public List<PaytusInfo> beforeMerge(List<PaytusInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PaytusInfo baseInfo, PayordInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&&
				baseInfo.codPayOrder == selectedInfo.codPayOrder	);
	}
	
	
	
	@Override public List<PaytusInfo> merge(PaytusInfo baseInfo, PayordInfo selectedInfo) {
		List<PaytusInfo> results = new ArrayList<>();
		
		PaytusInfo result = PaytusInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PaytusInfo> getUniquifier() {
		return new PaytusUniquifier();
	}
}
