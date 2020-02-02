package br.com.mind5.business.cartReserve.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class CarterveMerger {	
	public static CarterveInfo mergeToSelect(CarterveInfo selectedInfo, CarterveInfo baseInfo) {
		InfoMerger<CarterveInfo, CarterveInfo> merger = new CarterveMergerToSelect();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CarterveInfo> mergeToSelect(List<CarterveInfo> selectedInfos, List<CarterveInfo> baseInfos) {
		InfoMerger<CarterveInfo, CarterveInfo> merger = new CarterveMergerToSelect();		
		return merger.merge(selectedInfos, baseInfos);
	}	
}
