package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusVisiMergeToDelete extends InfoMergerVisitorTemplate<CusInfo, CusInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, CusInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codCustomer == selectedInfo.codCustomer	);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, CusInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
