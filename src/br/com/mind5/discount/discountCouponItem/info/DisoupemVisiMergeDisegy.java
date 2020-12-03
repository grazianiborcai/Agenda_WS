package br.com.mind5.discount.discountCouponItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;

final class DisoupemVisiMergeDisegy extends InfoMergerVisitorTemplate<DisoupemInfo, DisegyInfo> {

	@Override public boolean shouldMerge(DisoupemInfo baseInfo, DisegyInfo selectedInfo) {
		return (baseInfo.codDiscountStrategy == selectedInfo.codDiscountStrategy);
	}
	
	
	
	@Override public List<DisoupemInfo> merge(DisoupemInfo baseInfo, DisegyInfo selectedInfo) {
		List<DisoupemInfo> results = new ArrayList<>();
		
		baseInfo.txtDiscountStrategy = selectedInfo.txtDiscountStrategy;
		baseInfo.descriptionDiscountStrategy = selectedInfo.descriptionDiscountStrategy;
		
		results.add(baseInfo);
		return results;
	}
}
