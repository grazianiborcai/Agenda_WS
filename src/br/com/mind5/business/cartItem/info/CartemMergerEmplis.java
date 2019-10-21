package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemMergerEmplis extends InfoMergerTemplate<CartemInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, EmplisInfo> getVisitorHook() {
		return new CartemVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
