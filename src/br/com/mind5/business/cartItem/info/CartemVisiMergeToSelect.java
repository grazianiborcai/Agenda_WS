package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartemVisiMergeToSelect extends InfoMergerVisitorTemplate<CartemInfo, CartemInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, CartemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, CartemInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
