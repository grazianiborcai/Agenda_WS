package br.com.mind5.payment.customerPartner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CusparVisiMergeToSelect extends InfoMergerVisitorTemplate<CusparInfo, CusparInfo> {
	
	@Override public List<CusparInfo> beforeMerge(List<CusparInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<CusparInfo> getUniquifier() {
		return null;
	}
}
