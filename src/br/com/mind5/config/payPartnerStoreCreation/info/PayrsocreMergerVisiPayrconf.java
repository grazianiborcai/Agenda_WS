package br.com.mind5.config.payPartnerStoreCreation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PayrsocreMergerVisiPayrconf extends InfoMergerVisitorTemplate<PayrsocreInfo, PayrconfInfo> {

	@Override public boolean shouldMerge(PayrsocreInfo baseInfo, PayrconfInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PayrsocreInfo> merge(PayrsocreInfo baseInfo, PayrconfInfo selectedInfo) {
		List<PayrsocreInfo> results = new ArrayList<>();
		
		baseInfo.stoparCreation = selectedInfo.stoparCreation;
		
		results.add(baseInfo);
		return results;
	}
}
