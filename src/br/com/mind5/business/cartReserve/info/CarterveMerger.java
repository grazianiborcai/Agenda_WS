package br.com.mind5.business.cartReserve.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class CarterveMerger {	
	public static CarterveInfo mergeToSelect(CarterveInfo sourceOne, CarterveInfo sourceTwo) {
		InfoMerger<CarterveInfo, CarterveInfo> merger = new CarterveMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CarterveInfo> mergeToSelect(List<CarterveInfo> sourceOnes, List<CarterveInfo> sourceTwos) {
		InfoMerger<CarterveInfo, CarterveInfo> merger = new CarterveMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
