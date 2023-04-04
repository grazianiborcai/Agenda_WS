package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class SplitapaMergerVisiSetupar extends InfoMergerVisitorTemplate<SplitapaInfo, SetuparInfo> {

	@Override public boolean shouldMerge(SplitapaInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<SplitapaInfo> merge(SplitapaInfo baseInfo, SetuparInfo selectedInfo) {
		List<SplitapaInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
