package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartemVisiMergeCartemarch extends InfoMergerVisitorTemplate<CartemInfo, CartemarchInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, CartemarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, CartemarchInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		CartemInfo result = CartemInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
