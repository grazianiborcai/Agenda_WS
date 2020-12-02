package br.com.mind5.discount.discountStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;

final class DisoreVisiMergeDisegy extends InfoMergerVisitorTemplate<DisoreInfo, DisegyInfo> {

	@Override public boolean shouldMerge(DisoreInfo baseInfo, DisegyInfo selectedInfo) {
		return (baseInfo.codDiscountStrategy == selectedInfo.codDiscountStrategy);
	}
	
	
	
	@Override public List<DisoreInfo> merge(DisoreInfo baseInfo, DisegyInfo selectedInfo) {
		List<DisoreInfo> results = new ArrayList<>();
		
		baseInfo.txtDiscountStrategy = selectedInfo.txtDiscountStrategy;
		baseInfo.descriptionDiscountStrategy = selectedInfo.descriptionDiscountStrategy;
		
		results.add(baseInfo);
		return results;
	}
}
