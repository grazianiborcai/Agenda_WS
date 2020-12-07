package br.com.mind5.business.cartItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartemVisiMergeMatlis extends InfoMergerVisitorTemplate<CartemInfo, MatlisInfo> {

	@Override public boolean shouldMerge(CartemInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<CartemInfo> merge(CartemInfo baseInfo, MatlisInfo selectedInfo) {
		List<CartemInfo> results = new ArrayList<>();
		
		baseInfo.matlisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
