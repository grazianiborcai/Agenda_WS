package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedeekMergerMatlis extends InfoMergerTemplate_<SchedeekInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<SchedeekInfo, MatlisInfo> getVisitorHook() {
		return new SchedeekVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
