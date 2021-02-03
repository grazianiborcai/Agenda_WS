package br.com.mind5.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class PaytusVisiMergeUsername extends InfoMergerVisitorTemplate<PaytusInfo, UsernameInfo> {

	@Override public boolean shouldMerge(PaytusInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<PaytusInfo> merge(PaytusInfo baseInfo, UsernameInfo selectedInfo) {
		List<PaytusInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<PaytusInfo> uniquifyHook(List<PaytusInfo> results) {
		InfoUniquifier<PaytusInfo> uniquifier = new PaytusUniquifier();		
		return uniquifier.uniquify(results);
	}
}
