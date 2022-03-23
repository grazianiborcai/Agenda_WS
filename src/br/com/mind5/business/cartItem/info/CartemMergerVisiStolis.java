package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartemMergerVisiStolis extends InfoMergerVisitorTemplate<CartemInfo, StolisInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, StolisInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.stolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
