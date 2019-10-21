package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekMergerEmplis extends InfoMergerTemplate<SchedeekInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, EmplisInfo> getVisitorHook() {
		return new SchedeekVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
