package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartemMergerVisiEmplres extends InfoMergerVisitorTemplate<CartemInfo, EmplresInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, EmplresInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&& 
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, EmplresInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.emplresData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
