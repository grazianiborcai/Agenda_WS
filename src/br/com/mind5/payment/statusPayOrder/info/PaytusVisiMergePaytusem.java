package br.com.mind5.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

final class PaytusVisiMergePaytusem implements InfoMergerVisitor<PaytusInfo, PaytusemInfo> {
	
	@Override public List<PaytusInfo> beforeMerge(List<PaytusInfo> baseInfos) {
		for (PaytusInfo eachBase : baseInfos) {
			eachBase.paytusems = new ArrayList<>();
		}		
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PaytusInfo baseInfo, PaytusemInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&&
				baseInfo.codPayOrder == selectedInfo.codPayOrder	);
	}
	
	
	
	@Override public List<PaytusInfo> merge(PaytusInfo baseInfo, PaytusemInfo selectedInfo) {
		List<PaytusInfo> results = new ArrayList<>();
		
		baseInfo.paytusems.add(selectedInfo); 
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PaytusInfo> getUniquifier() {
		return new PaytusUniquifier();
	}
}
