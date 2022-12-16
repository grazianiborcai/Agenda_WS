package br.com.mind5.config.payPartnerConfig.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PayrconfMergerVisiToSelect extends InfoMergerVisitorTemplate<PayrconfInfo, PayrconfInfo> {

	@Override public boolean shouldMerge(PayrconfInfo baseInfo, PayrconfInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<PayrconfInfo> merge(PayrconfInfo baseInfo, PayrconfInfo selectedInfo) {
		List<PayrconfInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
