package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

final class PayordVisiMergeLatest implements InfoMergerVisitorV3<PayordInfo, PayordarchInfo> {
	
	@Override public List<PayordInfo> beforeMerge(List<PayordInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordInfo baseInfo, PayordarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codOrder == selectedInfo.codOrder	);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, PayordarchInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.latestData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordInfo> getUniquifier() {
		return new PayordUniquifier();
	}
}
