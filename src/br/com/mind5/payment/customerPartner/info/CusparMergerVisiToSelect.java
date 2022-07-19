package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusparMergerVisiToSelect extends InfoMergerVisitorTemplate<CusparInfo, CusparInfo> {

	@Override public boolean shouldMerge(CusparInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusparInfo> merge(CusparInfo baseInfo, CusparInfo selectedInfo) {
		List<CusparInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
