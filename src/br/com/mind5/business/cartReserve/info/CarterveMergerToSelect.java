package br.com.mind5.business.cartReserve.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CarterveMergerToSelect extends InfoMergerTemplate_<CarterveInfo, CarterveInfo> {

	@Override protected InfoMergerVisitor_<CarterveInfo, CarterveInfo> getVisitorHook() {
		return new CarterveVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CarterveInfo> getUniquifierHook() {
		return new CarterveUniquifier();
	}
}
