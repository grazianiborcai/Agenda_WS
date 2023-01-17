package br.com.mind5.payment.storePartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;

final class StoparMergerVisiRecipa extends InfoMergerVisitorTemplate<StoparInfo, RecipaInfo> {
	@Override public boolean shouldMerge(StoparInfo baseInfo, RecipaInfo selectedInfo) {
		return (baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<StoparInfo> merge(StoparInfo baseInfo, RecipaInfo selectedInfo) {
		List<StoparInfo> results = new ArrayList<>();
		
		baseInfo.idPayPartnerStore = selectedInfo.id;
		
		results.add(baseInfo);
		return results;
	}
}
