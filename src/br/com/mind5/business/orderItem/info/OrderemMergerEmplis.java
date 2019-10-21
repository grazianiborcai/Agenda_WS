package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemMergerEmplis extends InfoMergerTemplate<OrderemInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, EmplisInfo> getVisitorHook() {
		return new OrderemVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
