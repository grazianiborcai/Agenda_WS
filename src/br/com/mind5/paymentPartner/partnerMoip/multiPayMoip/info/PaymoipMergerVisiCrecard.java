package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PaymoipMergerVisiCrecard extends InfoMergerVisitorTemplate<PaymoipInfo, CrecardInfo> {

	@Override public boolean shouldMerge(PaymoipInfo baseInfo, CrecardInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner 		||
				baseInfo.codCreditCard 	== selectedInfo.codCreditCard		);
	}
	
	
	
	@Override public List<PaymoipInfo> merge(PaymoipInfo baseInfo, CrecardInfo selectedInfo) {
		List<PaymoipInfo> results = new ArrayList<>();
		
		baseInfo.crecardData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
