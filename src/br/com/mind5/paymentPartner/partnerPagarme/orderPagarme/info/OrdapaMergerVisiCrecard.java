package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class OrdapaMergerVisiCrecard extends InfoMergerVisitorTemplate<OrdapaInfo, CrecardInfo> {

	@Override public boolean shouldMerge(OrdapaInfo baseInfo, CrecardInfo selectedInfo) {
		return (baseInfo.codOwner 	 	== selectedInfo.codOwner		&&
				baseInfo.codCreditCard  == selectedInfo.codCreditCard		);
	}
	
	
	
	@Override public List<OrdapaInfo> merge(OrdapaInfo baseInfo, CrecardInfo selectedInfo) {
		List<OrdapaInfo> results = new ArrayList<>();
		
		baseInfo.crecardData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
