package br.com.mind5.business.orderStatusChange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

final class OrdugeMergerVisiPayordist extends InfoMergerVisitorTemplate<OrdugeInfo, PayordistInfo> {

	@Override public boolean shouldMerge(OrdugeInfo baseInfo, PayordistInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder);
	}
	
	

	@Override public List<OrdugeInfo> merge(OrdugeInfo baseInfo, PayordistInfo selectedInfo) {
		List<OrdugeInfo> results = new ArrayList<>();
		
	    baseInfo.codPayPartner = selectedInfo.codPayPartner;
		
		results.add(baseInfo);
		return results;
	}
}
