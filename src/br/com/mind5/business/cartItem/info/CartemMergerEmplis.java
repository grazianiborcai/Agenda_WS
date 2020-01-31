package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartemMergerEmplis extends InfoMergerTemplate_<CartemInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<CartemInfo, EmplisInfo> getVisitorHook() {
		return new CartemVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
