package br.com.mind5.business.customerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusarchVisiMergeToSelect extends InfoMergerVisitorTemplate<CusarchInfo, CusarchInfo> {

	@Override public boolean shouldMerge(CusarchInfo baseInfo, CusarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusarchInfo> merge(CusarchInfo baseInfo, CusarchInfo selectedInfo) {
		List<CusarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
