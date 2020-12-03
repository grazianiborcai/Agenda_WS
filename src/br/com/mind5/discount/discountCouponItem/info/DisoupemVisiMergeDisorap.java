package br.com.mind5.discount.discountCouponItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisoupemVisiMergeDisorap extends InfoMergerVisitorTemplate<DisoupemInfo, DisorapInfo> {

	@Override public boolean shouldMerge(DisoupemInfo baseInfo, DisorapInfo selectedInfo) {
		return (baseInfo.codOwner 			 == selectedInfo.codOwner		&&
				baseInfo.codDiscountSnapshot == selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<DisoupemInfo> merge(DisoupemInfo baseInfo, DisorapInfo selectedInfo) {
		List<DisoupemInfo> results = new ArrayList<>();
		
		baseInfo.codDiscountStrategy = selectedInfo.codDiscountStrategy;
		baseInfo.txtDiscountStrategy = selectedInfo.txtDiscountStrategy;
		baseInfo.descriptionDiscountStrategy = selectedInfo.descriptionDiscountStrategy;
		baseInfo.discountPercent = selectedInfo.discountPercent;
		
		results.add(baseInfo);
		return results;
	}
}
