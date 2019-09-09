package br.com.gda.business.scheduleWeek.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedeekMergerEmplis extends InfoMergerTemplate<SchedeekInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, EmplisInfo> getVisitorHook() {
		return new SchedeekVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
