package br.com.mind5.business.cartReserve.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CarterveMergerToSelect extends InfoMergerTemplate<CarterveInfo, CarterveInfo> {

	@Override protected InfoMergerVisitor<CarterveInfo, CarterveInfo> getVisitorHook() {
		return new CarterveVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CarterveInfo> getUniquifierHook() {
		return new CarterveUniquifier();
	}
}
