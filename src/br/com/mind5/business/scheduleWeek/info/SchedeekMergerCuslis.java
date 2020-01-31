package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedeekMergerCuslis extends InfoMergerTemplate_<SchedeekInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor_<SchedeekInfo, CuslisInfo> getVisitorHook() {
		return new SchedeekVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
