package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;

final class CrecardMergerVisiPayparult extends InfoMergerVisitorTemplate<CrecardInfo, PayparultInfo> {
	@Override public boolean shouldMerge(CrecardInfo baseInfo, PayparultInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, PayparultInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		
		results.add(baseInfo);
		return results;
	}
}
