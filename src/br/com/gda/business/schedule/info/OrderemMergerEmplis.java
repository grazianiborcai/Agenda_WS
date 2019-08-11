package br.com.gda.business.schedule.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerEmplis extends InfoMergerTemplate<ScheduInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<ScheduInfo, EmplisInfo> getVisitorHook() {
		return new OrderemVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<ScheduInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
