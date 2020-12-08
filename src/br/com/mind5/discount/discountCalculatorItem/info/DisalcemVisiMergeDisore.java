package br.com.mind5.discount.discountCalculatorItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisalcemVisiMergeDisore extends InfoMergerVisitorTemplate<DisalcemInfo, DisoreInfo> {

	@Override public boolean shouldMerge(DisalcemInfo baseInfo, DisoreInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	&&
				baseInfo.codStore 	 == selectedInfo.codStore);
	}
	
	
	
	@Override public List<DisalcemInfo> merge(DisalcemInfo baseInfo, DisoreInfo selectedInfo) {
		List<DisalcemInfo> results = new ArrayList<>();
		
		baseInfo.disores.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
