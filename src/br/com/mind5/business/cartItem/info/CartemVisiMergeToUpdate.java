package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CartemVisiMergeToUpdate extends InfoMergerVisitorTemplate<CartemInfo, CartemInfo> {
	
	@Override public List<CartemInfo> beforeMerge(List<CartemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CartemInfo baseInfo, CartemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, CartemInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.createdOn = selectedInfo.createdOn;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CartemInfo> getUniquifier() {
		return null;
	}
}
