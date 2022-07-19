package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

final class CusparMergerVisiCusparch extends InfoMergerVisitorTemplate<CusparInfo, CusparchInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, CusparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, CusparchInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		CusparInfo result = CusparInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
