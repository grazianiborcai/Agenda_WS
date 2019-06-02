package br.com.gda.business.orderItem.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerEmplis extends InfoMergerTemplate<OrderemInfo, EmplisInfo> {

	@Override protected InfoMergerVisitorV2<OrderemInfo, EmplisInfo> getVisitorHook() {
		return new OrderemVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
