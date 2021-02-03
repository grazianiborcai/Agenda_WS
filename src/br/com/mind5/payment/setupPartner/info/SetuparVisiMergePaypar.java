package br.com.mind5.payment.setupPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

final class SetuparVisiMergePaypar extends InfoMergerVisitorTemplate<SetuparInfo, PayparInfo> {

	@Override public boolean shouldMerge(SetuparInfo baseInfo, PayparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<SetuparInfo> merge(SetuparInfo baseInfo, PayparInfo selectedInfo) {
		List<SetuparInfo> results = new ArrayList<>();
		
		baseInfo.txtPayPartner = selectedInfo.txtPayPartner;
		baseInfo.description = selectedInfo.description;
		
		results.add(baseInfo);
		return results;
	}
}
