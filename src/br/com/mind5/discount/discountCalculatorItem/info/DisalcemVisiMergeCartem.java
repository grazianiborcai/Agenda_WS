package br.com.mind5.discount.discountCalculatorItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisalcemVisiMergeCartem extends InfoMergerVisitorTemplate<DisalcemInfo, CartemInfo> {

	@Override public boolean shouldMerge(DisalcemInfo baseInfo, CartemInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner	&&
				baseInfo.codUser 	== selectedInfo.codUser);
	}
	
	
	
	@Override public List<DisalcemInfo> merge(DisalcemInfo baseInfo, CartemInfo selectedInfo) {
		List<DisalcemInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		baseInfo.cartemData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
