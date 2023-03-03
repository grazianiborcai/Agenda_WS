package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class OrdapaMergerVisiPayord extends InfoMergerVisitorTemplate<OrdapaInfo, PayordInfo> {

	@Override public boolean shouldMerge(OrdapaInfo baseInfo, PayordInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder);
	}
	
	
	
	@Override public List<OrdapaInfo> merge(OrdapaInfo baseInfo, PayordInfo selectedInfo) {
		List<OrdapaInfo> results = new ArrayList<>();
		
		baseInfo.payordData = selectedInfo;	
		
		results.add(baseInfo);
		return results;
	}
}
