package br.com.gda.business.scheduleWeek.info;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedeekMergerCuslis extends InfoMergerTemplate<SchedeekInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, CuslisInfo> getVisitorHook() {
		return new SchedeekVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
