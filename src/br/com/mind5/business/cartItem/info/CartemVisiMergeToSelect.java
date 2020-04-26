package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CartemVisiMergeToSelect implements InfoMergerVisitorV3<CartemInfo, CartemInfo> {
	
	@Override public List<CartemInfo> beforeMerge(List<CartemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<CartemInfo> getUniquifier() {
		return null;
	}
}
