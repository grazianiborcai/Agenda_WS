package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class RecipaMergerVisiSetupar extends InfoMergerVisitorTemplate<RecipaInfo, SetuparInfo> {

	@Override public boolean shouldMerge(RecipaInfo baseInfo, SetuparInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<RecipaInfo> merge(RecipaInfo baseInfo, SetuparInfo selectedInfo) {
		List<RecipaInfo> results = new ArrayList<>();
		
		baseInfo.setuparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
