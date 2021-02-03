package br.com.mind5.payment.creditCard.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class CrecardVisiMergeCusparInsert extends InfoMergerVisitorTemplate<CrecardInfo, CusparInfo> {

	@Override public boolean shouldMerge(CrecardInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner 	   == selectedInfo.codOwner &&
				baseInfo.codUser       == selectedInfo.codUser  &&
				baseInfo.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<CrecardInfo> merge(CrecardInfo baseInfo, CusparInfo selectedInfo) {
		List<CrecardInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		baseInfo.codPayCustomer = selectedInfo.codPayCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
