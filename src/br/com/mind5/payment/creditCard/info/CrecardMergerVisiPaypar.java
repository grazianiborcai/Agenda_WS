package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

final class CrecardMergerVisiPaypar extends InfoMergerVisitorTemplate<CrecardInfo, PayparInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, PayparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, PayparInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.txtPayPartner = selectedInfo.txtPayPartner;
		
		results.add(baseInfo);
		return results;
	}
}
