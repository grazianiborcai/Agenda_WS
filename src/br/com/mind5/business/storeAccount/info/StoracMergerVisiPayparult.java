package br.com.mind5.business.storeAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;

final class StoracMergerVisiPayparult extends InfoMergerVisitorTemplate<StoracInfo, PayparultInfo> {
	@Override public boolean shouldMerge(StoracInfo baseInfo, PayparultInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<StoracInfo> merge(StoracInfo baseInfo, PayparultInfo selectedInfo) {
		List<StoracInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		
		results.add(baseInfo);
		return results;
	}
}
