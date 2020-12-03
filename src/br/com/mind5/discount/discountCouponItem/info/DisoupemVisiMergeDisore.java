package br.com.mind5.discount.discountCouponItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisoupemVisiMergeDisore extends InfoMergerVisitorTemplate<DisoupemInfo, DisoreInfo> {

	@Override public boolean shouldMerge(DisoupemInfo baseInfo, DisoreInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner		&&
				baseInfo.codStore 	 == selectedInfo.codStore		&&
				baseInfo.codDiscount == selectedInfo.codDiscount		);
	}
	
	
	
	@Override public List<DisoupemInfo> merge(DisoupemInfo baseInfo, DisoreInfo selectedInfo) {
		List<DisoupemInfo> results = new ArrayList<>();
		
		baseInfo.codDiscountSnapshot = selectedInfo.codSnapshot;
		baseInfo.codDiscountStrategy = selectedInfo.codDiscountStrategy;
		baseInfo.txtDiscountStrategy = selectedInfo.txtDiscountStrategy;
		baseInfo.descriptionDiscountStrategy = selectedInfo.descriptionDiscountStrategy;
		baseInfo.discountPercent = selectedInfo.discountPercent;
		baseInfo.validFrom = selectedInfo.validFrom;
		baseInfo.validTo = selectedInfo.validTo;
		
		results.add(baseInfo);
		return results;
	}
}
