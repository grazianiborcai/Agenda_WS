package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class SplitapaMergerVisiPayord extends InfoMergerVisitorTemplate<SplitapaInfo, PayordInfo> {

	@Override public boolean shouldMerge(SplitapaInfo baseInfo, PayordInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder);
	}
	
	
	
	@Override public List<SplitapaInfo> merge(SplitapaInfo baseInfo, PayordInfo selectedInfo) {
		List<SplitapaInfo> results = new ArrayList<>();
		
		baseInfo.payordData = selectedInfo;	
		
		results.add(baseInfo);
		return results;
	}
}
