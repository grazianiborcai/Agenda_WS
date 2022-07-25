package br.com.mind5.discount.discountStoreSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;

final class DisorapMergerVisiDisegy extends InfoMergerVisitorTemplate<DisorapInfo, DisegyInfo> {

	@Override public boolean shouldMerge(DisorapInfo baseInfo, DisegyInfo selectedInfo) {
		return (baseInfo.codDiscountStrategy == selectedInfo.codDiscountStrategy);
	}
	
	
	
	@Override public List<DisorapInfo> merge(DisorapInfo baseInfo, DisegyInfo selectedInfo) {
		List<DisorapInfo> results = new ArrayList<>();
		
		baseInfo.txtDiscountStrategy = selectedInfo.txtDiscountStrategy;
		baseInfo.descriptionDiscountStrategy = selectedInfo.descriptionDiscountStrategy;
		
		results.add(baseInfo);
		return results;
	}
}
