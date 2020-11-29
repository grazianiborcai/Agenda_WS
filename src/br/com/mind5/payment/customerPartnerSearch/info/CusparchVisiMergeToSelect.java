package br.com.mind5.payment.customerPartnerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusparchVisiMergeToSelect extends InfoMergerVisitorTemplate<CusparchInfo, CusparchInfo> {

	@Override public boolean shouldMerge(CusparchInfo baseInfo, CusparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusparchInfo> merge(CusparchInfo baseInfo, CusparchInfo selectedInfo) {
		List<CusparchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
