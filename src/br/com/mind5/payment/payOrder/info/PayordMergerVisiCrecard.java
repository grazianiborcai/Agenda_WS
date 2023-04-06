package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PayordMergerVisiCrecard extends InfoMergerVisitorTemplate<PayordInfo, CrecardInfo> {

	@Override public boolean shouldMerge(PayordInfo baseInfo, CrecardInfo selectedInfo) {
		return (baseInfo.codOwner 	 	== selectedInfo.codOwner		&&
				baseInfo.codCreditCard  == selectedInfo.codCreditCard		);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, CrecardInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.crecardData    = selectedInfo;
		baseInfo.codPayPartner  = selectedInfo.codPayPartner;		
		baseInfo.codPayCustomer = selectedInfo.codPayCustomer;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<PayordInfo> uniquifyHook(List<PayordInfo> results) {
		InfoUniquifier<PayordInfo> uniquifier = new PayordUniquifier();		
		return uniquifier.uniquify(results);
	}
}
