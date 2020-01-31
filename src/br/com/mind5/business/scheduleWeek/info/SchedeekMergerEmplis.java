package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedeekMergerEmplis extends InfoMergerTemplate_<SchedeekInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<SchedeekInfo, EmplisInfo> getVisitorHook() {
		return new SchedeekVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
