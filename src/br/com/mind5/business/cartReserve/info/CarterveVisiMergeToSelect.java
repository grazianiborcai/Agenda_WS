package br.com.mind5.business.cartReserve.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CarterveVisiMergeToSelect extends InfoMergerVisitorTemplate<CarterveInfo, CarterveInfo> {

	@Override public boolean shouldMerge(CarterveInfo baseInfo, CarterveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CarterveInfo> merge(CarterveInfo baseInfo, CarterveInfo selectedInfo) {
		List<CarterveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
