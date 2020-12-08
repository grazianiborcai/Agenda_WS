package br.com.mind5.discount.discountCalculatorItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisalcemVisiMergeDisoupem extends InfoMergerVisitorTemplate<DisalcemInfo, DisoupemInfo> {

	@Override public boolean shouldMerge(DisalcemInfo baseInfo, DisoupemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore);
	}
	
	
	
	@Override public List<DisalcemInfo> merge(DisalcemInfo baseInfo, DisoupemInfo selectedInfo) {
		List<DisalcemInfo> results = new ArrayList<>();
		
		baseInfo.disoupemData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
