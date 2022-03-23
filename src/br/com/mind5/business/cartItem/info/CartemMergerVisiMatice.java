package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartemMergerVisiMatice extends InfoMergerVisitorTemplate<CartemInfo, MaticeInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, MaticeInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore && 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, MaticeInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.price = selectedInfo.price;
		baseInfo.codCurr = selectedInfo.codCurr;
		
		results.add(baseInfo);
		return results;
	}
}
