package br.com.mind5.discount.discountStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisoreMergerVisiToSelect extends InfoMergerVisitorTemplate<DisoreInfo, DisoreInfo> {
	@Override public boolean shouldMerge(DisoreInfo baseInfo, DisoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<DisoreInfo> merge(DisoreInfo baseInfo, DisoreInfo selectedInfo) {
		List<DisoreInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
