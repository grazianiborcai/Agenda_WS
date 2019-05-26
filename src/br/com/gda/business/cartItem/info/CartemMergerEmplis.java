package br.com.gda.business.cartItem.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerEmplis extends InfoMergerTemplate<CartemInfo, EmplisInfo> {

	@Override protected InfoMergerVisitorV2<CartemInfo, EmplisInfo> getVisitorHook() {
		return new CartemVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
