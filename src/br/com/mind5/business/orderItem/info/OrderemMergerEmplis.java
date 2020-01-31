package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemMergerEmplis extends InfoMergerTemplate_<OrderemInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<OrderemInfo, EmplisInfo> getVisitorHook() {
		return new OrderemVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
