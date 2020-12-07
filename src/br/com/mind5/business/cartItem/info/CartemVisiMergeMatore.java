package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartemVisiMergeMatore extends InfoMergerVisitorTemplate<CartemInfo, MatoreInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, MatoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore && 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, MatoreInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.price = selectedInfo.matPrice;
		
		if (baseInfo.codWeekday == 1)
			baseInfo.price = selectedInfo.matPrice1;
		
		if (baseInfo.codWeekday == 2)
			baseInfo.price = selectedInfo.matPrice2;
		
		if (baseInfo.codWeekday == 3)
			baseInfo.price = selectedInfo.matPrice3;
		
		if (baseInfo.codWeekday == 4)
			baseInfo.price = selectedInfo.matPrice4;
		
		if (baseInfo.codWeekday == 5)
			baseInfo.price = selectedInfo.matPrice5;
		
		if (baseInfo.codWeekday == 6)
			baseInfo.price = selectedInfo.matPrice6;
		
		if (baseInfo.codWeekday == 7)
			baseInfo.price = selectedInfo.matPrice7;
		
		results.add(baseInfo);
		return results;
	}
}
