package br.com.mind5.config.payPartnerCustomerCreation.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PayrcucreMergerVisiPayrconf extends InfoMergerVisitorTemplate<PayrcucreInfo, PayrconfInfo> {

	@Override public boolean shouldMerge(PayrcucreInfo baseInfo, PayrconfInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PayrcucreInfo> merge(PayrcucreInfo baseInfo, PayrconfInfo selectedInfo) {
		List<PayrcucreInfo> results = new ArrayList<>();
		
		baseInfo.cusparCreation = selectedInfo.cusparCreation;
		
		results.add(baseInfo);
		return results;
	}
}
