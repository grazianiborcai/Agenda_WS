package br.com.mind5.discount.discountCouponItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisoupemMergerVisiToSelect extends InfoMergerVisitorTemplate<DisoupemInfo, DisoupemInfo> {
	@Override public boolean shouldMerge(DisoupemInfo baseInfo, DisoupemInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<DisoupemInfo> merge(DisoupemInfo baseInfo, DisoupemInfo selectedInfo) {
		List<DisoupemInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
