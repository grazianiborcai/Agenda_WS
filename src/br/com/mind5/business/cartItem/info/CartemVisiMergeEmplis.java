package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartemVisiMergeEmplis extends InfoMergerVisitorTemplate<CartemInfo, EmplisInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&& 
				baseInfo.codEmployee == selectedInfo.codEmployee	);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, EmplisInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.emplisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
