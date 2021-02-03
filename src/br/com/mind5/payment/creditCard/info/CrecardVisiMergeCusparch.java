package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

final class CrecardVisiMergeCusparch extends InfoMergerVisitorTemplate<CrecardInfo, CusparchInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, CusparchInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner &&
				baseInfo.codUser 	== selectedInfo.codUser	);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, CusparchInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		baseInfo.codPayCustomer = selectedInfo.codPayCustomer;		
		
		results.add(baseInfo);
		return results;
	}
}
