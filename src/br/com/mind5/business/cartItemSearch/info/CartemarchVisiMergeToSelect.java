package br.com.mind5.business.cartItemSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemarchVisiMergeToSelect implements InfoMergerVisitor<CartemarchInfo, CartemarchInfo> {
	
	@Override public List<CartemarchInfo> beforeMerge(List<CartemarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CartemarchInfo baseInfo, CartemarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartemarchInfo> merge(CartemarchInfo baseInfo, CartemarchInfo selectedInfo) {
		List<CartemarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CartemarchInfo> getUniquifier() {
		return null;
	}
}
