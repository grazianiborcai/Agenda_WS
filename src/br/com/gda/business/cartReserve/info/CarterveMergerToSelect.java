package br.com.gda.business.cartReserve.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CarterveMergerToSelect extends InfoMergerTemplate<CarterveInfo, CarterveInfo> {

	@Override protected InfoMergerVisitor<CarterveInfo, CarterveInfo> getVisitorHook() {
		return new CarterveVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CarterveInfo> getUniquifierHook() {
		return new CarterveUniquifier();
	}
}
