package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekMergerMatlis extends InfoMergerTemplate<SchedeekInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, MatlisInfo> getVisitorHook() {
		return new SchedeekVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
