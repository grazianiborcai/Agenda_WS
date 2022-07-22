package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

final class OrdmoipMergerVisiPayordist extends InfoMergerVisitorTemplate<OrdmoipInfo, PayordistInfo> {

	@Override public boolean shouldMerge(OrdmoipInfo baseInfo, PayordistInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder);
	}
	
	
	
	@Override public List<OrdmoipInfo> merge(OrdmoipInfo baseInfo, PayordistInfo selectedInfo) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		baseInfo.payordistData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
