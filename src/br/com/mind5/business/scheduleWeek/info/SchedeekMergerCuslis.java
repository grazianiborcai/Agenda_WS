package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekMergerCuslis extends InfoMergerTemplate<SchedeekInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, CuslisInfo> getVisitorHook() {
		return new SchedeekVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
